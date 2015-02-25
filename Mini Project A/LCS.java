/*
*	@Author: Preston Stosur-Bassett
*	@Description: LCS will find the longest common substring of two strings. 
*	@Date: 25.2.15
*	@Class: LCS
*/

public class LCS {
	int length;
	String sequence;

	public String runLCS(String one, String two) {
		if(one.length() > 0 && two.length() > 0) {
			String oneSub = one.substring(0, one.length()-1);
			String twoSub = two.substring(0, two.length()-1);

			if(one.length() == 0 || two.length() == 0) {
				length = 0;
				sequence = "";
				return sequence;
			}
			else if(one.charAt(one.length()-1) == two.charAt(two.length()-1)) {
				sequence = runLCS(oneSub, twoSub) + one.charAt(one.length()-1);
				return sequence;
			}
			else {
				String a = runLCS(one, twoSub);
				String b = runLCS(two, oneSub);
				
				if(a.length() > b.length()) {
					 sequence = a;
					 return sequence;
				}			
				else {
					sequence = b;
					return sequence;
				}
			}
		}
		else {
			return sequence;
		}
	}
}