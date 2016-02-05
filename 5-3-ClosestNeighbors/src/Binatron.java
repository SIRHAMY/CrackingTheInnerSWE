
public class Binatron {
	public static void main(String[] args) {
		Binatron b = new Binatron();
		
		int test = 1101;
		System.out.println("Test: " + test);
		System.out.println("Next Smallest: " + b.nextSmallest(test));
		System.out.println("Next Biggest: " + b.nextLargest(test));
	}

	public double nextSmallest(int enter) {
		
		int base = enter;
		int length = (int)(Math.log10(base) + 1);
		
		for(int i = 0; i < length-1; i++) {
			if(!getBit(base, i)) {
				if(getBit(base, i + 1)) {
					//Swap ze bits
					setBit(base, i + 1, 0);
					setBit(base, i, 1);
					return base;
				}
			}
		}
		
		setBit(base, 0, 0);
		return base += 0.1;
	}
	
	public double nextLargest(int enter) {
		int base = enter;
		int length = (int)(Math.log10(base) + 1);
		
		for(int i = 0; i < length-1; i++) {
			if(getBit(base, i)) {
				if(!getBit(base, i + 1)) {
					//Swap ze bits
					setBit(base, i + 1, 0);
					setBit(base, i, 1);
					return base;
				}
			}
		}
		
		setBit(base, length + 1, 1);
		setBit(base, length, 0);
		return base;
	}
	
	//0 index
	public boolean getBit(int base, int index) {
		int mask = 0b1 << index;
		
		mask = mask & base;
		
		return mask > 0;
	}
	
	public void setBit(int base, int index, int value) {
		int mask = 0b0 | value;
		mask = mask << index;
		
		base = base | mask;
	}
}
