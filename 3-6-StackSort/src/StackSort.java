
public class StackSort implements StackInt{
	public static void main(String[] args) {
		StackSort myStack = new StackSort();
		
		for(int i = 10; i>= 0; i--) {
			System.out.println("Pushing: " + i);
			myStack.push(i);
		}
		
		System.out.println("Peek pre-sort: " + myStack.peek());
		myStack.sort();
		System.out.println("Peek post-sort: " + myStack.peek());
		
		for(int i = 0; i<=10; i++) {
			System.out.println("POP: " + myStack.pop());
		}
	}
	
	
	private Stack orig;
	private Stack sorted;
	
	public StackSort() {
		orig = new Stack();
		sorted = new Stack();
	}
	
	public void push(int data) {
		orig.push(data);
	}

	@Override
	public int pop() {
		return orig.pop();
	}

	@Override
	public int peek() {
		return orig.peek();
	}

	@Override
	public boolean isEmpty() {
		return orig.isEmpty();
	}
	
	public void sort() {
		while(!orig.isEmpty()) {
			int check = orig.pop();
			
			while(!sorted.isEmpty()) {
				if(sorted.peek() < check) break;
				else orig.push(sorted.pop());
			}
			sorted.push(check);
		}
		
		orig = sorted;
		sorted = new Stack();
	}
}
