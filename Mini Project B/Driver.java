/*
* @Author: Preston Stosur-Bassett
* @Date: 16.2.15
* @Description: This class will serve as a Driver function for the Merge class
*/

public class Driver {
  public static void main(String args[]) {
    Merge merger = new Merge();
    DummyData random = new DummyData();
    ArrayList<Integer> list = random.runArrayList(10, 0, 100, list);

    merger.mergeSort(list, 0, list.length());
  }
}
