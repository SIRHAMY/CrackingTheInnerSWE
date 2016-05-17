
public class BitInsert {
	public static void main(String[] args) {
		BitInsert b = new BitInsert();
		
		int base = 0b100000;
		int m = 0b10011;
		int i = 0;
		int j = 5;
		int expected = 110011;
		
		System.out.println("Test: ");
		System.out.println("\t Base: " + base);
		System.out.println("\t m: " + m);
		System.out.println("\t i: " + i);
		System.out.println("\t j: " + j);
		System.out.println("\t Expected: " + Integer.parseInt(expected + "", 2));
		System.out.println("\t Result: " + b.insertBits(base, m, i, j));
		
		base = 0b1000;
		m = 0b111;
		i = 0;
		j=3;
		expected = 1111;
		
		
		System.out.println("Test: ");
		System.out.println("\t Base: " + base);
		System.out.println("\t m: " + m);
		System.out.println("\t i: " + i);
		System.out.println("\t j: " + j);
		System.out.println("\t Expected: " + Integer.parseInt(expected + "", 2));
		System.out.println("\t Result: " + b.insertBits(base, m, i, j));
		
		base = 0b1100;
		m = 0b11;
		i = 0;
		j = 2;
		expected = 1111;
		
		System.out.println("Test: ");
		System.out.println("\t Base: " + base);
		System.out.println("\t m: " + m);
		System.out.println("\t i: " + i);
		System.out.println("\t j: " + j);
		System.out.println("\t Expected: " + Integer.parseInt(expected + "", 2));
		System.out.println("\t Result: " + b.insertBits(base, m, i, j));
		
		//System.out.println("" + (0b00001010 | 0b00000100));
	}
	
	//Insert m into n
	public int insertBits(int base, int toInsert, int start, int end) {
		
		//Clearing space between start and end
		int bitClear = ~0 << (end - start + 1);
		bitClear = ~bitClear;
		bitClear = bitClear << (start - 1);
		bitClear = ~bitClear;
		
		base = base & bitClear;
		
		//System.out.println("Debug: Base after clear: " + base);
		
		//Shift toInsert and insert into base
		toInsert = toInsert << start;
		
		//System.out.println("Debug: toInsert: " + toInsert);
		
		return base | toInsert;
	}
}
