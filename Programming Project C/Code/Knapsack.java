/*
* @Auhtor: Preston Stosur-Bassett
* @Description: This class implements a greedy and dynamic solution for the 0/1 Knapsack problem. These two solutions will return the max value that can be obtained only, and not how to obtain them.
* @Class: Knapsack
* @Date: 3, 3, 2015
*/

import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

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
  //INVARIANT (First Loop): ratioListings[0 ... v-1] has the same number of non-null elements in it as both prices[0 ... v-1] and weights[0 ... v-1]
  //INVARIANT (Second Loop): The aggregate of the weights corresponding to the prices included in the value of profit are less than or equal to the value of backpackSize
  public int greedyKnapsack(int elems, ArrayList<Integer> weights,  ArrayList<Integer> prices, int backpackSize) {
    Debug debugger = new Debug();
    int returnValue;
    if(elems == 1 && weights.get(0).intValue() <= backpackSize) {
      returnValue = prices.get(0).intValue();
    }
    else if(elems < 1) {
      returnValue = 0;
    }
    else {
      int profit = 0;

      ArrayList<ArrayList<Integer>> ratioListings = new ArrayList<ArrayList<Integer>>(elems);

      int v = 0;
      /*INITIALIZATION (First Loop): Our invariant holds before the first iteration of the loop because v = 0, and ratioListings[v-1], prices[v-1] and weights[v-1] all do not exist, and therefore is vacously true.*/

      while(v < elems) {
        /*MAINTANENCE (First-Loop): At the beginning of each iteration of the loop our invariant holds true because each time the loop runs, v is increased by one and one element is added to raioListings, therefore ratioListings[0 ... v-1] will have exactly the same number of elements as both prices[0 ... v-1] and weights[0 ... v-1].*/
        if(v > 0) {
          debugger.assertEquals(new Integer(weights.subList(0, v-1).size()), new Integer(prices.subList(0, v-1).size()));
          debugger.assertEquals(new Integer(prices.subList(0, v-1).size()), new Integer(ratioListings.subList(0, v-1).size()));
        }

        int ratio = prices.get(v).intValue() / weights.get(v).intValue();
        ArrayList<Integer> innerRatioListing = new ArrayList<Integer>(3);
        innerRatioListing.add(new Integer(ratio));
        innerRatioListing.add(new Integer(prices.get(v).intValue()));
        innerRatioListing.add(new Integer(weights.get(v).intValue()));
        ratioListings.add(innerRatioListing);

        v++;
      }
      /*TERMINATION (First Loop): After the loop terminates, our invariant holds true because v has been increased by one during each iteration of the loop, and ratioListings has gained one element during each iteration of the loop, so therefore ratioListings[0 ... v-1] contains exactly the same number of elements as both prices[0 ... v-1] and weights[0 ... v-1]*/
      debugger.assertEquals(new Integer(weights.subList(0, v-1).size()), new Integer(prices.subList(0, v-1).size()));
      debugger.assertEquals(new Integer(prices.subList(0, v-1).size()), new Integer(ratioListings.subList(0, v-1).size()));

      Sort sorter = new Sort();

      ratioListings = sorter.insertionSortNestedArray(ratioListings, 0);

      int i = 0;
      int totalWeight = 0;
      /*INITIALIZATION (Second Loop): Before the first iteration of the loop our invariant holds true because no prices are included in the value of profit, and therefore, vacuously true.*/
      debugger.assertLessEquals(totalWeight, backpackSize);

      while(backpackSize > 0 && i < elems) {
        /*MAINTENANCE (Second Loop): At the beginning of each iteration of the loop our invariant holds true because only items whose weight is less than or equal to the remaining space in the knapsack (backpackSize) are added to the profit.*/
        debugger.assertLessEquals(totalWeight, backpackSize);

        if(backpackSize - ratioListings.get(i).get(2).intValue() >= 0) {
          profit = profit + ratioListings.get(i).get(1).intValue();
          backpackSize = backpackSize - ratioListings.get(i).get(2).intValue();
          totalWeight = totalWeight + ratioListings.get(i).get(2).intValue();
        }

        i++;
      }
      /*TERMINATION (Second Loop): After the loop terminates, our invariant holds true because only items whose weight was less than or equal to the remaining size in the knapsack (backpackSize) were added to the profit.*/
      debugger.assertLessEquals(totalWeight, backpackSize);

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
  //INVARIANT (First Outer-Loop): tab[0 ... x-1] has the same number of non-null elements in it as both weights[0 ... x-1] and prices[0 ... x-1]
  //INVARIANT (First Inner-Loop): tab[x] has y number of non-null elements in it.
  //INVARIANT (Second Outer-Loop): TODO: write this
  //INVARIANT (Second Inner-Loop): TODO: write this
  public int dynamicKnapsack(int elems, ArrayList<Integer> weights, ArrayList<Integer> prices, int backpackSize) {
    Debug debugger = new Debug();
    int returnValue = 0;
    backpackSize = backpackSize + 1;
    if(elems == 1 && weights.get(0).intValue() <= backpackSize) {
      returnValue = prices.get(0).intValue();
    }
    else if(elems <= 0) {
      returnValue = 0;
    }
    else {
      int[][] tab = new int[elems][backpackSize];

      int x = 0;
      int y = 0;
      int nonNullElements = 0;
      /*INITIALIZATION (First Outer-Loop): Before the first iteration of the loop the invariant holds vacuously because tab[0 ... x-1], weights[0 ... x-1] and prices[0 ... x-1] all do not exist.*/
      while(x < elems) {
        /*MAINTENANCE (First Outer-Loop): At the beginning of each iteration of the loop the invariant holds because x is incremented by one at the same rate that one element is added to tab[].*/
        if(x > 0) {
          int[][] subTabM = Array.copyOfRange(tab, 0, x-1);
          debugger.assertEquals(new Integer(weights.subList(0, x-1).intValue()), new Integer(prices.subList(0, x-1).intValue()));
          debugger.assertEquals(new Integer(prices.subList(0, x-1).intValue()), new Integer(subTabM.length));
        }

        /*INITIALIZATION (First Inner-Loop): Before the first iteration of the loop the invariant holds true because y = 0 and tab[x] has 0 elements in it.  */
        nonNullElements = 0;
        for(int i = 0; i < tab[x].length; i++) {
          if(tab[x][y] != null) {
            nonNullElements++;
          }
        }
        debugger.assertEquals(nonNullElements, y);

        while(y < backpackSize) {
          /*MAINTENANCE (First Inner-Loop): At the beginning of each iteration of the loop the invariant holds true because at the same rate y is incremented an element is added to tab[x]*/
          nonNullElements = 0;
          for(int i = 0; i < tab[x].length; i++) {
            if(tab[x][y] != null) {
              nonNullElements++;
            }
          }
          debugger.assertEquals(nonNullElements, y);

          tab[x][y] = 0;
          y++;
        }
        /*TERMINATION (First Outer-Loop): At the termination of the loop the invariant holds true because y has been incremented at the same rate elements have been added to tab[x]*/
        nonNullElements = 0;
        for(int z = 0; z < tab[x].length; z++) {
          if(tab[h][x] != null) {
            nonNullElements++;
          }
        debugger.assertEquals(nonNullElements, z);

        x++;
      }
      /*TERMINATION (First Inner-Loop): At the termination of the loop the invariant holds true because x has been incremented at the same rate that elements have been added to tab[]. */
      debugger.assertEquals(new Integer(weights.subList(0, x-1).intValue()), new Integer(prices.subList(0, x-1).intValue()));
      debugger.assertEquals(new Integer(prices.subList(0, x-1).intValue()), new Integer(subTabM.length));

      int i = 0;
      int j = 0;
      // Second Outer For Loop Initialization: TODO: write this
      while(i < elems - 1) {
        // Second Outer For Loop Maintenance: TODO: write this
        // Second Inner For Loop Initialization: TODO: write this
        while(j < backpackSize) {
          // Second Inner For Loop Maintenance: TODO: write this
          if(weights.get(i).intValue() <= j && prices.get(i).intValue() + tab[i][j - weights.get(i).intValue()] > tab[i][j]) {
            tab[i+1][j] = prices.get(i).intValue() + tab[i][j - weights.get(i).intValue()];
          }
          else {
            tab[i+1][j] = tab[i][j];
          }

          j++;
        }
        // Second Inner For Loop Termination: TODO: write this

        i++;
      }
      // Second Outer For Loop Termination: TODO: write this

      returnValue = tab[elems-1][backpackSize-1];
    }

    return returnValue;
  }
}
