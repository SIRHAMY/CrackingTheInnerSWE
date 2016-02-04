
public class BinaryConverter {
	
	public static void main(String[] args) {
		BinaryConverter b = new BinaryConverter();
		
		double test = 0.5;
		System.out.println("Testing: " + test);
		System.out.println("Result: " + b.decimalToBinary(test));
		
		test = 0.625;
		System.out.println("Testing: " + test);
		System.out.println("Result: " + b.decimalToBinary(test));
		
		test = 0.75;
		System.out.println("Testing: " + test);
		System.out.println("Result: " + b.decimalToBinary(test));
		
		test = 0.72;
		System.out.println("Testing: " + test);
		System.out.println("Result: " + b.decimalToBinary(test));
	}

	public double decimalToBinary(double toChange) {
		
		double remainder = toChange;
		
		double decrement = 0.5;
		double result = 0;
		int placeHolder = 1;
		
		while(remainder > 0.0){
			if(remainder >= decrement) {
				result += 1 / Math.pow(10, placeHolder);
				remainder -= decrement;
			}
			
			decrement /= 2;
			placeHolder++;
			
			if(placeHolder > 32) {
				System.out.println("ERROR");
				return -1;
			}
		}
		
		return result;
	}
}
