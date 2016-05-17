
public class Stack implements StackInt{
	private Node head;
	private final double nullValue = Double.NEGATIVE_INFINITY;
	
	public void push(int data) {
		Node toPush = new Node(data);
		if( head != null ) {
			toPush.setNext(head);
			head = toPush;
		} else {
			head = toPush;
		}
	}
	
	public int pop() {
		int result = (int) nullValue;
		if(head != null) {
			result = head.getData();
			head = head.getNext();
		}
		return result;
	}
	
	public int peek() {
		int result = (int) nullValue;
		if( head != null ) {
			result = head.getData();
		}
		return result;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
}
