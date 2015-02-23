/*
*	@Author Preston Stosur-Bassett
*	@Date Jan 21, 2015
*	@Class Debug
*	@Description This class will help debugging by being able to turn on and turn off debug messages easily
*/

import java.util.List;
import java.util.ArrayList;

public class Debug<T> {
	boolean debugOn; //Variable to keep track of whether or not debug is on

	/*
	*	@Description constructor method that sets the default value of debugOn to false so that debug statements will not automatically print
	*/
	public void Debug() {
		debugOn = false;
	}

	/*
	*	@Description turn on debugging print statements
	*/
	public void turnOn() {
		debugOn = true;
	}

	/*
	*	@Description turn off debugging print statements
	*/
	public void turnOff() {
		debugOn = false;
	}

	/*
	*	@Description will print messages only when debugOn boolean is set to true
	*	@param String message the string to print when debugging is turned on
	*/
	public void print(T message) {
		if(debugOn == true) {
			System.out.println(message);
		}
	}

	/*
	*	@Pre-Condition <code>T expected</code> and <code>T actual</code> are both of the same type T
	*	@Post-Condition If <code>T expected</code> and <code>T actual</code> are found to be equal, the program moves on, otherwise the program halts with <code>AssertionError</code> is thrown
	*	@Description runs an assert statement against an expected value and the actual value that are passed as parameters only when <code>debugOn == true</code>
	*	@param T expected the expected value to assert against the actual value
	*	@param T actualt he actual value to assert against the expected value
	*/
	public void assertEquals(T expected, T actual) {
		if(debugOn == true) {
			assert actual.equals(expected);
		}
	}

	/*
	* @Pre-Condition: <code>List<Integer> actual</code> is a iterable list of Integer objects
	*	@Post-Conditions: If the List of Integer objects is in stricly non-decreasing order, the program moves on normally, if not, the program halts with an <code>AssertionError</code>
	* @Description: runs an assertion statement against a list of Integer objects to ensure that for <code>k = actual.size(); A[k - 2] <= A[k - 1];</code>
	*	@param List<Integer> actual the list to assert is in stricly non-decreasing order
	*/
	public void assertOrder(List<Integer> actual) {
		if(debugOn == true) {
			int i = actual.size();
			while(i > 1) {
				assert actual.get(i - 1).compareTo(actual.get(i - 2)) >= 0;

				i--;
			}
		}
	}

	/*
	*	@Pre-Condition: <code>ArrayList<Integer> actual</code> is an ArrayList of Integer Objects
	*	@Post-Condition: If the ArrayList of Integer Objects is in stricly non-decreasing order, the program moves on normally, if not, the pgoram halts with an <code>AssertionError</code>
	*	@Description: runs an assertion statement against an ArrayList of Integer Objects to ensure that for <code>k = actual.size(); A[k-2] <= A[k-1];</code>
	*	@param ArrayList<Integer> actual the ArrayList to assert is in stricly non-decreasing order
	*/
	public void assertOrder(ArrayList<Integer> actual) {
		if(debugOn == true) {
			int i = actual.size();
			while(i > 1) {
				assert actual.get(i - 1).compareTo(actual.get(i - 2)) >= 0;

				i--;
			}
		}
	}

	/*
	*	@Pre-Condition: actual and expected both contain Integer Objects
	*	@Post-Condition: If all the elements inside of the actual arraylist are also contained in the expected arraylist, then the assertion holds true
	*	@Description: Tests to ensure a given ArrayList of Integer Objects contains all the elements of another given ArrayList of Integer Objects
	*	@param ArrayList<Integer> expected the list to check contains against
	*	@param ArrayList<Integer> actual the list to check to make sure all its elements are contained in the other arraylist
	*/
	public void assertContains(ArrayList<Integer> expected, ArrayList<Integer> actual) {
		if(debugOn == true) {
			for(int i = 0; i < actual.size(); i++) {
				assert expected.contains(actual.get(i));
			}
		}
	}

	/*
	*	@Pre-Condition: expectedOne, expectedTwo, and actual all contain Integer Objects
	*	@Post-Condition: If all the elemts inside of the actual ArrayList are also contined in either the expectedOne ArrayList or the expectedTwo ArrayList, then the assertion holds true
	*	@Description: Tests to ensure a given ArrayList of Integer Objects contains all the elements of another given ArrayList of Integer Objects
	*	@param: ArrayList<Integer> expectedOne one of the lists to check to see if the given ArrayList actual's elements are contained in
	*	@param: ArrayList<Integer> expectedTwo one of the lists to check to see if the given ArrayList actual's elements are contained in
	* @param: ArrayList<Integer> actual the list to check ot make sure all its elements are contained in either expectedOne or expectedTwo
	*/
	public void assertContains(ArrayList<Integer> expectedOne, ArrayList<Integer> expectedTwo, ArrayList<Integer> actual) {
		if(debugOn == true) {
			for(int i = 0; i < actual.size(); i++) {
				assert expectedOne.contains(actual.get(i)) || expectedTwo.contains(actual.get(i));
			}
		}
	}

	/*
	* @Description: asserts that the first arguement is stricly greator than the second arguement
	*	@param int large an integer primative value to assert is strictly greator than the second arguement
	*	@param int small an integer primative value to assert the first arguement is strictly greator than.
	*/
	public void assertStrictGreat(int large, int small) {
		if(debugOn == true) {
			assert large > small;
		}
	}

	/*
	*	@Description: asserts that the first arguement is strictly less than the second arguement
	*	@param int small an integer primative value to assert is stricly less than the second arguement
	*	@param int large an integer primative value to assert the first arguement is strictly less than.
	*/
	public void assertStrictLess(int small, int large) {
		if(debugOn == true) {
			assert small < large;
		}
	}

	/*
	*	@Description: asserts that the first arguement is greator than or equal to the second arguement
	*	@param int large an integer primative value to assert is greator than or equal to the second arguement
	*	@param int small an integer primative value to assert the first arguement is greator than or equal to.
	*/
	public void assertGreatEquals(int large, int small) {
		if(debugOn == true) {
			assert large >= small;
		}
	}

	/*
	*	@Description: asserts that the first arguement is less than or equal to the second arguement
	*	@param int small an integer primative value to assert is less than or equal to the second arguement
	*	@param int large an integer primative value to assert the first arguement is less than or equal to.
	*/
	public void assertLessEquals(int small, int large) {
		if(debugOn == true) {
			assert small <= large;
		}
	}
}
