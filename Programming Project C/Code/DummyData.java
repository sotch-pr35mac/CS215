/*
*	@Author Preston Stosur-Bassett
*	@Date Jan 25, 2015
*	@Class DummyData
*	@Description This class contains methods to generate dummy data given a set of parameters.
*/

import java.util.ArrayList;
import java.util.Random;

public class DummyData {

	/*
	*	@Description runArrayList<Integer> will take an ArrayList of Integer Objects and add a given amount of values to it
	*	@param int end the ending value to denote when to stop adding to the array list
	*	@param int min the minimum value of the randomly generated data.
	*	@param int max the maximum value of the randomly generated data.
	*	@param ArrayList<Integer> list the list to add value to and return
	*	@return ArrayList<Integer> the list after it has been updated with the randomly generated data
	*/
	public static ArrayList<Integer> runArrayList(int end, int min, int max, ArrayList<Integer> list) {
		Random random = new Random();
		Debug debugger = new Debug();
		int start = 0;
		// INVARIANT: A.length >= start
		// INITIALIZATION: start = 0, A.length can be longer than 0 when initially passed, but not smaller, so our invariant holds
		debugger.assertGreatEquals(list.size(), start);
		while(start < end) {
			// MAINTANANCE: At the beginning of each iteration, one element was added to A and start was increased by one, therefore, our invariant holds true.
			debugger.assertGreatEquals(list.size(), start);
			Integer intToAdd = new Integer(random.nextInt((max - min + 1) + min));
			if(intToAdd != 0) {
				list.add(intToAdd);

				start++;
			} 
		}
		/*TERMINATION: The negation of the guard implies that (end - start) number of elements have been added to A, since start is initialized as 0 at the beginning of the method and is
			incremented by 1 each iteration of the loop, which means that start amount of elements have been added to A, and so our invariant holds true.	*/
		debugger.assertGreatEquals(list.size(), start);

		return list;
	}

	/*
	*	@Description: runArrayList<String> will take an ArrayList of String Objects and add a given amount of String numerical values to it
	*	@param int end the ending value to denote when to stop adding to the array list
	*	@param ArrayList<String> list the list to add String values to and return
	*	@return ArrayList<String> the list after it has been updated with the randomly generated numerical String values
	*/
	public static ArrayList<String> runArrayList(int end, ArrayList<String> list) {
		Random random = new Random();
		Debug debugger = new Debug();
		int start = 0;
		// INVARIANT: A.length >= start
		// INITIALIZATION: Before the first iteration of the loop, start = 0 and A.length cannot be less than 0, so our invariant holds true
		debugger.assertGreatEquals(list.size(), start);
		while(start < end) {
			// MAINTENANCE: At the beginning of each iteration of the loop our invariant holds because for each iteration of the loop one element is added to A and start is incremented by 1
			debugger.assertGreatEquals(list.size(), start);
			Integer intToString = new Integer(random.nextInt((1000000 - 1) + 1));
			String intString = String.valueOf(intToString);
			list.add(intString);

			//Count up on the iterator
			start++;
		}
		/* TERMINATION: The negation of the guard implies that (end - start) number of elements have been added to A, since start is initialized as 0 at the beginning of the method and is
				incremented by 1 each iteration of the loop, which means that start amount of elements have been added to A, and so our invariant holds true. */
		debugger.assertGreatEquals(list.size(), start);

		return list;
	}

	/*
	*	@Description: identicalElement will take an element and add it to the ArrayList<Integer> for a given amount of times
	*	@param int end the ending value to denote when to stop adding elements to the array
	*	@param int element the element to add over and over again to the array
	*	@param ArrayList<Integer> list the list to add elements to
	*	@return ArrayList<Integer> the list after it has been updated with the given data
	*/
	public static ArrayList<Integer> identicalElement(int end, int element, ArrayList<Integer> list) {
		// INVARIANT: A.length >= start
		int start = 0;
		Debug debugger = new Debug();
		//The element to add over and over again
		Integer iden = new Integer(element);
		// INITIALIZATION: Before the first iteration of th eloop, start = 0 and A.length cannot equal anything less than 0, so our invariant holds true
		debugger.assertGreatEquals(list.size(), start);
		while(start < end) {
			// MAINTENANCE: At the beginning of each iteration of the loop our invariant holds because for each iteration of the loop one element is added to A and start is incremented by 1
			debugger.assertGreatEquals(list.size(), start);
			list.add(iden);

			//Count up on the iterator
			start++;
		}
		/* TERMINATION: The negation of the gaurd implies that (end - start) number of elements hav ebeen added to A, since start is initialied as 0 at the beginning of the method and is
				incremented by 1 each iteration of the loop, which means that start amount of elements have been added to A, and so our invariant holds true	*/
		debugger.assertGreatEquals(list.size(), start);

		return list;
	}
}
