
public class ScreenManager {
	public static void main(String[] args) {
		ScreenManager sm = new ScreenManager();
		
		int width = 8;
		int height = 56;
		
		byte[] screen = new byte[56*8];
		
		for(int i = 0; i<screen.length; i++) {
			screen[i] = 0;
		}
		
		byte isByte = 0;
		System.out.println("isByte = " + isByte);
		
		System.out.println("setBit(isByte, 1)" + sm.setBit(isByte, 1));
		
		sm.drawScreen(screen, width, height);
		
		System.out.println("Test 1");
		
		sm.drawHorizontalLine(screen, width, 1, 7, 3);
		sm.drawScreen(screen, width, height);
	}
	
	public void drawScreen(byte[] screen, int width, int height) {
		
		for(int y = 0; y<height; y++) {
			StringBuffer line = new StringBuffer();
			for(int x = 0; x < width; x++) {
				line.append(screen[y*width + x]);
			}
			System.out.println(line.toString());
		}
	}

	//This is assuming 0 indexed parameters - except width
	public void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
		int byteBegin = y*8 - 1 + x1/8;
		int indexBegin = x1 % 8;
		
		int byteEnd = y*8 - 1 + x2/8;
		int indexEnd = x2 % 8;
		
		int byteCurr = byteBegin;
		int indexCurr = indexBegin;
		
		System.out.println("Debug: byteBegin = " + byteBegin);
		System.out.println("Debug: byteEnd = " + byteEnd);
		
		while(byteCurr < byteEnd) {
			while(indexCurr <= 8) {
				setBit(screen[byteCurr], indexCurr);
				indexCurr++;
			}
			byteCurr++;
			indexCurr = 0;
		}
		
		while(indexCurr <= indexEnd) {
			setBit(screen[byteCurr], indexCurr);
			indexCurr++;
		}
	}
	
	//Needs to set the bit at index to 1, from left
	public byte setBit(byte base, int index) {
		int mask = 0b1 << (7 - index);
		
		return (byte) (base | mask);
	}
}
