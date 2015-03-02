/*
*	@Author: Preston Stosur-Bassett
*	@Date: 25.2.15
*	@Language: Javascript
*	@Description: The javascript function will find the longest common substring of two strings.
*/

function breadcrumbs(tab, one, two) {
	if(one.length == 0 || two.length == 0) {
		return "";
	}
	else {
		var oneSub = one.substr(0, one.length - 1);
		var twoSub = two.substr(0, two.length - 1);

		if(one[one.length - 1] == two[two.length - 1]) {
			return breadcrumbs(tab, oneSub, twoSub) + one[one.length - 1];
		}
		else {
			if(tab[one.length][two.length - 1] > tab[one.length - 1][two.length]) {
				return breadcrumbs(tab, one, twoSub);
			}
			else {
				return breadcrumbs(tab, oneSub, two);
			}
		}
	}
}

function lcs(one, two) {
	var tab = [];
	var lcsVal = 0;

	for(var i = 0; i <= one.length; i++) {
		tab[i] = [];
		for(var y = 0; y <= two.length; y++) {
			tab[i][y] = 0;
		}
	}

	for(var o = 0; o < one.length; o++) {
		for(var t = 0; t < two.length; t++) {
			if(one[o] == two[t]) {
				tab[o+1][t+1] = tab[o][t] + 1;
			}
			else {
				tab[o+1][t+1] = Math.max(tab[o][t+1], tab[o+1][t]);
			}
			if(tab[o+1][t+1] > lcsVal) {
				lcsVal = tab[o+1][t+1];
			}
		}
	}

	return {
		sequence: breadcrumbs(tab, one, two),
		length: lcsVal
	};
}

//This function serves as the driver function
function driver() {
	//This data takes far too long to execute, moving to data provided in the second paragraph on page 391.
	var stringOne = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
	var stringTwo = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
	var matchString = "GTCGTCGGAAGCCGGCCGAA";

	console.log("Original String 1: "+stringOne);
	console.log("Original String 2: "+stringTwo);

	var resultString = lcs(stringOne, stringTwo);

	console.log("The expected length of the largest common subsequnce is: "+matchString.length);
	console.log("The actual length of the largest common subsequence is: "+resultString.length);
	console.log("");
	if(matchString.length == resultString.length) {
		console.log("The actual and expected lengths match.");
		console.log("");
		console.log("Moving on...");
		console.log("");
		console.log("Resulting Substring: "+resultString.sequence);
		console.log("Resulting Substring should match the proposed Resulting Substring: "+matchString);
		console.log("");
		if(resultString.sequence == matchString) {
			console.log("Strings match! Programm successful.");
			console.log("Program Terminating...");
		}
		else {
			console.log("Oops... Strings do not match. Program unsuccessful.");
		}
	}
	else {
		console.log("The actual and expected lengths do not match. Program unsuccessful.");
	}
}

//Run the driver.
driver();
