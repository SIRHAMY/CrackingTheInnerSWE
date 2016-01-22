
public class BSTChecker {
	public static void main(String[] args) {
		BSTChecker check = new BSTChecker();
		
		BSTNode a = new BSTNode(6);
		BSTNode a1 = new BSTNode(4);
		BSTNode a2 = new BSTNode(8);
		BSTNode a3 = new BSTNode(2);
		BSTNode a4 = new BSTNode(5);
		BSTNode a5 = new BSTNode(7);
		BSTNode a6 = new BSTNode(9);
		
		a.setLeft(a1);
		a.setRight(a2);
		a1.setLeft(a3);
		a1.setRight(a4);
		a2.setLeft(a5);
		a2.setRight(a6);
		
		System.out.println("Check a: " + check.bstCheck(a));
		
		BSTNode b = new BSTNode(6);
		BSTNode b1 = new BSTNode(3);
		BSTNode b2 = new BSTNode(7);
		BSTNode b3 = new BSTNode(3);
		BSTNode b4 = new BSTNode(9);
		
		b.setLeft(b1);
		b.setRight(b2);
		b1.setRight(b3);
		b2.setRight(b4);
		
		System.out.println("Check b: " + check.bstCheck(b));
		
		BSTNode c = new BSTNode(6);
		BSTNode c1 = new BSTNode(3);
		BSTNode c2 = new BSTNode(8);
		BSTNode c3 = new BSTNode(4);
		BSTNode c4 = new BSTNode(5);
		BSTNode c5 = new BSTNode(9);
		
		c.setLeft(c1);
		c.setRight(c2);
		c1.setLeft(c3);
		c1.setRight(c4);
		c2.setRight(c5);
		
		System.out.println("Check c: " + check.bstCheck(c));
		
	}

	public boolean bstCheck(BSTNode root) {
		//Check if left exists and less than root
		if( root.getLeft() != null && root.getLeft().getData() >= root.getData() ) return false;
		
		//Check if right exists and more than root
		if( root.getRight() != null && root.getRight().getData() <= root.getData()) return false;
		
		boolean left = true;
		if(root.getLeft() != null) left = bstCheck(root.getLeft());
		
		boolean right = true;
		if(root.getRight() != null) right = bstCheck(root.getRight());
		
		return left && right;
		
	}
}
