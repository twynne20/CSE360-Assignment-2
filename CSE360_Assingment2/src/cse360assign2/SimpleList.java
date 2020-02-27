/*
* Tyson Wynne
* Class ID: 425
* CSE 360 Assignment 2
* This file below contains a class SimpleList in which we are able to 
* do basic manipulations to an array such as add, remove, search, append,
* and count elements. Additionally, we should be able to convert this to 
* a string that prints the array. We took this code from Assignment 1 and 
* made changes to practice using Git. There should be 2 versions of this. 
* We added the functions append, first, size, and made changes to add and 
* remove. 
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
	 * This function should add the add the parameter to the beginning of 
	 * the list. (index = 0) Shift all other elements, if element is at the
	 *  end it will fall off. Must properly adjust the count. 
	 */
	public void add(int element) {
		// ASSIGN2: If the array is FULL, add half the size
		// Calculate 50% of the list length and round down
		// Copy the original list into the new with 50% space added
		if (count == list.length) {
			// New size is original + 50% of the length 
			int newsize;
			if (list.length == 0)
			{
				newsize = 1;
				System.out.println("ERROR");
			}
			if (list.length == 1) 
				newsize = 2;
			else
				newsize = list.length + (int) Math.floor(list.length / 2);
			
			list = Arrays.copyOf(list, newsize);
		}
		
		for (int index = count - 1; index >= 0; index--) {
			list[index + 1] = list[index];
		}
		list[0] = element;
		count++;
	}
	
	/*
	 * If the parameter passed is in the list we will remove it. If an element is in 
	 * the list we should shift the list to the left with a removal. Must properly 
	 * adjust the count. 
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
		
		/* If the element was found we will need to shift all values after element 
		 * location back by 1
		 */
		if (elementlocation != -1) 
		{
			for (int index = elementlocation; index < count; index++)
			{
				list[index] = list[index + 1];
			}
			list[count - 1] = 0;
			count --;
		}
		
		/* 
		 * If the list has more than 25% empty spaces, decrease the size of the list. 
		 * Had to use list.length > 3 due to index issues. 
		*/
		while(count < list.length * 0.75 & list.length > 3) {
			list = Arrays.copyOf(list,  list.length - 1);
		}
		
	}
	
	/*
	 * Return the number of elements stored in the list. 
	 */
	public int count() {
		return count;
	}
	
	/*
	 * Return the list as a String. The elements should be separated by a space,
	 *  with no space after the last.
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
	
	
	public void append(int element) {
		// If the list if is full 
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
		}
		// Append the parameter to the end of the list
		list[count] = element;
		count++;
	}
	
	// Return the first element in the list
	public int first() {
		if(count >= 1) 
			return list[0];
		else 
			return -1;
	}		
	
	// Return the current number of possible location in the list. 
	public int size() {
		return list.length - count;
	}
	
}
