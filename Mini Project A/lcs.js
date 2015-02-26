/*
*	@Author: Preston Stosur-Bassett
*	@Date: 25.2.15
*	@Language: Javascript
*	@Description: The javascript function will find the longest common substring of two strings.
*/

function lcs(one, two) {
	var oneSub = one.substr(0, one.length-1);
	var twoSub = two.substr(0, two.length-1);

	if(one.length == 0 || two.length == 0) {
		return "";
	}
	else if(one.charAt(one.length-1) == two.charAt(two.length-1)) {
		return lcs(oneSub, twoSub) + one.charAt(one.length - 1);
	}
	else {
		var a = lcs(one, twoSub);
		var b = lcs(oneSub, two);
		if(a.length > b.length) {
			return a;
		}
		else {
			return b;
		}
	}
}

//This function serves as the driver function
function driver() {
	var stringOne = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
	var stringTwo = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
	var matchString = "GTCGTCGGAAGCCGGCCGAA";
	console.log("Original String 1: "+stringOne);
	console.log("Original String 2: "+stringTwo);


	var resultString = lcs(stringOne, stringTwo);
	console.log("Resulting Substring: "+resultString);
	console.log("Resulting Substring should match the proposed Resulting Substring: "+matchString);

	if(resultString == matchString) {
		console.log("Strings match! Programm successful.");
	}
	else {
		console.log("Oops... Strings do not match. Program unsuccessful.");
	}
}

//Run the driver.
driver();
