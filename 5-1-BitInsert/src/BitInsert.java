
public class BitInsert {
	public static void main(String[] args) {
		BitInsert b = new BitInsert();
		
		int base = 100000;
		int m = 10011;
		int i = 0;
		int j = 5;
		
		System.out.println("Test: ");
		System.out.println("\t Base: " + base);
		System.out.println("\t m: " + m);
		System.out.println("\t i: " + i);
		System.out.println("\t j: " + j);
		System.out.println("\t Result: " + b.insertBits(base, m, i, j));
		
		base = 1000;
		m = 111;
		i = 0;
		j=3;
		
		System.out.println("Test: ");
		System.out.println("\t Base: " + base);
		System.out.println("\t m: " + m);
		System.out.println("\t i: " + i);
		System.out.println("\t j: " + j);
		System.out.println("\t Result: " + b.insertBits(base, m, i, j));
		
		base = 1100;
		m = 11;
		i = 0;
		j = 2;
		
		System.out.println("Test: ");
		System.out.println("\t Base: " + base);
		System.out.println("\t m: " + m);
		System.out.println("\t i: " + i);
		System.out.println("\t j: " + j);
		System.out.println("\t Result: " + b.insertBits(base, m, i, j));
	}
	
	//Insert m into n
	public int insertBits(int base, int toInsert, int start, int end) {
		
		//Clearing space between start and end
		int bitClear = 1 << (end - start + 1);
		bitClear = ~bitClear;
		bitClear = bitClear << (start - 1);
		bitClear = ~bitClear;
		
		base = base & bitClear;
		
		System.out.println("Debug: Base after clear: " + base);
		
		//Shift toInsert and insert into base
		toInsert = toInsert << start;
		
		System.out.println("Debug: toInsert: " + toInsert);
		
		return base | toInsert;
	}
}
