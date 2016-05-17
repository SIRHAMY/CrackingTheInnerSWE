
public class NumFinder {
	public static void main(String[] args) {
		NumFinder numFinder = new NumFinder();
		
		for(int i = 0; i < 10; i++) {
			System.out.println("Kth num = " + i);
			System.out.println("Output: " + numFinder.findNum(i));
		}
	}

	public int findNum(int k) {
		int result = 0;
		
		int[] baseNums = new int[3];
		baseNums[2] = 3; //3
		baseNums[1] = 5; //5
		baseNums[0] = 7; //7
		
		int baseExponent = k / 8;
		int largerExponentPtr = k % 8;
		
		int[] combos = getExponentOffset(largerExponentPtr);
		
		
		result = (int) Math.pow(baseNums[2], baseExponent +combos[2]) * 
				(int) Math.pow(baseNums[1], baseExponent + combos[1]) *
				(int) Math.pow(baseNums[0], baseExponent + combos[0]);
		
		return result;
	}
	
	public int[] getExponentOffset(int largerExp) {
		int[] combos = new int[3];
		combos[0] = 0;
		combos[1] = 0;
		combos[2] = 0;
		
		//This is fucking up on 9
		switch(largerExp) {
			case 0: 
				break;
			case 1:
				break;
			case 2:
				combos[2] = 1;
				break;
			case 3:
				combos[1] = 1;
				break;
			case 4: 
				combos[0] = 1;
				break;
			case 5: 
				combos[1] = 1;
				combos[2] = 1;
				break;
			case 6:
				combos[0] = 1;
				combos[2] = 1;
				break;
			case 7: 
				combos[0] = 1;
				combos[1] = 1;
				break;
			default:
				System.out.println("Error: Unexpected largerExp");
		}
		
		return combos;
	}
}
