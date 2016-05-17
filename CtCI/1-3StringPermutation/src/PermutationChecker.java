import java.util.Arrays;

public class PermutationChecker {

	public boolean isPermutation(String strA, String strB) 
	{
		//Permutations must use all chars of original string
		if(strA.length() != strB.length()) return false;
		if(strA.length() <= 0) return false;
		
		int[] charLib = new int[256];
		Arrays.fill(charLib, 0);
		
		for(int i = 0; i<strA.length(); i++)
		{
			if(charLib[strA.charAt(i)] == 0) charLib[strA.charAt(i)] = 1;
			else charLib[strA.charAt(i)]++;
		}
		
		for(int j = 0; j< strB.length(); j++) 
		{
			charLib[strB.charAt(j)]--;
			if(charLib[strB.charAt(j)] < 0) return false;
		}
		
		return true;
	}
}
