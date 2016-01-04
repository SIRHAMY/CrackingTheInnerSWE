
public class MinStack {

	private Stack mainStack;
	private Stack minStack;
	
	public MinStack() {
		mainStack = new Stack();
		minStack = new Stack();
	}
	
	public void push(int data) {
		mainStack.push(data);
		if(data <= minStack.peek()) minStack.push(data);
	}
	
	public int pop() {
		int removed = mainStack.pop();
		
		if(removed == minStack.peek()) minStack.pop();
		
		return removed;
	}
	
	public int min() {
		return minStack.peek();
	}
}
