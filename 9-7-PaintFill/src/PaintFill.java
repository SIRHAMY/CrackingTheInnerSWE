
public class PaintFill {
	public boolean paintArea(int[][] pixelColors, int pixelX, int pixelY, int targetColor, int paintColor){
		if(targetColor == paintColor) return false;
		else {
			return fillArea( pixelColors, pixelX, pixelY, targetColor, paintColor);
		}
	}

	public boolean fillArea(int[][] pixelColors, int pixelX, int pixelY, int targetColor, int paintColor) {
		
		//We only fill and check surrounding pixels if the current pixel was the correct color
		if(targetColor == pixelColors[pixelX][pixelY]) {
			pixelColors[pixelX][pixelY] = targetColor;
			
			//Check surrounding pixels for colorMatch
			
			//UP
			if(pixelY < pixelColors[0].length - 1) {
				fillArea(pixelColors, pixelX, pixelY + 1, targetColor, paintColor);
			}
			
			//Down
			if(pixelY > 0) {
				fillArea(pixelColors, pixelX, pixelY - 1, targetColor, paintColor);
			}
			
			//Right
			if(pixelX < pixelColors.length - 1) {
				fillArea(pixelColors, pixelX + 1, pixelY, targetColor, paintColor);
			}
			
			//Left
			if(pixelX > 0) {
				fillArea(pixelColors, pixelX - 1, pixelY, targetColor, paintColor);
			}
			
			return true;
		}
		
		return false;
		
	}
}
