
public class BST {
	public static void main(String[] args) {
		BST bst = new BST();
		
		BSTNode a = new BSTNode(2);
		BSTNode b = new BSTNode(1);
		BSTNode c = new BSTNode(3);
		
		a.setLeft(b);
		a.setRight(c);
		
		System.out.println("Test of inordertraversal: ");
		bst.inorderTraversal(a);
		
		System.out.println("Begin arrayToBST test");
		int[] data = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		BSTNode head = bst.arrayToBST(data);
		bst.inorderTraversal(head);
	}

	public BSTNode arrayToBST(int[] a) {
		int rootIndex = a.length / 2;
		
		BSTNode head = new BSTNode(a[rootIndex]);
		
		//System.out.println("Debug: Entering initial setLeft");
		
		head.setLeft(buildTree(0, rootIndex, a));
		
		//System.out.println("Debug: Entering initial setRight");
		
		head.setRight(buildTree(rootIndex + 1, a.length, a));
		
		return head;		
	}
	
	public BSTNode buildTree(int start, int end, int[] data) {
		BSTNode head = null;
		
		//System.out.println("Debug: Start: " + start + " End: " + end);
		
		if(end - start == 1) head = new BSTNode(data[start]); 
		if(end - start > 1) {
			int rootIndex = (end - start) / 2 + start;
			
			head = new BSTNode(data[rootIndex]);
			head.setLeft(buildTree(start, rootIndex, data));
			head.setRight(buildTree(rootIndex + 1, end, data));
		}
		
		return head;
	}
	
	//public BSTNode buildLeft(int start, int end, int[] data) {
		
	//}
	
	public void inorderTraversal(BSTNode head) {
		if(head.getLeft() != null) inorderTraversal(head.getLeft());
		System.out.println(head.getData());
		if(head.getRight() != null) inorderTraversal(head.getRight());
	}
}
