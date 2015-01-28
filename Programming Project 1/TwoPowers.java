/*
*	@author: Preston Stosur-Bassett
*	@date: 9.1.15
*	@course: CS215 Algorithms
*	@instructor: Dr. Howser
*	@class: TwoPowers
*	@description: TwoPowers prints the value of 2 raised to the power of 0-10.
*/

import java.lang.Math;

public class TwoPowers {
	public static void main(String args[]) {
		System.out.println("Printing powers of 2 from 0-10...");
		//Run this loop 10 times to print out all the values of 2 from the power of 0 to the power of 10
		for(double i = 0; i < 11; i++) {
			//Raise 2 to the power of the current iterator value
			double ans = Math.pow(2, i);
			//Print the calculated values
			System.out.println("2^"+i+" ==> "+ans);
		}
	}
}
