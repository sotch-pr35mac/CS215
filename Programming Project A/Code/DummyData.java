/*
*	@Author Preston Stosur-Bassett
*	@Date Jan 25, 2015
*	@Class DummyData
*	@Description This class contains methods to generate dummy data given a set of parameters. 
*/

import java.util.ArrayList;

public class DummyData {

	/*
	*	@Description runArrayList will take an ArrayList of Integer Objects and add a given amount of values to it
	*	@param int start the starting value to add to the array list
	*	@param int end the ending value to denote when to stop adding to the array list
	*	@param int iterator the amount to increase <code>start</code> variable by after each iteration
	*	@param ArrayList<Integer> list the list to add value to and return
	*	@return ArrayList<Integer> the list after it has been updated with the given data
	*/
	public static ArrayList<Integer> runArrayList(int start, int end, int iterator, ArrayList<Integer> list) {
		int counter = start;
		while(start < end) {
			Integer intToAdd = new Integer(counter);
			list.add(intToAdd);

			//Count up on the iterators
			counter++;
			start = start + iterator;
		}

		return list;
	}
}