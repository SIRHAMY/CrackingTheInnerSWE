
public class BSTLLNode {
	private BSTNode data;
	private BSTLLNode next;
	
	public BSTLLNode(BSTNode data) {
		this.data = data;
	}
	
	//Getters
	public BSTNode getData() {
		return data;
	}
	
	public BSTLLNode getNext() {
		return next;
	}
	
	//Setters
	public void setData(BSTNode data) {
		this.data = data;
	}
	
	public void setNext(BSTLLNode next) {
		this.next = next;
	}
}
