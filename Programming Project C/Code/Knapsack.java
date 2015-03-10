/*
* @Auhtor: Preston Stosur-Bassett
* @Description: This class implements a greedy and dynamic solution for the 0/1 Knapsack problem. These two solutions will return the max value that can be obtained only, and not how to obtain them.
* @Class: Knapsack
* @Date: 3, 3, 2015
*/

import java.util.ArrayList;
import java.lang.Math;

public class Knapsack<T extends Comparable<T>> {
  /*
  * @Pre-Condition: TODO: write this
  * @Post-Condition: TODO: write thsi
  * @Description: TODO: write this
  * @param int elems TODO: write this
  * @param ArrayList<Integer> weights TODO: write this
  * @param ArrayList<Integer> prices  TODO: write this
  * @param int backpackSize TODO: write this
  * @return int profit TODO: write this
  */
  //Invariants (There should be 1 or 2)
  //For Loop Invariant: TODO: write this
  //While Loop Invariant: TODO: write this
  public int greedyKnapsack(int elems, ArrayList<Integer> weights,  ArrayList<Integer> prices, int backpackSize) {
    int returnValue;
    if(elems == 1) {
      returnValue = prices.get(0).intValue();
    }
    else if(elems < 1) {
      returnValue = 0;
    }
    else {
      int profit = 0;

      ArrayList<ArrayList<Integer>> ratioListings = new ArrayList<ArrayList<Integer>>(elems);

      //Initialization: TODO: write this
      for(int i = 0; i < elems; i++) {
        //Maintenance: TODO: write this
        int ratio = prices.get(i).intValue() / weights.get(i).intValue();
        ArrayList<Integer> innerRatioListing = new ArrayList<Integer>(3);
        innerRatioListing.add(new Integer(ratio));
        innerRatioListing.add(new Integer(prices.get(i).intValue()));
        innerRatioListing.add(new Integer(weights.get(i).intValue()));
        ratioListings.add(innerRatioListing);
      }
      //Termination: TODO: write this

      Sort sorter = new Sort();

      ratioListings = sorter.insertionSortNestedArray(ratioListings, 0);

      int i = 0;
      //Initialization: TODO: write this
      while(backpackSize > 0 && i < elems) {
        //Maintenance: TODO: write this
        if(backpackSize - ratioListings.get(i).get(2).intValue() >= 0) {
          profit = profit + ratioListings.get(i).get(1).intValue();
          backpackSize = backpackSize - ratioListings.get(i).get(2).intValue();
        }

        i++;
      }
      //Termination: TODO: write this

      returnValue = profit;
    }

    return returnValue;
  }

  /*
  * @Pre-Condition: TODO: write this
  * @Post-Condition: TODO: write this
  * @Description: TODO: write this
  * @param int elems TODO: write this
  * @param ArrayList<Integer> weights TODO: write this
  * @param ArrayList<Integer> prices TODO: write this
  * @param int backpackSize TODO: write this
  * @return int returnValue TODO: write this
  */
  //There should be for loop invariants here
  public int dynamicKnapsack(int elems, ArrayList<Integer> weights, ArrayList<Integer> prices, int backpackSize) {
    int returnValue = 0;
    if(elems == 1) {
      returnValue = prices.get(0).intValue();
    }
    else if(elems <= 0) {
      returnValue = 0;
    }
    else {
      int[][] tab = new int[elems][backpackSize];

      int x = 0;
      int y = 0;
      // First Outer While Loop Initialization: TODO: write this
      while(x < elems) {
        // First Outer While Loop Maintenance: TODO: write this
        // First Inner While Loop Initialization: TODO: write this
        while(y < backpackSize) {
          // First Inner While Loop Maintenance: TODO: write this
          tab[x][y] = 0;

          y++;
        }
        // First Inner While Loop Termination: TODO: write this

        x++;
      }
      // First Outer While Loop Termination: TODO: write this

      // Second Outer For Loop Initialization: TODO: write this
      for(int i = 0; i < elems - 1; i++) {
        // Second Outer For Loop Maintenance: TODO: write this
        // Second Inner For Loop Initialization: TODO: write this
        for(int j = 0; j < backpackSize; j++) {
          // Second Inner For Loop Maintenance: TODO: write this
          if(weights.get(i).intValue() <= j && prices.get(i).intValue() + tab[i][j - weights.get(i).intValue()] > tab[i][j]) {
            tab[i+1][j] = prices.get(i).intValue() + tab[i][j - weights.get(i).intValue()];
          }
          else {
            tab[i+1][j] = tab[i][j];
          }
        }
        // Second Inner For Loop Termination: TODO: write this
      }
      // Second Outer For Loop Termination: TODO: write this

      returnValue = tab[elems-1][backpackSize-1];
    }

    return returnValue;
  }
}
