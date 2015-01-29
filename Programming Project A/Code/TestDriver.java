/*
*	@Author Preston Stosur-Bassett
*	@Date Jan 25, 2015
*	@Class TestDriver
*	@Description this class will create test data to run through and test the other classes in this directory.
*/

import java.util.ArrayList;

public class TestDriver {

	/*
	*	@Description This serves as the Driver function for this program, run this class to execute the program
	*/
	public static void main(String args[]) {
		//Turn on debugger
		Debug debugger = new Debug();
		debugger.turnOn();

		//Test debug
		debugger.print("Debug is on.");

		//Create test data for sorts class
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList = DummyData.runArrayList(0, 1, 0, 100, testList);

		System.out.println("Un-Sorted List");
		System.out.println(testList);

		//Test sort List
		Sort sorter = new Sort<Integer>();
		Stopwatch watchStopper = new Stopwatch();
		testList = sorter.insertion(testList);

		System.out.println("Sorted List");
		System.out.println(testList);
		System.out.println("Time to complete: "+watchStopper.elapsedTime());
	}
}
