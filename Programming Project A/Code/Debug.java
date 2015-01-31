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
	*
	*/
	public void assertOrder(List<Integer> actual) {
		if(debugOn == true) {
			int i = actual.size();
			while(i > 1) {
				assert actual.get(i - 1).compareTo(actual.get(i - 2)) > 1;

				i--;
			}
		}
	}
}
