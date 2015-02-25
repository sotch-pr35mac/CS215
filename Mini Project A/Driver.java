public class Driver {
	public static void main(String args[]) {
		String first = "ABCDAC";
		String second = "AADOKC";

		LCS lcs = new LCS();
		String result = lcs.runLCS(first, second);

		System.out.println("Subsequence: "+result);
		System.out.println("Length: "+result.length());
	}
}