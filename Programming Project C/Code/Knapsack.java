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
      ArrayList<Integer> tab = new ArrayList<Integer>(elems);
      int sizePrime = backpackSize;
      int profit = 0;

      //Initialization: TODO: write this
      for(int i = 0; i < elems; i++) {
        //Maintenance: TODO: write this
        tab.add(new Integer(0));
      }
      //Termination: TODO: write this

      //Initialization: TODO: write this
      int i = 0;
      while(i < elems - 1) {
        //Maintenance: TODO: write this
        if(!(weights.get(i).intValue() > sizePrime)) {
          tab.set(i, new Integer(1));
          profit = profit + prices.get(i).intValue();
          sizePrime = sizePrime - weights.get(i).intValue();
        }

        i++;
      }
      //Termination: TODO: write this

      if(i < elems) {
        tab.set(i, new Integer(sizePrime / weights.get(i).intValue()));
      }

      profit = profit + (tab.get(i).intValue() * prices.get(i).intValue());

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
  //There should be three loop invariants here
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

      for(int i = 0; i < elems; i++) {
        for(int j = 0; j < backpackSize; j++) {
          tab[i][j] = 0;
        }
      }

      for(int i = 0; i < elems - 1; i++) {
        for(int j = 0; j < backpackSize; j++) {
          if(weights.get(i).intValue() <= j && prices.get(i).intValue() + tab[i][j - weights.get(i).intValue()] > tab[i][j]) {
            tab[i+1][j] = prices.get(i).intValue() + tab[i][j - weights.get(i).intValue()];
          }
          else {
            tab[i+1][j] = tab[i][j];
          }
        }
      }

      returnValue = tab[elems-1][backpackSize-1];
    }

    return returnValue;
  }
}
