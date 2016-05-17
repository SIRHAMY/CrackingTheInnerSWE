
public class Finder {
	public static void main(String[] args) {
		Finder find = new Finder();
		
		BSTNode a = new BSTNode(6);
		BSTNode b = new BSTNode(4, a);
		BSTNode c = new BSTNode(2, b);
		
		a.setLeft(b);
		b.setLeft(c);
		
		System.out.println("Test 1: Find successor of b");
		System.out.println("Test 1: successor = " + find.findSuccessor(b));
		
		BSTNode d = new BSTNode(8, a);
		BSTNode e = new BSTNode(5, b);
		
		a.setRight(d);
		b.setRight(e);
		
		System.out.println("Test 2: Find successor of b");
		System.out.println("Test 2: successor = " + find.findSuccessor(b));
	}

	public int findSuccessor(BSTNode root) {
		if(root.getRight() != null) return findSuccessorHelper(root.getRight());
		else return root.getParent().getData();
	}
	
	//Iterates right to find left node
	public int findSuccessorHelper(BSTNode root) {
		if(root.getLeft() == null) return root.getData();
		return findSuccessorHelper(root.getLeft());
	}
}
