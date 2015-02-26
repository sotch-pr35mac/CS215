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
    for(int y = startIndex; y < endIndex; y++) {
      if(left.get(i).compareTo(right.get(j)) <= 0) {
        merged.set(y, left.get(i));
        i++;
      }
      else {
        merged.set(y, right.get(j));
        j++;
      }
    }

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
