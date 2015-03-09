/*
* @Auhtor: Preston Stosur-Bassett
* @Description: TODO: write this
* @Class: Knapsack
* @Date: 3, 3, 2015
*/

import java.util.ArrayList;

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
    ArrayList<Integer> tab = new ArrayList<Integer>(elems);
    int sizePrime = backpackSize;
    int profit = 0;

    for(int i = 0; i < elems; i++) {
      tab.set(i, 0);
    }

    //Initialization: TODO: write this
    int i = 0;
    while(i < elems) {
      //Maintenance: TODO: write this
      if(weights.get(i).intValue() > sizePrime) {
        break;
      }
      else {
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

    return profit;
  }
}
