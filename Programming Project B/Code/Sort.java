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
	*	@Post-Condition:
	*	@Description: heapify is a helper method for heapSort that keeps the heap in order so that the root node is the largest element in the heap.
	*	@param ArrayList<T> unsorted is a non-empty set of data where T is a comparable data type with a natural order
	*	@param int i
	*	@param int total
	*	@return ArrayList<T> unsorted 
	*/
	//NOTE: No Invariants as this has no loops
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
	//INVARIANTS (There should be two of them here)
	public ArrayList<T> heapSort(ArrayList<T> unsorted) {
		int arrSize = unsorted.size() - 1;
		for(int i = arrSize / 2; i >= 0; i--) {
			unsorted = heapify(unsorted, i, arrSize);
		}
		for(int i = arrSize; i > 0; i--) {
			T tmp = unsorted.get(0);
			unsorted.set(0, unsorted.get(i));
			unsorted.set(i, tmp);
			arrSize--;
			unsorted = heapify(unsorted, 0, arrSize);
		}
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
	//TODO: Write the invariants for this shit.
	//INVARIANTS (There should be around 3 invariants for this method)
	private ArrayList<T> mergeTogether(ArrayList<T> left, ArrayList<T> right) {
		ArrayList<T> combined = new ArrayList<T>();
		int i = 0;
		int y = 0;
		int x = 0;

		while(left.size() != i && right.size() != y) {
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

		while(left.size() != i) {
			combined.add(x, left.get(i));
			i++;
			x++;
		}

		while(right.size() != y) {
			combined.add(x, right.get(y));
			y++;
			x++;
		}
		return combined;
	}

	/*
	*	@Pre-Condition: ArrayList<T> unsorted is a set of data type T, where T is a Comparable data type with a natural order.
	*	@Post-Condition: ArrayList<T> returnValue is a permutation of unsorted in strictly non-decreasing order.
	*	@Description: mergeSort will sort a given set of data in ArrayList<T> using the merge sort method
	*	@param a non-empty ArrayList<T> unsorted where T is a Comparable data type with a natural order
	*	@return ArrayList<T> returnValue which is a permutation of unsorted, in strictly non-decreasing order,
	*/
	//TODO: Write the invariants for this shit.
	// INVARIANTS (2 Invariants)
	public ArrayList<T> mergeSort(ArrayList<T> unsorted) {
		ArrayList<T> sorted = unsorted;
		ArrayList<T> left = new ArrayList<T>();
		ArrayList<T> right = new ArrayList<T>();
		ArrayList<T> returnValue;
		if(sorted.size() <= 1) {
			returnValue = sorted;
		}
		else {
			int mid = (sorted.size() / 2);
			for(int i = 0; i < mid; i++) {
				T temp = sorted.get(i);
				left.add(temp);
			}
			for(int i = mid; i < sorted.size(); i++) {
				T temp = sorted.get(i);
				right.add(temp);
			}
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
}
