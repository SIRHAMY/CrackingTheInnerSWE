
public class CoinCounter {
	public static void main(String[] args) {
		System.out.println("Testing CoinCounter...");
		CoinCounter count = new CoinCounter();
		
		for(int coinTotal = 0; coinTotal < 10; coinTotal++) {
			System.out.println("TEST: CoinTotal = " + coinTotal);
			System.out.println("Result = " + count.countCombinations(0, coinTotal));
			System.out.println("--END TEST--");
		}
	}

	public int countCombinations(int currTotal, int n) {
		int[] denominations = new int[]{1,5,10,25};
		int comboCount = 0;
		
		for(int denom = 0; denom < denominations.length; denom++) {
			int tempTotal = denominations[denom] + currTotal;
			if( tempTotal < n ) {
				comboCount += countCombinations(tempTotal, n);
			} else if( tempTotal == n ) {
				comboCount += 1;
				return comboCount;
			} else {
				break;
			}
		}
		
		return comboCount;
	}
}
