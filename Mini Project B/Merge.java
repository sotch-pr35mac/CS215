/*
* @Author: Preston Stosur-Bassett
* @Date: 25.2.15
* @Description: This program demonstrates how an in-place merge sort sorting algorithm works
*/

import java.util.ArrayList;

public class Merge {
  private ArrayList<Integer> mergeTogether(ArrayList<Integer> unmerged, int startIndex, int endIndex, int mid) {
    int nOne = mid - startIndex + 1;
    int nTwo = endIndex - mid;
    ArrayList<Integer> left = new ArrayList<Integer>();
    ArrayList<Integer> right = new ArrayList<Integer>();
    for(int i = 0; i < nOne; i++) {
      left.set(i, unmerged.get(startIndex+i-1));
    }
    for(int i = 0; i < nTwo; i++) {
      right.set(i, unmerged.get(endIndex+i));
    }
    left.set(left.size()+1, 2147483647);
    right.set(right.size()+1, 2147483647);
    int i = 0;
    int j = 0;
    ArrayList<Integer> merged = new ArrayList<Integer>();
    int y = startIndex;
    /* INITIALIZZATION: Prior to the first iteration of the loop, we have k = p, so that the subarray A[startIndex ... y - 1] is empty. This empty subarray contains the y - startIndex = 0 smallest elements of left and right, and since i = j = 1, both left[i] and right[j] are the smallest elements of their arrays that have not been copied back into A. */
    while(y < endIndex) {
      /* MAINTENANCE: To see that each iteration maintains the loop invariant, let us first suppose that left[i] <= right[j]. Then left[i] is the smallest element not yet copied back into A. Because A[startIndex ... y - 1] contains the y - startIndex smallest elements, after the copy of left[i] into A[y], the subarray A[startIndex ... y] will contains the y - startIndex + 1 smallest elements. Incrementeing y and i reestablishes the loop invariant for the next iteration. If instead left[i] > right[j], then the appropriate action is used to maintain the loop invariant. */
      if(left.get(i).compareTo(right.get(j)) <= 0) {
        merged.set(y, left.get(i));
        i++;
      }
      else {
        merged.set(y, right.get(j));
        j++;
      }
      y++;
    }
    /* TERMINATION: At termination, y = endIndex + 1. By the loop invariant, the subarray A[startIndex ... y - 1], which is A[startIndex ... endIndex], ctonains the y - startIndex = endIndex - startIndex + 1 smallest elements of left[0 ... nOne + 1] and right[0 ... nTwo + 1] in sorted order. The arrays left and right together contain nOne + nTwo + 2 = endIndex - startIndex + 3 elements. All but the two largest have been copied back into A, and these two largest elements have the sentinels. */

    return merged;
  }

  public ArrayList<Integer> mergeSort(ArrayList<Integer> unsorted, int startIndex, int endIndex) {
    if(startIndex < endIndex) {
        int mid = ((startIndex + endIndex) / 2);
        mergeSort(unsorted, startIndex, mid);
        mergeSort(unsorted, mid+1, endIndex);
        ArrayList<Integer> sorted = mergeTogether(unosrted, startIndex, endIndex, mid);
    }
    else {
      ArrayList<Integer> sorted = unsorted;
    }

    return sorted;
  }
}
