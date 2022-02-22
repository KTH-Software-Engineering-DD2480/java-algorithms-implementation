package com.jwetherell.algorithms.mathematics.test;

import com.jwetherell.algorithms.mathematics.Coprimes;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CoprimesTest {

    @Test
    public void totientTest(){
        final List<Long> args = Arrays.asList(1L, 17L, 96L, 498L, 4182119424L);
        final List<Long> expected = Arrays.asList(1L, 16L, 32L, 164L, 1194891264L);

        for(int i = 0; i < args.size(); i++)
            assertEquals(expected.get(i), Coprimes.getNumberOfCoprimes(args.get(i)));
    }

    @Test
    public void returnsZeroIfOne(){
        long input = -1;
        long result = 0;
        assertEquals(result, Coprimes.getNumberOfCoprimes(input));
    }
}
