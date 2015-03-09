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
    Stopwatch watchman = new Stopwatch();

    ArrayList<Integer> prices = new ArrayList<Integer>();
    ArrayList<Integer> weights = new ArrayList<Integer>();

    int numberOfElements = 10;
    int knapsackSize = 40;

    System.out.println("Max Knapsack Capacity: "+knapsackSize);

    prices = testData.runArrayList(numberOfElements, 1, 100, prices);
    weights = testData.runArrayList(numberOfElements, 1, 50, weights);

    System.out.println("Set P:"+prices);
    System.out.println("Set W:"+weights);
    System.out.println("");

    watchman.startTime();
    int totalProfit = theif.greedyKnapsack(numberOfElements, weights, prices, knapsackSize);
    double elapsedTime = watchman.elapsedTime();

    Integer totalProfitObject = new Integer(totalProfit);
    System.out.println("The total profit according to this algorithm is: "+totalProfitObject);
    System.out.println("Time to Complete: "+elapsedTime);
  }
}
