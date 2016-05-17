
public class Stack {
	private Node head;
	private Stack next;
	private int size;
	
	public Stack() {
		head = null;
		next = null;
		size = 0;
	}
	
	public Stack(Node head) {
		this.head = head;
		next = null;
		size = 1;
	}
	
	public void push(int data) {
		Node toPush = new Node(data);
		if(head != null) {
			toPush.setNext(head);
			head = toPush;
		} else {
			head = toPush;
		}
		size++;
	}
	
	public int pop() {
		if(head != null) {
			int toReturn = head.getData();
			head = head.getNext();
			size--;
			return toReturn;
		} 
		return (int) Double.POSITIVE_INFINITY;
	}
	
	public int peek() {
		if(head != null) {
			return head.getData();
		}
		return (int) Double.POSITIVE_INFINITY;
	}
	
	//Setters
	public void setNext(Stack next) {
		this.next = next;
	}
	
	//Getters
	public Stack getNext() {
		return next;
	}
	
	public int getSize() {
		return size;
	}
}
