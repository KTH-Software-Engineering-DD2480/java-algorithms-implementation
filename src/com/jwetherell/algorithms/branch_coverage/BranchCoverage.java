package com.jwetherell.algorithms.branch_coverage;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.Map.Entry;

import java.util.TreeMap;

public class BranchCoverage {
    /**
     * A single scope within a function or other logical unit.
     */
    public static class Scope {
        /**
         * Name of the scope.
         */
        String name;

        /**
         * Valid identifiers in this scope.
         */
        String[] identifiers;

        /**
         * For each identifier in the scope: the number of times it has been reached.
         */
        HashMap<String, Long> counters;

        Scope(String name, String[] identifiers) {
            this.name = name;
            this.identifiers = identifiers;
            counters = new HashMap<String, Long>(identifiers.length);
            for (String identifier : identifiers) {
                counters.put(identifier, 0L);
            }
        }

        /**
         * Register that the branch corresponding to the identifier has been reached.
         * @param identifier A unique identifier for a branch. Must be one of the identifiers the scope was created with.
         */
        public void reached(String identifier) {
            Long count = counters.get(identifier);
            if (count == null) {
                throw new RuntimeException("invalid identifier `%s` for scope `%s`".formatted(identifier, this.name));
            }
            counters.put(identifier, count + 1);
        }
    }

    /**
     * Summary of the branch recorded coverage.
     */
    public static class Report  {
        /**
         * Maps a scope's name to a summary of the branch coverage within that scope.
         */
        public SortedMap<String, ScopeReport> scopes;
    
        /**
         * Summary of the reached branches within a single scope.
         */
        public static class ScopeReport {
            /**
             * The list of identifiers used to create the scope.
             */
            public String[] identifiers;

            /**
             * For each identifier: how many times that branch has been reached.
             */
            public long[] counts;
        }

        /**
         * Creates a human-readable representation of the report
         */
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (Entry<String, ScopeReport> entry : scopes.entrySet()) {
                String name = entry.getKey();
                ScopeReport scope = entry.getValue();

                builder.append(name).append(":\n");
                for (int i = 0; i < scope.identifiers.length; i++) {
                    String identifier = scope.identifiers[i];
                    long count = scope.counts[i];
                    builder.append("  - ").append(identifier).append(": ").append(count);

                    if (count == 0) {
                        builder.append(" <-- NOT REACHED");
                    }

                    builder.append("\n");
                }
            }
            return builder.toString();
        }
    }

    /**
     * Mapping from scope identifiers to their corresponding scopes.
     */
    static HashMap<String, Scope> scopes = new HashMap<String, Scope>();

    /**
     * Begin a new scope for tracking branch coverage. 
     * A scope could be an entire function or other logical unit.
     * @param name The name of the scope. This should be a unique identifier.
     * @param identifiers A list of unique identifiers that occurs in the given scope. This will be used to identify branches that were not reached.
     */
    public static Scope beginScope(String name, String[] identifiers) {
        Scope oldScope = scopes.get(name);
        if (oldScope != null) return oldScope;
        Scope newScope = new Scope(name, identifiers);
        scopes.put(name, newScope);
        return newScope;
    }

    /**
     * @return A summary of the recorded branch coverage (so far).
     */
    public static Report createReport() {
        Report report = new Report();
        report.scopes = new TreeMap<String, Report.ScopeReport>();

        for (Entry<String, Scope> entry : scopes.entrySet()) {
            String name = entry.getKey();
            Scope scope = entry.getValue();

            Report.ScopeReport scopeReport = new Report.ScopeReport();
            scopeReport.identifiers = scope.identifiers;
            scopeReport.counts = new long[scope.identifiers.length];
            for (int i = 0; i < scope.identifiers.length; i++) {
                scopeReport.counts[i] = scope.counters.get(scope.identifiers[i]);
            }
            report.scopes.put(name, scopeReport);
        }

        return report;
    }

    /**
     * Class that is run as the program shuts down
     */
    static class ShutdownReportPrinter extends Thread {
        public void run() {
            String outFile = "branch-coverage-report.txt";

            Report report = createReport();

            System.out.println("branch coverage report (see also `%s`:".formatted(outFile));
            System.out.println(report.toString().indent(2));

            try {
                FileWriter fw = new FileWriter(outFile, false);
                fw.write(report.toString());
                fw.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    static {
        // Register the printer to be run right before the program terminates.
        Runtime.getRuntime().addShutdownHook(new ShutdownReportPrinter());
    }
}
