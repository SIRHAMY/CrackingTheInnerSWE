
public class Ops {
	public static void main(String[] args) {
		System.out.println("Multiply test");
		int multA = 5;
		int multB = 6;
		printTest("MultTest", multA, multB, multA * multB);
		printActual(mult(multA, multB));
		
		int divA = 10;
		int divB = 2;
		printTest("DivTest", divA, divB, divA / divB);
		printActual(divide(divA, divB));
		
		int subA = 10;
		int subB = 7;
		printTest("SubTest", subA, subB, subA - subB);
		printActual(subtract(subA, subB));
		
		printTest("SubTest", subB, subA, subB - subA);
		printActual(subtract(subB, subA));
	}

	public static int mult(int a, int b) {
		
		int result = 0;
		
		for(int counter = 1; counter < b; counter++) {
			result += b;
		}
		
		return result;
	}
	
	public static int divide(int a, int b) {
		int result = 0;
		int placeHolder = 0;
		
		while(placeHolder + b <= a) {
			placeHolder += b;
			result++;
		}
		
		return result;
	}
	
	public static int subtract(int a, int b) {
		int result = 0;
		int placeHolder;
		
		if(b <= a) {
			placeHolder = b;
			while(placeHolder < a) {
				placeHolder++;
				result++;
			}
		} else {
			placeHolder = a;
			while(placeHolder < b) {
				placeHolder++;
				result++;
			}
			
			result = -result;
		}		
		
		return result;
	}
	
	public static void printTest(String test, int a, int b, int expected) {
		System.out.println(test + ": A = " + a + ", B = " + b + ", Expected: " + expected);
	}
	
	public static void printActual(int actual) {
		System.out.println("Actual: " + actual);
	}
}
