/*
*	@Author Preston Stosur-Bassett
*	@Date Jan 25, 2015
*	@Class TestDriver
*	@Description this class will create test data to run through and test the other classes in this directory.
*/

import java.util.ArrayList;

public class TestDriver {
	public static void main(String args[]) {
		//Turn on debugger
		Debug debugger = new Debug();
		debugger.turnOn();

		//Test debug
		debugger.print("Debug is on.");

		//Create test data for sorts class
		ArrayList<Integer> testList = new ArrayList<Integer>();
		Integer oneOhone = new Integer(101);
		Integer oneEleven = new Integer(111);
		Integer oneOhOhFive = new Integer(1005);
		testList = DummyData.runArrayList(0, 10, 2, testList);

		System.out.println("Un-Sorted List");
		System.out.println(testList);

		//Test sort List
		testList = Sort.insertion(testList);

		System.out.println("Sorted List");
		System.out.println(testList);
	}
}