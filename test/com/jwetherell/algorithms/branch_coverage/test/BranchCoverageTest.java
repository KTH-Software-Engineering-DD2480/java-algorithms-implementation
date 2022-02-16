package com.jwetherell.algorithms.branch_coverage.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.jwetherell.algorithms.branch_coverage.BranchCoverage;

import org.junit.Test;

public class BranchCoverageTest {
    /**
     * Showcasing how to use the @{code BranchCoverage} class.
     */
    @Test
    public void branchCoverageWithNotReached() {
        // First we declare a new scope with the given name. 
        // By convention we use the format "<class name>.<method name>".
        // 
        // We also provide a list of all the branch identifiers to use. 
        // By convention the identifiers should be in the same order as they are occur in the code below.
        BranchCoverage.Scope scope = BranchCoverage.beginScope("BranchCoverageTest.branchCoverageWithNotReached", new String[]{
            "entry point",
            "not reached",
        });

        // this should get `count = 1`
        scope.reached("entry point");

        if (false) {
            // this is unreachable and should get `count = 0`
            scope.reached("not reached");
        }

        try {
            // all identifiers must be listed when the scope is created, so this will fail
            scope.reached("invalid");

            // an exception should be thrown, so this shouldn't be reached.
            fail();
        } catch (RuntimeException e) {
            assertEquals("invalid identifier `invalid` for scope `BranchCoverageTest.branchCoverageWithNotReached`", e.getMessage());
        }

        // Get a summary of the report (one is automatically saved to the file `branch-coverage-report.txt` once the program terminates).
        BranchCoverage.Report report = BranchCoverage.createReport();

        assertTrue(report.toString().contains(
            "BranchCoverageTest.branchCoverageWithNotReached:\n" 
            + "  - entry point: 1\n" 
            + "  - not reached: 0 <-- NOT REACHED\n"
        ));
    }
}
