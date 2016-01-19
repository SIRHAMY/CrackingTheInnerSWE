
public class BSTNode {
	private BSTNode right;
	private BSTNode left;
	
	private int data;
	
	public BSTNode(int data) {
		this.data = data;
	}
	
	//Getters
	public int getData() {
		return data;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
	public BSTNode getLeft() {
		return left;
	}
	
	//Setters
	public void setData(int data) {
		this.data = data;
	}
	
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	
	public void setRight(BSTNode right) {
		this.right = right;
	}
}
