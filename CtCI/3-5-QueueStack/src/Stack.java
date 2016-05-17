
public class Stack {
	public Node head;
	
	public void push(int data) {
		Node toPush = new Node(data);
		if(head != null) {
			toPush.setNext(head);
			head = toPush;
		} else {
			head = toPush;
		}
	}
	
	public int pop() {
		int result = (int) Double.POSITIVE_INFINITY;
		if(head != null) {
			result = head.getData();
			head = head.getNext();
		}
		
		return result;
	}
	
	public int peek() {
		int result = (int) Double.POSITIVE_INFINITY;
		if(head != null) {
			result = head.getData();
		}
		return result;
	}
}
