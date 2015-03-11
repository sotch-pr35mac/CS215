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

    if(args[0].equals("greedy") == true && args[1] != null && args[2] != null) {
      System.out.println("Running greedy algorithm...");

      int numberOfElements = Integer.parseInt(args[1]);
      int knapsackSize = Integer.parseInt(args[2]);

      System.out.println("Max Knapsack Capacity: "+knapsackSize);

      prices = testData.runArrayList(numberOfElements, 1, 1000, prices);
      weights = testData.runArrayList(numberOfElements, 1, 50, weights);

      System.out.println("Set P:"+prices);
      System.out.println("Set W:"+weights);
      System.out.println("");

      watchman.startTime();
      int totalProfit = theif.greedyKnapsack(numberOfElements, weights, prices, knapsackSize);
      double elapsedTime = watchman.elapsedTime();

      Integer totalProfitObject = new Integer(totalProfit);
      System.out.println("The total profit according to this greedy algorithm is: "+totalProfitObject);
      System.out.println("Time to Complete: "+elapsedTime);
    }
    else if(args[0].equals("dynamic") == true && args[1] != null && args[2] != null) {
      System.out.println("Running dynamic algorithm...");

      int numberOfElements = Integer.parseInt(args[1]);
      int knapsackSize = Integer.parseInt(args[2]);

      System.out.println("Max Knapsack Capacity: "+knapsackSize);

      prices = testData.runArrayList(numberOfElements, 1, 1000, prices);
      weights = testData.runArrayList(numberOfElements, 1, 50, weights);

      System.out.println("Set P:"+prices);
      System.out.println("Set W:"+weights);
      System.out.println("");

      watchman.startTime();
      int totalProfit = theif.dynamicKnapsack(numberOfElements, weights, prices, knapsackSize);
      double elapsedTime = watchman.elapsedTime();

      Integer totalProfitObject = new Integer(totalProfit);
      System.out.println("The total profit according to this dynamic algorithm is: "+totalProfitObject);
      System.out.println("Time to Complete: "+elapsedTime);
    }
    else if(args[0].equals("compare") == true && args[1] != null && args[2] != null) {
      System.out.println("Comparing greedy solution to dynamic solution...");

      Stopwatch dynamicWatch = new Stopwatch();
      Stopwatch greedyWatch = new Stopwatch();

      int numberOfElements = Integer.parseInt(args[1]);
      int knapsackSize = Integer.parseInt(args[2]);

      if(numberOfElements <= 0) {
        System.out.println("Cannot have 0 or negative number for number of elements. Changing to 1.");
        numberOfElements = 1;
      }

      System.out.println("Max Knapsack Capacity: "+knapsackSize);

      prices = testData.runArrayList(numberOfElements, 1, 1000, prices);
      weights = testData.runArrayList(numberOfElements, 1, 50, weights);

      System.out.println("Set P:"+prices);
      System.out.println("Set W:"+weights);
      System.out.println("");

      greedyWatch.startTime();
      int greedyProfit = theif.greedyKnapsack(numberOfElements, weights, prices, knapsackSize);
      double greedyTime = greedyWatch.elapsedTime();

      System.out.println("Greedy Solution: $"+greedyProfit+". Completed in "+greedyTime+" milliseconds.");

      dynamicWatch.startTime();
      int dynamicProfit = theif.dynamicKnapsack(numberOfElements, weights, prices, knapsackSize);
      double dynamicTime = dynamicWatch.elapsedTime();

      System.out.println("Dynamic Solution: $"+dynamicProfit+". Completed in "+dynamicTime+" milliseconds.");

      System.out.println("");

      int difference = greedyProfit - dynamicProfit;
      int top = Math.abs(difference);
      int bottom = Math.abs(dynamicProfit);
      double error = new Integer(top).doubleValue() / new Integer(bottom).doubleValue();
      double percentError = error * 100;

      System.out.println("Percent Error: "+percentError+"%");

    }
    else {
      System.out.println("Invalid argument error!!");
      System.out.println("The correct format is: Driver [method] [number of elements] [size of knapsack]");
    }
  }
}
