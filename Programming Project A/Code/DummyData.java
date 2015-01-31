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
	*	@param int start the starting value to add to the array list
	*	@param int end the ending value to denote when to stop adding to the array list
	*	@param int min the minimum value of the randomly generated data.
	*	@param int max the maximum value of the randomly generated data.
	*	@param ArrayList<Integer> list the list to add value to and return
	*	@return ArrayList<Integer> the list after it has been updated with the randomly generated data
	*/
	public static ArrayList<Integer> runArrayList(int start, int end, int min, int max, ArrayList<Integer> list) {
		Random random = new Random();
		// TODO: Write loop invariant
		while(start < end) {
			Integer intToAdd = new Integer(random.nextInt((max - min + 1) + min));
			list.add(intToAdd);

			//Count up on the iterator
			start++;
		}

		return list;
	}

	/*
	*	@Description: runArrayList<String> will take an ArrayList of String Objects and add a given amount of String numerical values to it
	*	@param int start the starting value to add to the array list
	*	@param int end the ending value to denote when to stop adding to the array list
	*	@param ArrayList<String> list the list to add String values to and return
	*	@return ArrayList<String> the list after it has been updated with the randomly generated numerical String values
	*/
	public static ArrayList<String> runArrayList(int start, int end, ArrayList<String> list) {
		Random random = new Random();
		// TODO: Write loop invariant
		while(start < end) {
			Integer intToString = new Integer(random.nextInt((1000000 - 1) + 1));
			String intString = String.valueOf(intToString);
			list.add(intString);

			//Count up on the iterator
			start++;
		}

		return list;
	}
}
