
public class PaintFill {
	
	public static void main(String[] args) {
		System.out.println("Testing PaintFill....");
		
		PaintFill fill = new PaintFill();
		
		int[][] screen = new int[4][4];
		screen[0] = new int[]{0,1,1,0};
		screen[1] = new int[]{1,0,0,1};
		screen[2] = new int[]{1,0,0,1};
		screen[3] = new int[]{0,1,1,0};
		
		System.out.println("Initial screen: ");
		fill.printScreen(screen);
		
		int xSelect = 1;
		int ySelect = 1;
		int targetColor = 0;
		int paintColor = 2;
		fill.paintArea(screen, xSelect, ySelect, targetColor, paintColor);
		
		System.out.println("Result screen: ");
		fill.printScreen(screen);
	}
	
	public boolean paintArea(int[][] pixelColors, int pixelX, int pixelY, int targetColor, int paintColor){
		if(targetColor == paintColor) return false;
		else if(pixelColors[pixelY][pixelX] == targetColor) {
			fillArea( pixelColors, pixelX, pixelY, targetColor, paintColor);
			return true;
		}
		
		return false;
	}

	public void fillArea(int[][] pixelColors, int pixelX, int pixelY, int targetColor, int paintColor) {
		
		pixelColors[pixelY][pixelX] = paintColor;

		//UP
		if(pixelY < pixelColors.length - 1 && pixelColors[pixelY + 1][pixelX] == targetColor) {
			fillArea(pixelColors, pixelX, pixelY + 1, targetColor, paintColor);
		}
		
		//Down
		if(pixelY > 0 && pixelColors[pixelY - 1][pixelX] == targetColor) {
			fillArea(pixelColors, pixelX, pixelY - 1, targetColor, paintColor);
		}
		
		//Right
		if(pixelX < pixelColors[pixelY].length - 1 && pixelColors[pixelY][pixelX + 1] == targetColor) {
			fillArea(pixelColors, pixelX + 1, pixelY, targetColor, paintColor);
		}
		
		//Left
		if(pixelX > 0 && pixelColors[pixelY][pixelX - 1] == targetColor) {
			fillArea(pixelColors, pixelX - 1, pixelY, targetColor, paintColor);
		}
		
	}
	
	public void printScreen(int[][] screen){
		for(int y = 0; y<screen.length; y++) {
			StringBuffer row = new StringBuffer();
			for(int x = 0; x<screen[y].length; x++) {
				row.append(screen[y][x] + " ");
			}
			System.out.println(row.toString());
		}
	}
}
