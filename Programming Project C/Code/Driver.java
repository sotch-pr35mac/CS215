/*
*  @Author: Preston Stosur-Bassett
* @Date: 3, 3, 2015
* @Class: Driver
* @Description: This class will serve as a driver function for our Knapsack class
*/

import java.util.ArrayList;

public class Driver {
  public static void main(String args[]) {
    Knapsack theif = new Knapsack();
    DummyData testData = new DummyData();

    ArrayList<Integer> prices = new ArrayList<Integer>();
    ArrayList<Integer> weights = new ArrayList<Integer>();

    int numberOfElements = 5;
    int knapsackSize = 22;

    prices = testData.runArrayList(numberOfElements, 1, 100, prices);
    weights = testData.runArrayList(numberOfElements, 1, 50, weights);

    int totalProfit = theif.greedyKnapsack(numberOfElements, weights, prices, knapsackSize);

    Integer totalProfitObject = new Integer(totalProfit);
    System.out.println("The total profit according to this algorithm is: "+totalProfitObject);
  }
}
