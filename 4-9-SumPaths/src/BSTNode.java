
public class BSTNode {
	private BSTNode left;
	private BSTNode right;
	private int data;
	
	public BSTNode(int data) {
		this.data = data;
	}
	
	//Getters
	public BSTNode getLeft() {
		return left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
	public int getData() {
		return data;
	}
	
	//Setters
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	
	public void setRight(BSTNode right) {
		this.right = right;
	}
	
	public void setData(int data) {
		this.data = data;
	}
}
