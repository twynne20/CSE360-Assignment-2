/*
* Tyson Wynne
* Class ID: 425
* CSE 360 Assignment 2
* This file below contains a class SimpleList in which we are able to 
* do basic manipulations to an array such as add, remove, search, and 
* count elements. Additionally, we should be able to convert this to a 
* a string that prints the array.
*/

package cse360assign2;
import java.util.Arrays;
/*
 * 
 */
public class SimpleList {
	int[] list;
	int count;
	
	/*
	 * Create an array to hold 10 integers and set count to 0.
	 */
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	/*
	 * This function should add the add the parameter to the beginning of the list. (index = 0)
	 * Shift all other elements, if element is at the end it will fall off. Must properly adjust the count. 
	 */
	public void add(int element) {
		// Out of bounds -> decrement 
		// ASSIGN2: If the array is FULL, add half the size
		// Calculate 50% of the list length and round down
		// Copy the original list into the new with 50% space added
		if (count == list.length) {
			// New size is original + 50% of the length 
			int newsize;
			if (list.length == 0)
				newsize = 1;
			if (list.length == 1) 
				newsize = 2;
			else
				newsize = list.length + (int) Math.floor(list.length / 2);
			list = Arrays.copyOf(list, newsize);
			// count--;
		}
		for (int index = count - 1; index >= 0; index--) {
			list[index + 1] = list[index];
		}
		list[0] = element;
		count++;
	}
	
	/*
	 * If the parameter passed is in the list we will remove it. If an element is in the list
	 * we should shift the list to the left with a removal. Must properly adjust the count. 
	 */
	public void remove(int element) {	
		int elementlocation = -1;
		
		// Find if the element is in the array and if store elements location.
		// If not found element location remain -1
		for (int index = 0; index < list.length; index++)
		{
			if (list[index] == element)
				elementlocation = index;
		}
		
		// If the element was found we will need to shift all values after element location back by 1
		if (elementlocation != -1) 
		{
			for (int index = elementlocation; index < count; index++)
			{
				list[index] = list[index + 1];
			}
			list[count - 1] = 0;
			count --;
		}
		
		// ASSIGN2
		// If the list has more than 25% empty spaces, decrease the size of the list
//		if(count == 0) {
//			list = {};
//		}
		
		
		while(count < list.length * 0.25 & list.length > 1) {
			list = Arrays.copyOf(list, list.length - 1);
		}
		
	}
	
	/*
	 * Return the number of elements stored in the list. 
	 */
	public int count() {
		return count;
	}
	
	/*
	 * Return the list as a String. The elements should be separated by a space, with no space after the last.
	 */
	public String toString() {
		String stringbean = "";
		
		StringBuilder sb = new StringBuilder();
		
		for (int index = 0; index < count; index++)
		{
			sb.append(stringbean);
			sb.append(list[index]);
			stringbean = " ";
		}
				
		// Converting from string build to string 
		String mylist = sb.toString();
		
		return mylist;
	}
	
	/* 
	 * Return the location of the parameter in list. If not present
	 * then return -1.
	 */ 
	public int search(int element) {
		int location = -1;
		
		for (int index = 0; index < list.length; index++)
			if (list[index] == element)
				location = index;
			
		return location;
	}
	
}
