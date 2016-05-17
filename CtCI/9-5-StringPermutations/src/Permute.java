
public class Permute {
	
	public static void main(String[] args) {
		Permute p = new Permute();
		
		System.out.println("Testing");
		
		String test = "abc";
		System.out.println("Test: " + test);
		System.out.println("Result: ");
		printPermutations(test);
	}

	public static void printPermutations(String toPermute) {
		recursivePermute(new char[toPermute.length()], toPermute.toCharArray(), 0);
	}
	
	public static void recursivePermute(char[] currString, char[] unUsed, int placePtr){
		int foundCount = 0;
		for(int letter = 0; letter < unUsed.length; letter++) {
			if(unUsed[letter] != 0) {
				foundCount++;
				char[] recString = currString.clone();
				char[] recUsed = unUsed.clone();
				
				recString[placePtr] = recUsed[letter];
				recUsed[letter] = 0;
				
				recursivePermute(recString, recUsed, placePtr + 1);
			}
		}
		
		if(foundCount == 0) {
			printCharArray(currString);
		}
	}
	
	//Find the kth element in an array
	public void find(int k, char[] backing) {
		
	}
	
	public static void printCharArray(char[] toPrint) {
		StringBuffer sBuff = new StringBuffer();
		
		for(int i = 0; i<toPrint.length; i++) {
			sBuff.append(toPrint[i]);
		}
		
		System.out.println(sBuff.toString());
	}
}
