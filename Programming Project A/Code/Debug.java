/*
*	@Author Preston Stosur-Bassett
*	@Date Jan 21, 2015
*	@Class Debug
*	@Description This class will help debugging by being able to turn on and turn off debug messages easily
*/

import java.util.List;

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
	public void assertGreatEqual(int large, int small) {
		if(debugOn == true) {
			assert large >= small;
		}
	}

	/*
	*	@Description: asserts that the first arguement is less than or equal to the second arguement
	*	@param int small an integer primative value to assert is less than or equal to the second arguement
	*	@param int large an integer primative value to assert the first arguement is less than or equal to.
	*/
	public void assertLessEqual(int small, int large) {
		if(debugOn == true) {
			assert small <= large;
		}
	}
}
