/*
*	@Author: Preston Stosur-Bassett
*	@Date: Jan 24, 2015
*	@Class: Sort
*	@Description: This class will contain many methods that will sort generic data types using common sorting algorithms.
*/

import java.util.ArrayList;

public class Sort<T extends Comparable<T>> {
	/*
	*	@Pre-Condition: ArrayList<T> unsorted is an unsorted ArrayList of a comparable data type that is non-empty
	*	@Post-Condition: ArrayList<T> will return a permutation of <code>unsorted</code> that will be in increasing order
	*	@Description: Insertion will sort an ArrayList of generic type T in increasing order using an insertion sort
	*	@param ArrayList<T> unsorted is a non-empty unsorted array list of T, where T is a comparable type
	*	@return sorted is a permutation of <code>unsorted</code> where all the elements are sorted in increasing order
	*/
	public ArrayList<T> insertion(ArrayList<T> unsorted) {
		ArrayList<T> sorted = unsorted;
		if(sorted.size() > 1) {
			for(int i = 1; i < sorted.size(); i++) {
				T value = sorted.get(i);
				int j = i - 1;
				while(j >= 0 && (value.compareTo(sorted.get(j)) < 0)) {
					sorted.set(j+1, sorted.get(j));
					j--;
				}
				sorted.set(j+1, value);
			}
		}
		return sorted;
	}
}
