
public class Stack {
	Node head;
	
	//Push data onto the stack
	public void push(int data) {
		if(head != null) {
			Node toPush = new Node(data);
			toPush.setNext(head);
			head = toPush;
		} else {
			Node toPush = new Node(data);
			head = toPush;
		}
	}
	
	//Remove top node and return its data
	public int pop() {
		if(head != null) {
			int result = head.getData();
			head = head.getNext();
			return result;
		}
		return (int) Double.POSITIVE_INFINITY;
	}
	
	//Look at top node contents, but leave node alone
	public int peek() {
		if(head != null) {
			return head.getData();
		}
		return (int) Double.POSITIVE_INFINITY;
	}
}
