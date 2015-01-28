/*
*	@Author Preston Stosur-Bassett
*	@Date Jan 21, 2015
*	@Class Debug
*	@Description This class will help debugging by being able to turn on and turn off debug messages easily
*/

public class Debug {
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
	public void print(String message) {
		if(debugOn == true) {
			System.out.println(message);
		}
	}
}