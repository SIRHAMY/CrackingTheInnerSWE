/**
 * This questions calls for an implementation of Towers of Hanoi using stacks.
 * 
 * I couldn't figure out/remember the algorithm for solving Towers of Hanoi,
 * so I went over to Khan Academy's Recursive Algorithm course. Super helpful - 
 * check it out if you're struggling with recursive functions. Anyway, the design
 * here closely resembles it and that's why.
 * 
 * @author Hamilton Greene
 *
 */
public class TowersOfHanoi {
	private DiskStack left;
	private DiskStack middle;
	private DiskStack right;
	
	public TowersOfHanoi(int n) {
		left = new DiskStack();
		middle = new DiskStack();
		right = new DiskStack();
		
		for(int i = n; i>0; i--) {
			left.push(new Disk(i));
		}
		
		System.out.println("Initial Tower State");
		printHanoi();
		
		solveHanoi(n, left, right);
	}
	
	public void solveHanoi(int numDisks, DiskStack fromPeg, DiskStack toPeg) {
		if(numDisks == 0) return;
		
		DiskStack sparePeg = getSparePeg(fromPeg, toPeg);
		solveHanoi(numDisks - 1, fromPeg, sparePeg);
		moveDisk(fromPeg, toPeg);
		printHanoi();
		solveHanoi(numDisks - 1, sparePeg, toPeg);
	}
	
	//Move top Disk from fromPeg to toPeg
	public void moveDisk(DiskStack fromPeg, DiskStack toPeg) {
		toPeg.push(fromPeg.pop());
	}
	
	public DiskStack getSparePeg(DiskStack fromPeg, DiskStack toPeg) {
		if(fromPeg != left && toPeg != left) {
			return left;
		} else if (fromPeg != right && toPeg != right) {
			return right;
		} else {
			return middle;
		}
	}
	
	public void printHanoi() {
		System.out.println("Tower State");
		System.out.println("Left : " + left.toString());
		System.out.println("Middl: " + middle.toString());
		System.out.println("Right: " + right.toString());
		
	}
}
