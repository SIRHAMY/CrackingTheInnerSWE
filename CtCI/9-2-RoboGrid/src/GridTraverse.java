import java.util.ArrayList;

public class GridTraverse {
	
	public static void main(String[] args) {
		System.out.println("GridTraverse Test");
		
		GridTraverse traverse = new GridTraverse();
		
		for(int run = 0; run<10; run++) {
			System.out.println("Run #" + run);
			System.out.println("Coordinates (x,y) = (" + run + "," + run + ")");
			System.out.println("Output: " + traverse.recursivePossiblePaths(0,0,run,run));
		}
		
		Grid blockage = new Grid(6, 6);
		blockage.setBlocked(1, 1, true);
		blockage.setBlocked(2, 2, true);
		
		System.out.println("GridTraverse Test with Blocked tiles");
		for(int run = 0; run<10; run++) {
			System.out.println("Run #" + run);
			System.out.println("Coordinates (x,y) = (" + run + "," + run + ")");
			System.out.println("Output: " + traverse.recursivePossiblePaths(0,0,run,run, blockage));
		}
		
		System.out.println("Debug: " + blockage.printGrid());
		
	}

	/*Input the coordinates of the start and end point, get back the number of paths 
	 * Runs under the assumption that the only possible moves are right and down
	 */
	public int recursivePossiblePaths(int xStart, int yStart, int xEnd, int yEnd) {
		if(xStart == xEnd && yStart == yEnd) return 1;
		
		int paths = 0;
		if(xStart < xEnd) paths += recursivePossiblePaths(xStart + 1, yStart, xEnd, yEnd);
		if(yStart < yEnd) paths += recursivePossiblePaths(xStart, yStart + 1, xEnd, yEnd);
		
		return paths;
	}
	
	/*
	 * This implementation gives the option to pass in an array of "blocked" coordinates
	 * that the robot can't traverse over
	 */
	public int recursivePossiblePaths(int xStart, int yStart, int xEnd, int yEnd, Grid blocked) {
		if(xStart == xEnd && yStart == yEnd) return 1;
		
		int paths = 0;
		if(xStart < xEnd && !blocked.isBlocked(xStart + 1, yStart)) 
			paths += recursivePossiblePaths(xStart + 1, yStart, xEnd, yEnd);
		if(yStart < yEnd && !blocked.isBlocked(xStart, yStart + 1)) 
			paths += recursivePossiblePaths(xStart, yStart + 1, xEnd, yEnd);
		
		return paths;
	}
}
