package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.MinEditDistanceFinder;

class TestMinEditDistanceFinder {

	@Test
	public void test_SameStringsHaveDistanceZero() {
		MinEditDistanceFinder medf = new MinEditDistanceFinder();
		int d = medf.findEditDistance("hello", "hello");
		assertEquals(0,d);
	}
	
	@Test
	public void test_EmptyStringsHaveDistanceZero() {
		MinEditDistanceFinder medf = new MinEditDistanceFinder();
		int d = medf.findEditDistance("", "");
		assertEquals(0,d);
	}
	
	@Test
	public void test_DistanceToEmptyStringEqualsLength() {
		MinEditDistanceFinder medf = new MinEditDistanceFinder();
		int d = medf.findEditDistance("hello", "");
		assertEquals("hello".length(), d);
	}
	
	@Test
	public void test_DistanceToEmpyStringEqualsLengthTranspose() {
		MinEditDistanceFinder medf = new MinEditDistanceFinder();
		int d = medf.findEditDistance("", "hello");
		assertEquals("hello".length(), d);
	}
	
	@Test
	public void test_DistanceBetweenHiAndBiIsTwo() {
		MinEditDistanceFinder medf = new MinEditDistanceFinder();
		int d = medf.findEditDistance("Hi", "Bi");
		assertEquals(2,d);
	}
	
	@Test
	public void test_DistanceBetweenBoyAndBuoyIsOne() {
		MinEditDistanceFinder medf = new MinEditDistanceFinder();
		int d = medf.findEditDistance("boy", "buoy");
		assertEquals(1,d);
	}
}
