
public class BSTNode {
	private int data;
	private BSTNode left;
	private BSTNode right;
	private BSTNode parent;
	
	public BSTNode(int data) {
		this.data = data;
		parent = null;
	}
	
	public BSTNode(int data, BSTNode parent) {
		this.data = data;
		this.parent = parent;
	}
	
	//Getters
	public int getData() {
		return data;
	}
	
	public BSTNode getLeft() {
		return left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
	public BSTNode getParent() {
		return parent;
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
