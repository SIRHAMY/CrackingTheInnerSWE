
public class Binatron {
	public static void main(String[] args) {
		Binatron b = new Binatron();
		
		int test = 0b1010;
		int expected = 0b0101;
		
		System.out.println("Test: " + test);
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + b.bitSwap(test));
		
		
		test = 0b010111;
		expected = 0b101011;
		
		System.out.println("Test: " + test);
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + b.bitSwap(test));
	}

	public int bitSwap(int base) {
		int maskEven = 0b10101010;
		int maskOdd = 0b01010101;
		
		maskEven = base & maskEven;
		maskOdd = base & maskOdd;
		
		maskEven = maskEven >> 1;
		maskOdd = maskOdd << 1;
		
		return maskEven | maskOdd;
	}
}
