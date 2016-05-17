
public class IndexWand {
	
	public static void main(String[] args) {
		IndexWand finder = new IndexWand();
		
		int[] test1 = new int[10];
		for(int i = 0; i<10; i++) {
			test1[i] = i-1;
		}
		
		System.out.println("Test1 - Expected: -1");
		System.out.println(findMagic(test1, 0, test1.length));
		
		test1[9] = 9;
		System.out.println("Test2 - Expected: 9");
		System.out.println(findMagic(test1, 0, test1.length));
		
		int[] test2 = new int[10];
		for(int i = 0; i<10; i++) {
			test2[i] = i+1;
		}
		
		System.out.println("Test 3 - Expected: -1");
		System.out.println(findMagic(test2, 0, test2.length));
		
		test2[1] = 1;
		test2[0] = -1;
		
		System.out.println("Test 4 - Expected: 1");
		System.out.println(findMagic(test2, 0, test2.length));
	}

	/**
	 * 
	 * @param soulShard
	 * @param start
	 * @param end
	 * @return -1 if not found, otherwise index of magic number
	 */
	public static int findMagic(int[] soulShard, int start, int end) {
		if(end-start == 1) {
			if (start == soulShard[start]) return start;
			else return -1;
		} 
		
		int range = end - start;
		
		int pivot = soulShard[start + range/2];
		
		if(start+range/2 == pivot) return pivot;
		else if(start+range/2 < pivot) {
			return findMagic(soulShard, start, start+range/2);
		} else {
			return findMagic(soulShard, start + range/2, end);
		}
	}
}
