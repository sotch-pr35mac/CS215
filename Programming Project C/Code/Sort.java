/*
*	@Author: Preston Stosur-Bassett
*	@Date: Jan 24, 2015
*	@Class: Sort
*	@Description: This class will contain many methods that will sort generic data types using common sorting algorithms.
*/

import java.util.ArrayList;
import java.util.List;

public class Sort<T extends Comparable<T>> {
	/*
	*	@Pre-Condition: ArrayList<T> is a non-empty set of data where T is a comparable data type with a natural order
	*	@Post-Condition: Each parent node is more extreme than its child node.
	*	@Description: heapify is a helper method for heapSort that keeps the heap in order so that the root node is the most extreme element in the heap.
	*	@param ArrayList<T> unsorted is a non-empty set of data where T is a comparable data type with a natural order
	*	@param int i
	*	@param int total
	*	@return ArrayList<T> unsorted
	*/
	private ArrayList<T> heapify(ArrayList<T> unsorted, int i, int total) {
		int left = i * 2;
		int right = left + 1;
		int originalI = i;

		if(left <= total && unsorted.get(left).compareTo(unsorted.get(i)) > 0) {
			i = left;
		}
		if(right <= total && unsorted.get(right).compareTo(unsorted.get(i)) > 0) {
			i = right;
		}
		if(i != originalI) {
			T tmp = unsorted.get(originalI);
			unsorted.set(originalI, unsorted.get(i));
			unsorted.set(i, tmp);
			unsorted = heapify(unsorted, i, total);
		}

		return unsorted;
	}

	/*
	*	@Pre-Condition: ArrayList<T> unsorted is a non-empty ArrayList<T> where T is a comparable data type with a natural order.
	*	@Post-Condition: ArrayList<T> sorted is a permutation of unsorted (it contains all the same elements) in stricly non-decreasing order
	*	@Description: heapSort will sort a given set of data in an ArrayList<T> in strictly non-decreasing order using the heap sort method.
	*	@param ArrayList<T> unsorted is a non-empty ArrayList<T> where T is a comparable data type with a natural order
	*	@return ArrayList<T> sorted is a permutation of unsorted in strictly non-decreasing order
	*/
	//Invariant for First While Loop: unsorted[i] is the parent element in a heap
	//Invariant for Second While Loop: All elements in unsorted greater than the index value of y are in stricly non-decreasing order
	public ArrayList<T> heapSort(ArrayList<T> unsorted) {
		//Debug
		Debug debugger = new Debug();

		int arrSize = unsorted.size() - 1;
		int i = arrSize / 2;
		//Initialization: Our invariant holds true before the first iteration of the loop because unsorted[i] must have child elements
		debugger.assertChildren(unsorted, i);
		while(i >= 0) {
			//Maintanance: Our invariant holds true at the beginning of each iteration of the loop because unsorted[i] must have children elements
			debugger.assertChildren(unsorted, i);

			unsorted = heapify(unsorted, i, arrSize);

			i--;
		}
		//Termination: Our invariant holds true at the termination of the loop because i will be the smallest index value of the loop and must have children elements
		debugger.assertChildren(unsorted, i);

		int y = arrSize;
		//Initialization: Our invariant holds vacuously true before the first iteration of the loop because there are no elements in unsorted that are at an index value greater than y.
		debugger.assertStrictLess(arrSize, y+1);

		while(y > 0) {
			//Maintanance: Our invariant holds true at the beginning of each iteration of the loop because all elements greater than y are in strictly non-decreasing order

			T tmp = unsorted.get(0);
			unsorted.set(0, unsorted.get(y));
			unsorted.set(y, tmp);
			arrSize--;
			unsorted = heapify(unsorted, 0, arrSize);

			y--;
		}
		//Termination: Our invariant holds true at the termination of the loop because y decreases as each largest element is moved to the end of the list until the entire array has been traversed, so that all elements greater than y are in stricly non-decreasing order
		debugger.assertOrder(unsorted);

		ArrayList<T> sorted = unsorted;
		return sorted;
	}

	/*
	*	@Pre-Condition: ArrayList<T> left is a non-empty sorted array in stricly non-decreasing order where T is a comparable data type with a natural order
	*	@Post-Condition: ArrayList<T> right is a non-empty sorted array in strictly non-decreasing order where T is a comparable data type with a natural order
	*	@Description: mergeTogether is used by the mergeSort method to recombine the left and right sections of the ArrayList<T> that is being sorted by merge sort. Note that this is a helper method for the mergeSort method, and should not be called externally of this class.
	*	@param ArrayList<T> left a non-empty ArrayList<T> where T is a comparable data type with a natural order.
	*	@param ArrayList<T> right a non-empty ArrayList<T> where T is a comparable data type with a natural order.
	*	@return ArrayList<T> combined should contain all the elements of left and right in stricly non-decreasing order
	*/
	//Invariant for First While Loop: combined contains x number of elements where x is the sum of i and y and those elements are contained in left[0 ... i] or right[0 ... y] in stricly non-decreasing order
	//Invaraint for Second While Loop: combined contains x number of elements where x is greater than or equal to i and those elements are contined in left[0 ... i] in stricly non-decreasing order
	//Invariant for Third While Loop: combined contains x number of elements where x is greater than or equal to y and those elements are contained in right[0 ... y] in stricly non-decreasing order
	private ArrayList<T> mergeTogether(ArrayList<T> left, ArrayList<T> right) {
		ArrayList<T> combined = new ArrayList<T>();
		int i = 0;
		int y = 0;
		int x = 0;

		//Debug
		Debug debugger = new Debug();

		//Initialization: Our invariant holds true vacuously before the first execution of the loop because x, i, and y are all equal to zero, combined is empty and therefore in order
		debugger.assertEquals(0, i);
		debugger.assertEquals(0, y);
		debugger.assertEquals(0, x);
		debugger.assertEquals(i, combined.size());

		while(left.size() != i && right.size() != y) {
			//Maintanance: Our invariant holds true at the beginning of each iteration of the loop because x is incremented whenever i or y is incremented and elements are added to combined from left and right in order
			debugger.assertEquals(i+y, x);
			debugger.assertEquals(x, combined.size());
			debugger.assertOrder(combined);
			debugger.assertContains(right, left, combined);

			if(left.get(i).compareTo(right.get(y)) < 0) {
				combined.add(x, left.get(i));
				i++;
				x++;
			}
			else {
				combined.add(x, right.get(y));
				y++;
				x++;
			}
		}
		//Termination: Our invariant holds tur at the termination of the loop because x has been incremented whenever i or y has been incremented, and elements are added to combined from left and right in order
		debugger.assertEquals(i+y, x);
		debugger.assertEquals(x, combined.size());
		debugger.assertOrder(combined);
		debugger.assertContains(right, left, combined);

		//Initialization: Our invariant holds true before the first execution of the loop because x has been incremented whenever i has been incremented and elements have been added to combined from left in order
		debugger.assertGreatEquals(x, i);
		debugger.assertEquals(x, combined.size());
		debugger.assertOrder(combined);
		debugger.assertContains(left, combined);

		while(left.size() != i) {
			//Maintanance: Our invariant holds true at the beginning of each iteration of the loop because x has been incremented whenever i is incremented and elements have been added to combined from left in order
			debugger.assertGreatEquals(x, i);
			debugger.assertEquals(x, combined.size());
			debugger.assertOrder(combined);
			debugger.assertContains(left, combined);

			combined.add(x, left.get(i));
			i++;
			x++;
		}
		//Termination: Our invariant holds true at the termination of the loop because x has been incremented whenever i was incremented and elements have been added to combined from left in order
		debugger.assertGreatEquals(x, i);
		debugger.assertEquals(x, combined.size());
		debugger.assertOrder(combined);
		debugger.assertContains(left, combined);

		//Initialization: Our invariant holds true before the first execution of the loop because x has been incremented whenever y has been incremented and elements have been added to combined from right in order
		debugger.assertGreatEquals(x, y);
		debugger.assertEquals(x, combined.size());
		debugger.assertOrder(combined);
		debugger.assertContains(right, combined);

		while(right.size() != y) {
			//Maintanance: Our invariant holds tur at the beinning of each iteration of the loop because x has been incremented whenever y is incremented and elements have been added to combined from right in order
			debugger.assertGreatEquals(x, y);
			debugger.assertEquals(x, combined.size());
			debugger.assertOrder(combined);
			debugger.assertContains(right, combined);

			combined.add(x, right.get(y));
			y++;
			x++;
		}
		//Termination: Our invariant holds true at the terminatino of the loop because x has been incremented whenever y was incremented and elements have been added to combined from right in order.
		debugger.assertGreatEquals(x, y);
		debugger.assertEquals(x, combined.size());
		debugger.assertOrder(combined);
		debugger.assertContains(right, combined);

		return combined;
	}

	/*
	*	@Pre-Condition: ArrayList<T> unsorted is a set of data type T, where T is a Comparable data type with a natural order.
	*	@Post-Condition: ArrayList<T> returnValue is a permutation of unsorted in strictly non-decreasing order.
	*	@Description: mergeSort will sort a given set of data in ArrayList<T> using the merge sort method
	*	@param a non-empty ArrayList<T> unsorted where T is a Comparable data type with a natural order
	*	@return ArrayList<T> returnValue which is a permutation of unsorted, in strictly non-decreasing order,
	*/
	//Invariant for First While Loop: left contains i elements, all of which can be found in sorted
	//Invariant for Second While Loop: right contains y elements, all of which can be found in sorted
	public ArrayList<T> mergeSort(ArrayList<T> unsorted) {
		ArrayList<T> sorted = unsorted;
		ArrayList<T> left = new ArrayList<T>();
		ArrayList<T> right = new ArrayList<T>();
		ArrayList<T> returnValue;

		//Debug
		Debug debugger = new Debug();
		debugger.turnOn();

		if(sorted.size() <= 1) {
			returnValue = sorted;
		}
		else {
			int mid = (sorted.size() / 2);
			int i = 0;
			//Initialization: Our invariant holds true bcause i is zero and left contains 0 elements before the first iteration of the loop.
			debugger.assertEquals(i, left.size());

			while(i < mid) {
				//Maintanance: Our invariant holds true because i is increased at the same rate elements are added to left from the same i index in sorted
				debugger.assertEquals(i, left.size());
				debugger.assertContains(sorted, left);

				T temp = sorted.get(i);
				left.add(temp);

				i++;
			}
			//Termination: Our invariant holds true because i has been incremented at the same rate elements are added to left from the same index i in sorted
			debugger.assertEquals(i, left.size());
			debugger.assertContains(sorted, left);

			int y = mid;
			//Initialization: Our invariant holds true because i is zero and right contains 0 elements before the first iteration of the loop.
			debugger.assertEquals(y, right.size());

			while(y < sorted.size()) {
				//Maintanance: Our invariant holds true because y is increased at the same rate elements are added to right from the same y index in sorted.
				debugger.assertEquals(y, right.size());
				debugger.assertContains(sorted, right);

				T temp = sorted.get(y);
				right.add(temp);

				y++;
			}
			//Termination: Our invariant holds true because y has been incremented at the same rate elements are added to left from the same index y in sorted
			debugger.assertEquals(y, right.size());
			debugger.assertContains(sorted, right);

			left = mergeSort(left);
			right = mergeSort(right);
			returnValue = mergeTogether(left, right);
		}
		return returnValue;
	}

	/*
	*	@Pre-Condition: ArrayList<T> unsorted is an unsorted ArrayList of a comparable data type that is non-empty
	*	@Post-Condition: ArrayList<T> will return a permutation of <code>unsorted</code> that will be in increasing order
	*	@Description: insertionSort will sort an ArrayList of generic type T in increasing order using an insertion sort
	*	@param ArrayList<T> unsorted is a non-empty unsorted array list of T, where T is a comparable type
	*	@return sorted is a permutation of <code>unsorted</code> where all the elements are sorted in increasing order
	*/
	// INVARIANT (Outer-Loop): The pre condition implies that sorted[0 ... i - 1] will contain all the same data as unsorted[0 ... i - 1].
	// INVARIANT (Inner-Loop): sorted[0 ... j] is sorted in stricly non-decreasing order.
	public ArrayList<T> insertionSort(ArrayList<T> unsorted) {
		Debug debugger = new Debug<List<T>>();
		debugger.turnOn();
		ArrayList<T> sorted = unsorted;
		if(sorted.size() > 1) {
			int i = 1;
			/* INITIALIZATION (Outer-Loop): The invariant holds because i = 1, and there is one element in the subarray of sorted[0 ... i - 1] and unsorted[0 ... i - 1], */
			List<T> subSortedOI = sorted.subList(0, i - 1);
			List<T> subUnsortedOI = unsorted.subList(0, i - 1);
			debugger.assertEquals(subUnsortedOI, subSortedOI);

			while(i < sorted.size()) {
				/* MAINTENANCE (Outer-Loop): At the beginning of each iteration of the loop, the loop invariant is maintained because the subarray of sorted[0 ... i - 1] contains all the same elements as
					unsorted[0 ... i - 1] */
				List<T> subSortedOM = sorted.subList(0, i - 1);
				List<T> subUnsortedOM = unsorted.subList(0, i - 1);
				debugger.assertEquals(subUnsortedOM, subSortedOM);

				T value = sorted.get(i);
				int j = i - 1;
				// INITIALIZATION (Inner-Loop): Before the first iteration of the loop, j = 0, the subarray of sorted[0 ... 0] contains one elements and therefore the invariants holds vacuously.
				List subSortedII = sorted.subList(0, j);
				debugger.assertOrder(subSortedII);

				while(j >= 0 && (value.compareTo(sorted.get(j)) < 0)) {
					// MAINTENANCE: (Inner-Loop): At the beginning of each iteration sorted[0 ... j] is sorted in stricly non-decreasing order
					List subSortedIM = sorted.subList(0, j);
					debugger.assertOrder(subSortedIM);

					sorted.set(j+1, sorted.get(j));
					j--;
				}
				sorted.set(j+1, value);
				// TERMINATION (Inner-Loop): The negation of the guard implies that the sorted[0 ... j] has been traversed and is stricly non-decreasing order.
				List subSortedIT = sorted.subList(0, j+1);
				debugger.assertOrder(subSortedIT);

				//Count up on the iterator
				i++;
			}
			/* TERMINATION (Outer-Loop): When the loop terminates, i is equal to sorted.size() meaning the entire array has been traversed and that the guard has been negated.
				The negation of the guard implies that sorted[0 ... i - 1] contains all the elements of unsorted[0 ... i - 1] */
			List subSortedOT = sorted.subList(0, i - 1);
			debugger.assertOrder(subSortedOT);
			Integer integerI = new Integer(i);
			Integer sortedSizeO = new Integer(sorted.size());
			debugger.assertEquals(sortedSizeO, integerI);
			debugger.assertEquals(unsorted, sorted);
		}
		return sorted;
	}


	/*
	*	@Pre-Condition: TODO: write this
	*	@Post-Condition: TODO: write this
	*	@Description: TODO: write this
	* @param ArrayList<ArrayList<T>> unsorted TODO: write this
	*	@param int sortingIndex TODO: write this
	*	@return ArrayList<ArrayList<T>> sorted TODO: write this
	*/
	//There should be two loop invariants, I should be able to take them straight from above
	public ArrayList<ArrayList<T>> insertionSortNestedArray(ArrayList<ArrayList<T>> list, int sortingIndex) {
		if(list.size() > 1) {
			int i = 1;

			//Outer While Loop Initialization: TODO: write this
			while(i < list.size()) {
				//Outer While Loop Maintenance: TODO: write this
				ArrayList<T> currentElement = list.get(i);
				T value = list.get(i).get(sortingIndex);
				int j = i - 1;

				//Inner While Loop Initialization: TODO: write this
				while(j >= 0 && (value.compareTo(list.get(j).get(sortingIndex)) > 0)) {
					//Inner While Loop Maintenance: TODO: write this
					list.set(j+1, list.get(j));
					j--;
				}
				//Inner While Loop Termination: TODO: write this
				list.set(j+1, currentElement);

				i++;
			}
			//Outer While Loop Termination: TODO: write this
		}

		return list;
	}
}
