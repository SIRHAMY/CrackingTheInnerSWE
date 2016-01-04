import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		CharReplace aReplace = new CharReplace();
		
		char[] test = aReplace.fillCharArray("Test", 50);
		System.out.println("Original: " + Arrays.toString(test));
		aReplace.spaceReplace(test, 4);
		System.out.println("Result: " + Arrays.toString(test));
		
		test = aReplace.fillCharArray("Test Space", 50);
		System.out.println("Original: " + Arrays.toString(test));
		aReplace.spaceReplace(test, 10);
		System.out.println("Result: " + Arrays.toString(test));
		
		test = aReplace.fillCharArray("5Spaces     ", 50);
		System.out.println("Original: " + Arrays.toString(test));
		aReplace.spaceReplace(test, 11);
		System.out.println("Result: " + Arrays.toString(test));
	}
	
	
}
