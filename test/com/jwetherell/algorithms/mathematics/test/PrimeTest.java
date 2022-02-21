package com.jwetherell.algorithms.mathematics.test;

import com.jwetherell.algorithms.mathematics.Primes;
import org.junit.Test;

import java.beans.Transient;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeTest {

	@Test
	public void assertFalseIfOne(){
		int number = 1;
		boolean isPrime = Primes.isPrime(number);
		assertFalse("isPrime error. isPrime=" + isPrime, isPrime);
	}

	@Test
	public void assertTrueIfTwoOrThree(){
		int number = 2;
		boolean isPrime = Primes.isPrime(number);
		assertTrue("isPrime error. isPrime=" + isPrime, isPrime);

		number = 3;
		isPrime = Primes.isPrime(number);
		assertTrue("isPrime error. isPrime=" + isPrime, isPrime);
	}

	@Test
	public void assertTrueIfFiveOrSeven(){
		int number = 5;
		boolean isPrime = Primes.isPrime(number);
		assertTrue("isPrime error. isPrime=" + isPrime, isPrime);

		number = 7;
		isPrime = Primes.isPrime(number);
		assertTrue("isPrime error. isPrime=" + isPrime, isPrime);
	}

	@Test
	public void assertFalseIfMultipleOfThree(){
		int number = 12;
		boolean isPrime = Primes.isPrime(number);
		assertFalse("isPrime error. isPrime=" + isPrime, isPrime);

		number = 333;
		isPrime = Primes.isPrime(number);
		assertFalse("isPrime error. isPrime=" + isPrime, isPrime);
	}

	@Test
	public void assertFalseForTheRemainingTwoCases(){
		int number = 445;
		boolean isPrime = Primes.isPrime(number);
		assertFalse("isPrime error. isPrime=" + isPrime, isPrime);

		number = 539;
		isPrime = Primes.isPrime(number);
		assertFalse("isPrime error. isPrime=" + isPrime, isPrime);
	}
}
