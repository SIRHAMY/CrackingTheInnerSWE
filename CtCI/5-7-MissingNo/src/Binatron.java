
public class Binatron {
	
	public static void main(String[] args) {
		Binatron b = new Binatron();
		
		System.out.println("Test accessVal");
		int[] testArray = new int[2];
		testArray[0] = 0b1100;
		testArray[1] = 0b0011;
		
		printAccessEvalTest(testArray, 0, 0, false);
		printAccessEvalTest(testArray, 1, 1, true);
		
		System.out.println("----------");
		System.out.println("Return Whole Value Test");
		printReturnWholeValueTest(testArray, 0, testArray[0]);
		printReturnWholeValueTest(testArray, 1, testArray[1]);
		
		
		System.out.println("----------");
		System.out.println("Find missingNo test");
		
		int[] missing = new int[5];
		missing[0] = 0b0;
		missing[1] = 0b1;
		missing[2] = 0b10;
		missing[3] = 0b11;
		missing[4] = 0b101; //Missing 4
		//missing[5] = 0b110;
		
		printMissingNoTest(missing, 0b100);
		printMissingNo2Test(missing, 0b100);
		
	}
	
	//Should be O(n)
	public static int missingNo(int[] array) {
		for(int i = 0; i < array.length; i++) {
			//If ! (odd and 0 bit is odd) - issue
			if(!((i % 2 == 1) == accessVal(array, i, 0))){
				return returnWholeValue(array, i) - 0b1;
			}
		} 
		
		return 0;
	}
	
	//Should be O(logn)
	public static int missingNo2(int[] array) {
		return missingNo2Helper(array, array.length/2, array.length);
	}
	
	public static int missingNo2Helper(int[] array, int index, int size){
		if(size == 1) {
			if(index < size - 1 && accessVal(array, index, 0) == accessVal(array,index + 1,0)) return index+1;
			if(index > 0 && accessVal(array, index, 0) == accessVal(array,index - 1,0)) return index;
			return -1;
		}
		
		if(accessVal(array, index, 0) == (index % 2 == 1)) {
			if(index < size - 1 && accessVal(array, index, 0) == accessVal(array,index + 1,0)) return index+1;
			
			return missingNo2Helper(array, index + size/2, size/2);
		} else {
			if(index > 0 && accessVal(array, index, 0) == accessVal(array,index - 1,0)) return index;
			
			return missingNo2Helper(array, index - size/2, size/2);
		}
		
	}

	public static boolean accessVal(int[] array, int index, int bitNum) {
		int result;
		
		int mask = 0b1 << bitNum;
		
		result = array[index] & mask;
		
		return result > 0;
	}
	
	public static int returnWholeValue(int[] array, int index) {
		int result = 0b00000000;
		
		for(int i = 0; i < 8; i++) {
			if(accessVal(array, index, i)) {
				int mask = 0b1 << i;
				result = result | mask;
			}
		}
		
		return result;
	}
	
	public static void printMissingNoTest(int[] array, int expected) {
		System.out.println("PrintMissingNoTest");
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + missingNo(array));
	}
	
	public static void printMissingNo2Test(int[] array, int expected) {
		System.out.println("PrintMissingNo2Test");
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + missingNo(array));
	}
	
	public static void printReturnWholeValueTest(int[] array, int index, int expected) {
		System.out.println("ReturnWholeValue Test: index = " + index + " Expected = " + expected);
		System.out.println("Actual: " + returnWholeValue(array, index));
	}
	
	public static void printAccessEvalTest(int[] array, int index, int bitNum, boolean expected) {
		
		System.out.println("accessVal Test: index = " + index + " bitNum: " + bitNum);
		System.out.println("expected: " + expected);
		System.out.println("Actual: " + accessVal(array, index, bitNum));
	}
}
