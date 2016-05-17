
public class Main {
	public static void main(String[] args) {
		System.out.println("Stairways Enabled");
		
		for(int i = 0; i<5; i++) {
			System.out.println("Stairways " + i + ": " + stairways(i));
		}
		
	}
	
	public static int stairways(int steps) {
		if(steps < 0) return 0;
		else if(steps == 0) return 1;
		else return stairways(steps - 1) + stairways(steps - 2) + stairways(steps - 3);
	}
}
