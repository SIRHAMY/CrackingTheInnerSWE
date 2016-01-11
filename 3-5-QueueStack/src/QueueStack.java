
public class QueueStack {
	Stack ingoing;
	Stack outgoing;
	
	public QueueStack() {
		ingoing = new Stack();
		outgoing = new Stack();
	}
	
	public void push(int data) {
		ingoing.push(data);
	}
	
	public int pop() {
		int result = (int) Double.POSITIVE_INFINITY;
		if(outgoing.peek() != (int) Double.POSITIVE_INFINITY) {
			result = outgoing.pop();
		} else {
			if(redistribute()) result = pop();
		}
		return result;
	}
	
	//Move ingoing stack to outgoing
	private boolean redistribute() {
		boolean result = false;
		while(ingoing.peek() != (int) Double.POSITIVE_INFINITY) {
			result = true;
			outgoing.push(ingoing.pop());
		}
		return result;
	}
	
	public int peek() {
		int result = (int) Double.POSITIVE_INFINITY;
		if(outgoing.peek() != (int) Double.POSITIVE_INFINITY) {
			result = outgoing.peek();
		} else {
			if(redistribute()) result = peek();
		}
		return result;
	}
}
