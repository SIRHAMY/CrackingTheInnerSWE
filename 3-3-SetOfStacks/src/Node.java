
public class Node {
	private Node next;
	private int data;
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
	
	//Setters
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	//Getters
	public Node getNext() {
		return next;
	}
	
	public int getData() {
		return data;
	}
}
