
public class Main {

	public static void main(String[] args) {
		MinStack s = new MinStack();
		
		s.push(9);
		s.push(12);
		s.push(15);
		s.push(6);
		s.push(8);
		s.push(3);
		
		System.out.println("Begin popping");
		System.out.println("Min: " + s.min());
		System.out.println("Pop: " + s.pop());
		
		System.out.println("Min: " + s.min());
		System.out.println("Pop: " + s.pop());
		
		System.out.println("Min: " + s.min());
		System.out.println("Pop: " + s.pop());
		
		System.out.println("Min: " + s.min());
		System.out.println("Pop: " + s.pop());
		
		System.out.println("Min: " + s.min());
		System.out.println("Pop: " + s.pop());
		
		System.out.println("Min: " + s.min());
		System.out.println("Pop: " + s.pop());
	}
}
