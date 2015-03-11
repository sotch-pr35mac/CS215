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
  * @Pre-Condition: <code>weights</code> and <code>prices</code> both have in them <code>elems</code> amount of elements
  * @Post-Condition: The returned value will be a reasonable solution for the largest value in price where the aggregate of the corresponding weight does not excede the <code>backpackSize</code>
  * @Description: greedyKnapsack implements a greedy algorithm to find a reasonable solution for a 0/1 Knapsack problem
  * @param int elems is the amount of elements in both <code>ArrayList<Integer> weights</code> and <code>ArrayList<Integer> prices</code>
  * @param ArrayList<Integer> weights is a non-empty ArrayList of Integer objects with exactly <code>elems</code> amount of elements in it and contains absolutely no zeros
  * @param ArrayList<Integer> prices is a non-empty ArrayList of Integer object with exactly <code>elems</code> amount of elements in it
  * @param int backpackSize is the maximum value of weights that the knapsack can hold
  * @return int profit is a reasonable solution to the given 0/1 Knapsack problem
  */
  //INVARIANT (First Loop): TODO: write this
  //INVARIANT (Second Loop): TODO: write this
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

      int v = 0;
      /*INITIALIZATION (First Loop): */
      while(v < elems) {
        /*MAINTANENCE (First-Loop): */
        int ratio = prices.get(v).intValue() / weights.get(v).intValue();
        ArrayList<Integer> innerRatioListing = new ArrayList<Integer>(3);
        innerRatioListing.add(new Integer(ratio));
        innerRatioListing.add(new Integer(prices.get(v).intValue()));
        innerRatioListing.add(new Integer(weights.get(v).intValue()));
        ratioListings.add(innerRatioListing);

        v++;
      }
      /*TERMINATION (First Loop): */

      Sort sorter = new Sort();

      ratioListings = sorter.insertionSortNestedArray(ratioListings, 0);

      int i = 0;
      /*INITIALIZATION (Second Loop): */
      while(backpackSize > 0 && i < elems) {
        /*MAINTENANCE (Second Loop): */
        if(backpackSize - ratioListings.get(i).get(2).intValue() >= 0) {
          profit = profit + ratioListings.get(i).get(1).intValue();
          backpackSize = backpackSize - ratioListings.get(i).get(2).intValue();
        }

        i++;
      }
      /*TERMINATION (Second Loop): */

      returnValue = profit;
    }

    return returnValue;
  }

  /*
  * @Pre-Condition: <code>weights</code> and <code>prices</code> both have in them <code>elems</code> amount of elements
  * @Post-Condition: The returned value will be the correct solution for the largest value in price where the aggregate of the corresponding weights do not excede the <code>backpackSize</code>
  * @Description: dynamicKnapsack implements a dynamic programming solution to find the correct answer for a 0/1 Knapsack problem
  * @param int elems is the amount of elemnts in both <code>ArrayList<Integer> weights</code> and <code>ArrayList<Integer> prices</code>
  * @param ArrayList<Integer> weights is a non-empty ArrayList of Integer objects with esactly <code>elems</code> amount of elements in it and contains absolutely no zeros
  * @param ArrayList<Integer> prices is a non-empty ArrayList of Integer objects with exactly <code>elemes</code> amount of elemnts in it
  * @param int backpackSize is the maximum value of the weights that the knapsack can hold
  * @return int returnValue is the correct value of the maximum amount of values you can get from prices where their correcsponding weights do not excede the backpackSize
  */
  //INVARIANT (First Outer-Loop): TODO: write this
  //INVARIANT (First Inner-Loop): TODO: write this
  //INVARIANT (Second Outer-Loop): TODO: write this
  //INVARIANT (Second Inner-Loop): TODO: write this
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
      /*INITIALIZATION (First Outer-Loop): TODO: write this */
      while(x < elems) {
        /*MAINTENANCE (First Outer-Loop): TODO: write this*/
        /*INITIALIZATION (First Inner-Loop): TODO: write this */
        while(y < backpackSize) {
          /*MAINTENANCE (First Inner-Loop): TODO: write this */
          tab[x][y] = 0;

          y++;
        }
        /*TERMINATION (First Inner-Loop): TODO: write this */

        x++;
      }
      /*TERMINATION (First Outer-Loop): TODO: write this */

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
