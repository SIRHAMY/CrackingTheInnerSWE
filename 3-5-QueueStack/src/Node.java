
public class Node {
	private Node next;
	private int data;
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
	
	//Getters
	public int getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
	
	//Setters
	public void setData(int data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
}
