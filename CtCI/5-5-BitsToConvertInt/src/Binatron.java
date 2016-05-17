
public class Binatron {
	
	public static void main(String[] args) {
		Binatron b = new Binatron();
		
		
		int A = 31;
		int B = 14;
		System.out.println("Testing - A: " + A + " B: " + B);
		System.out.println("Result = " + b.bitsToConvert(A, B));
	}

	public int bitsToConvert(int aRaw, int bRaw) {
		
		String AString = Integer.toBinaryString(aRaw);
		String BString = Integer.toBinaryString(bRaw);
		
		int length = Math.max(AString.length(), BString.length());
		
		System.out.println("Debug: Length = " + length);
		
		int A = decToBin(aRaw);
		int B = decToBin(bRaw);
		
		System.out.println("A = " + A);
		System.out.println("B = " + B);
		 
		
		int requiredBits = 0;
		
		int i = 0;
		//while(((0b1 << i) & A) == ((0b1 << i) & B) && ((0b1<<i) & A) == 0) i++;
		
		for (; i < length; i++) {
			int mask = 0b1 << i;
			
			System.out.println("Debug: " + (mask&A) + " ==? " + (mask&B));
			if((mask&A) != (mask&B)) requiredBits++;
		}
		
		return requiredBits;
	}
	
	public int decToBin(int raw) {
		int marker = 2;
		int placeHolder = 0;
		
		int remainder = raw;
		
		int result = 0b0;
		
		while(marker < raw) {
			marker *= 2;
			placeHolder++;
		}
		
		marker/=2;
		
		while(remainder > 0) {
			int toAdd = 0;
			if(marker <= remainder) {
				remainder -= marker;
				toAdd = 1;
			}
			
			result = result | (0b1 << placeHolder);
			placeHolder--;
			marker/=2;
		}
		
		return result;
	}
}
