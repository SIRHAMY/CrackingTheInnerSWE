
public class Binatron {
	public static void main(String[] args) {
		Binatron b = new Binatron();
		
		int setBitTest = 0b11;
		System.out.println("Expected 10 - Actual " + b.clearBit(setBitTest, 0));
		
		int test = 0b1101;
		System.out.println("Test: " + test);
		System.out.println("Next Smallest: " + b.nextSmallest(test));
		System.out.println("Next Biggest: " + b.nextLargest(0b1101));
	}

	public double nextSmallest(int enter) {
		
		System.out.println("Debug: Smallest");
		
		int base = enter;
		
		//This thing might be the problem
		int length = (int)(Math.log10(base) + 1);
		
		for(int i = 0; i < length-1; i++) {
			if(!getBit(base, i)) {
				System.out.println("Debug: 0 found at index: " + i);
				
				if(getBit(base, i + 1)) {
					System.out.println("Debug: Found 1 next to it");
					System.out.println("Debug: Base Before = " + base);
					
					//Swap ze bits
					base = clearBit(base, i + 1);
					base = setBit(base, i);
					
					System.out.println("Debug: Base after = " + base);
					
					return base;
				}
			}
		}
		
		base = clearBit(base, 0);
		return base += 0.1;
	}
	
	public double nextLargest(int enter) {
		System.out.println("Largest");
		
		int base = enter;
		int length = (int)(Math.log10(base) + 1);
		
		System.out.println("Debug: Enter = " + base);
		
		for(int i = 0; i < length; i++) {
			if(getBit(base, i)) {
				System.out.println("Debug: Found a 1 at index: " + i);
				if(!getBit(base, i + 1)) {
					System.out.println("And there's a 0 here at index" + (i+1));
					//Swap ze bits
					base = setBit(base, i + 1);
					base = clearBit(base, i);
					
					System.out.println("Debug: changed = " + base);
					return base;
				}
			}
		}
		
		base = setBit(base, length + 1);
		base = clearBit(base, length);
		return base;
	}
	
	//0 index
	public boolean getBit(int base, int index) {
		int mask = 0b1 << index;
		
		mask = mask & base;
		
		return mask > 0;
	}
	
	public int setBit(int base, int index) {
		return base | (0b1<<base);
	}
	
	public int clearBit(int base, int index) {
		int mask = ~(0b1 << index);
		return base & mask;
	}
}
