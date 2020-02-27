/*
* Tyson Wynne
* Class ID: 425
* CSE 360 Assignment 2
* The following code below is a JUnit Test for SimpleList.java
* this code works to test and validate the correctness of our 
* methods in SimpleList.java. 
*/

package cse360assign2;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleListTest {

	SimpleList testsimple = new SimpleList();
	
	@Test
	public void testInitialization() {
		int expectedValue = 10;
		int actualValue = testsimple.list.length;
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testAdd() {
		// Verify that elements are being added
		testsimple.add(1);
		testsimple.add(2);
		testsimple.add(3);
		testsimple.add(4);
		testsimple.add(5);
		testsimple.add(6);
		testsimple.add(7);
		testsimple.add(8);
		testsimple.add(9);
		testsimple.add(10);
		testsimple.add(11);
		
		/*
		for (int i : testsimple.list) {
			System.out.println(i);
		}
		
		System.out.println(testsimple.list.length);
		*/
	
		String expectedValue = "11 10 9 8 7 6 5 4 3 2 1";
		String actualValue = testsimple.toString();
		assertEquals(expectedValue, actualValue);
		
		// Overflow the array and element should 'fall off'
		testsimple.add(7);
		testsimple.add(8);
		testsimple.add(9);
		testsimple.add(10);
		testsimple.add(11);
		
		expectedValue = "11 10 9 8 7 11 10 9 8 7 6 5 4 3 2 1";
		actualValue = testsimple.toString();
		assertEquals(expectedValue, actualValue);
		
		// Verify the count after overflow is still 10
		int expectedCount = 16;
		int actualCount = testsimple.count;
		assertEquals(expectedCount, actualCount);
	}
	
	@Test
	public void testCount() {
		testsimple.add(1);
		testsimple.add(2);
		testsimple.add(3);
		testsimple.add(4);
		testsimple.add(5);
		testsimple.add(6);
		testsimple.remove(3);
		testsimple.remove(4);
		testsimple.remove(1);
		
		int expectedValue = 3;
		int actualValue = testsimple.count();
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void testRemove() {
		testsimple.remove(3);
		
		int expectedValue = 0;
		int actualValue = testsimple.count();
		assertEquals(expectedValue, actualValue);
		
//		System.out.println(testsimple.list.length);
//		testsimple.add(5);
//		testsimple.add(6);
//		System.out.println(testsimple.list.length);
//		for (int i : testsimple.list) {
//			System.out.println(i);
//		}
//		testsimple.remove(6);
//		for (int i : testsimple.list) {
//			System.out.println(i);
//		}
//		System.out.println(testsimple.list.length);
//		for (int i : testsimple.list) {
//			System.out.println(i);
//		}
	}	
	
	
	@Test
	public void testFirst() {
		System.out.println(testsimple.first());
	
//		int expectedValue = 0;
//		int actualValue = testsimple.count();
//		assertEquals(expectedValue, actualValue);	
		
	}	
	
	@Test
	public void testSize() {
		testsimple.add(4);
		testsimple.add(8);
		testsimple.add(2);
		testsimple.add(9);
		System.out.println("The spaces left in array: ");
		System.out.println(testsimple.size());
		testsimple.remove(2);
		System.out.println("The spaces left in array: ");
		System.out.println(testsimple.size());
		testsimple.add(3);
		testsimple.add(5);
		testsimple.add(7);
		System.out.println("The length now is: ");
		System.out.println(testsimple.list.length);
		testsimple.add(6);
		System.out.println("The array right now is: ");
		for (int i : testsimple.list) {
			System.out.println(i);
		}
		System.out.println("The length now is: ");
		System.out.println(testsimple.list.length);
		testsimple.add(11);
		testsimple.add(66);
		testsimple.add(666);
		testsimple.add(77);
		System.out.println("The length now is: ");
		System.out.println(testsimple.list.length);
		
		System.out.println("The spaces left in array: ");
		System.out.println(testsimple.size());
		System.out.println("The array right now is: ");
		for (int i : testsimple.list) {
			System.out.println(i);
		}
		
	}
	
	@Test 
	public void testAppend() {
		System.out.println("Starting append now");
		System.out.println(testsimple.list.length);
		System.out.println("The array right now is: ");
		for (int i : testsimple.list) 
			System.out.println(i);
		testsimple.add(4);
		testsimple.add(8);
		testsimple.add(2);
		testsimple.add(9);
		testsimple.append(3);
		System.out.println("The array right now is: ");
		for (int i : testsimple.list) 
			System.out.println(i);
		testsimple.remove(4);
		System.out.println("The array right now is: ");
		for (int i : testsimple.list) 
			System.out.println(i);
	}
	
	
	
	
	
}
