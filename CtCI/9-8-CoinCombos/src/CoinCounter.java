
public class CoinCounter {
	public static void main(String[] args) {
		System.out.println("Testing CoinCounter...");
		CoinCounter count = new CoinCounter();
		
		for(int coinTotal = 0; coinTotal < 10; coinTotal++) {
			System.out.println("TEST: CoinTotal = " + coinTotal);
			System.out.println("Result = " + count.countCombinations(25, coinTotal));
			System.out.println("--END TEST--");
		}
	}

	public int countCombinations(int currDenom, int n) {
		int nextDenom = 0;
		switch(currDenom) {
		case 25:
			nextDenom = 10;
			break;
		case 10:
			nextDenom = 5;
			break;
		case 5:
			nextDenom = 1;
			break;
		case 1:
			return 1;
		}
		
		int comboCount = 0;
		
		for(int count = 0; count * currDenom <= n; count++) {
			comboCount += countCombinations(nextDenom, n - count*currDenom);
		}
		
		return comboCount;
	}
}
