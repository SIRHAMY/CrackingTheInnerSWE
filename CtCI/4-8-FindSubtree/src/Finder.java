
public class Finder {
	public static void main(String[] args) {
		Finder find = new Finder();
		
		BSTNode a = new BSTNode(1);
		BSTNode b = new BSTNode(2);
		BSTNode c = new BSTNode(3);
		BSTNode d = new BSTNode(4);
		BSTNode e = new BSTNode(5);
		BSTNode f = new BSTNode(6);
		BSTNode g = new BSTNode(7);
		
		BSTNode h = new BSTNode(3);
		BSTNode i = new BSTNode(6);
		BSTNode j = new BSTNode(7);
		
		BSTNode k = new BSTNode(2);
		BSTNode l = new BSTNode(4);
		BSTNode m = new BSTNode(7);
		
		a.setLeft(b);
		a.setRight(c);
		b.setLeft(d);
		b.setRight(e);
		c.setLeft(f);
		c.setRight(g);
		
		h.setLeft(i);
		h.setRight(j);
		
		k.setLeft(l);
		k.setRight(m);
		
		System.out.println("Is h a subtree of a? Expected: true");
		System.out.println(find.isSubtree(a,h));
		
		System.out.println("Is k a subtree of a? Expected: false");
		System.out.println(find.isSubtree(k,h));
		
		System.out.println("Is a a subtree of k? Expected: false");
		System.out.println(find.isSubtree(k,a));
	}
	
	//Is b a subtree of a?
	public boolean isSubtree(BSTNode a, BSTNode b) {
		if(a.getData() == b.getData()) {
			if(checkSubtree(a, b)) return true;
		}
		
		if(a.getLeft() != null) {
			if(isSubtree(a.getLeft(), b)) return true; 
		}
		
		if(a.getRight() != null) {
			if(isSubtree(a.getRight(), b)) return true;
		}
		
		return false;
	}
	
	//Check if a == b
	public boolean checkSubtree(BSTNode a, BSTNode b) {
		if(a.getData() != b.getData()) return false;
		
		if(a.getLeft() != null && b.getLeft() != null) {
			return checkSubtree(a.getLeft(), b.getLeft());
		//Check if they aren't both equal to null
		} else if (a.getLeft() != null || b.getLeft() != null) {
			return false;
		}
		
		if(a.getRight() != null && b.getRight() != null) {
			return checkSubtree(a.getRight(), b.getRight());
		//Check if they aren't both equal to null
		} else if (a.getRight() != null || b.getRight() != null) {
			return false;
		}
		
		return true;
	}

}
