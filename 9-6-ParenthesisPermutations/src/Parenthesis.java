
public class Parenthesis {
	public static void main(String[] args) {
		System.out.println("Testing parenthesis permutation generator");
		
		Parenthesis p = new Parenthesis();
		
		for(int i = 0; i<4; i++) {
			System.out.println("Testing with n = " + i);
			p.generatePermutations(i);
			System.out.println("- - - - End test - - - -");
		}
	}
	
	public void generatePermutations(int n) {
		permutationHelper(n, 0, 0, new StringBuffer());
	}
	
	public void permutationHelper(int n, int open, int close, StringBuffer currString) {
		if(open == close && close == n) {
			System.out.println(currString.toString());
			return;
		}
		
		if(open != n) {
			StringBuffer newString = new StringBuffer(currString.toString());
			newString.append("(");
			permutationHelper(n, open + 1, close, newString);
		}
		
		if(close < open) {
			StringBuffer newString = new StringBuffer(currString.toString());
			newString.append(")");
			permutationHelper(n, open, close + 1, newString);
		}
	}
}
