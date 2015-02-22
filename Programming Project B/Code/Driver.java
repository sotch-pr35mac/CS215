/*
* @Author: Preston Stosur-Bassett
* @Date: Feb, 23, 2015
* @Class: Driver
* @Description: This class will test the functionality of the overall program by serving as a driver that runs through and calls all other required classes
*/

import java.util.ArrayList;

public class Driver{
  public static void main(String args[]) {
    DummyData testData = new DummyData();

    ArrayList<String> testList = new ArrayList<String>();
    //testList = testData.runArrayList(1000, 0, 0, testList);
    testList = testData.runArrayList(1000, testList);

    System.out.println("Unsorted list: ");
    System.out.println(testList);

    Sort sorter = new Sort();

    Stopwatch watchman = new Stopwatch();
    testList = sorter.mergeSort(testList);
    //testList = sorter.heapSort(testList);

    System.out.println("Sorted List: ");
    System.out.println(testList);
    System.out.println("Time To Complete: "+watchman.elapsedTime());
  }
}
