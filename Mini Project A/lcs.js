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
		return (a.length > b.length) ? a : b;
	}
}

