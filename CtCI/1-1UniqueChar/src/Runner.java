
public class Runner {
	public static void main(String[] args) {
		UniqueChar checker = new UniqueChar();
		UniqueCharNoDS checker2 = new UniqueCharNoDS();
		
		String word = "abra";
		System.out.println("Word: " + word);
		System.out.println("Result1: " + checker.hasUniqueChar(word));
		System.out.println("Result2: " + checker2.hasUniqueChar(word));
		
		word = "abcd";
		System.out.println("Word: " + word);
		System.out.println("Result1: " + checker.hasUniqueChar(word));
		System.out.println("Result2: " + checker2.hasUniqueChar(word));
		
		word = "";
		System.out.println("Word: " + word);
		System.out.println("Result1: " + checker.hasUniqueChar(word));
		System.out.println("Result2: " + checker2.hasUniqueChar(word));
		
		word = "lulz";
		System.out.println("Word: " + word);
		System.out.println("Result1: " + checker.hasUniqueChar(word));
		System.out.println("Result2: " + checker2.hasUniqueChar(word));
	}
}
