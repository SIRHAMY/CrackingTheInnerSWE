
public class BSTNode {
	private BSTNode parent;
	private BSTNode left;
	private BSTNode right;
	private int data;
	
	public BSTNode(int data) {
		this.data = data;
		parent = null;
		left = null;
		right = null;
	}
	
	public BSTNode(int data, BSTNode parent) {
		this.data = data;
		this.parent = parent;
	}
	
	//Getters
	public BSTNode getParent() {
		return parent;
	}
	
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
	public void setParent(BSTNode parent) {
		this.parent = parent;
	}
	
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
