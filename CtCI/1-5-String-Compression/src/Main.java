
public class Main {
	public static void main(String[] args) {
		StringCompress comp = new StringCompress();
		
		String test = "aabcccccaaa";
		System.out.println("Input: " + test);
		System.out.println("Result: " + comp.basicCompress(test));
		
		test = "abc";
		System.out.println("Input: " + test);
		System.out.println("Result: " + comp.basicCompress(test));
		
		test = "aabbccddd";
		System.out.println("Input: " + test);
		System.out.println("Result: " + comp.basicCompress(test));
		
		test = "aabbccdd";
		System.out.println("Input: " + test);
		System.out.println("Result: " + comp.basicCompress(test));
	}
}
