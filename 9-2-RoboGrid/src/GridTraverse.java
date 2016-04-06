
public class GridTraverse {
	
	public static void main(String[] args) {
		System.out.println("GridTraverse Test");
		
		GridTraverse grid = new GridTraverse();
		
		for(int run = 0; run<10; run++) {
			System.out.println("Run #" + run);
			System.out.println("Coordinates (x,y) = (" + run + "," + run + ")");
			System.out.println("Output: " + grid.recursivePossiblePaths(0,0,run,run));
		}
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
}
