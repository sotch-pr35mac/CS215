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

    ArrayList<Integer> testList = new ArrayList<Integer>();
    testList = testData.runArrayList(10, 1, 25, testList);

    System.out.println("Unsorted list: ");
    System.out.println(testList);

    Sort sorter = new Sort();

    testList = sorter.mergeSort(testList);

    System.out.println("Sorted List: ");
    System.out.println(testList);
  }
}
