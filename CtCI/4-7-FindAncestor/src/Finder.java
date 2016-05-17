
public class Finder {
	
	public static void main(String[] args) {
		Finder find = new Finder();
		
		BSTNode a = new BSTNode(1);
		BSTNode b = new BSTNode(2,a);
		BSTNode c = new BSTNode(3, a);
		BSTNode d = new BSTNode(4, b);
		BSTNode e = new BSTNode(5, b);
		BSTNode f = new BSTNode(6, c);
		BSTNode g = new BSTNode(7, c);
		
		a.setLeft(b);
		a.setRight(c);
		
		b.setLeft(d);
		b.setRight(e);
		
		c.setLeft(f);
		c.setRight(g);
		
		System.out.println("D and E - Expected B: 2");
		System.out.println(find.findAncestor(d, e).getData());
		System.out.println(find.findAncestorNoParent(a, d, e).getData());
		
		System.out.println("D and F - Expected A: 1");
		System.out.println(find.findAncestor(d, f).getData());
		System.out.println(find.findAncestorNoParent(a, d, f).getData());
		
		System.out.println("B and A - Expected A: 1");
		System.out.println(find.findAncestor(b, a).getData());
		System.out.println(find.findAncestorNoParent(a, b, a).getData());
		
		System.out.println("A and C - Expected A: 1");
		System.out.println(find.findAncestor(a, c).getData());
		System.out.println(find.findAncestorNoParent(a, a, c).getData());
	}
	
	public BSTNode findAncestor(BSTNode a, BSTNode b) {
		//A is the common ancestor
		if(searchChildren(a, b)) return a;
		
		return searchParent(a, b, null);
	}
	
	//Search Node's children to figure out if we're starting at the ancestor
	public boolean searchChildren(BSTNode root, BSTNode target) {
		if(root == target) return true;
		
		if(root.getLeft() != null) {
			if(searchChildren(root.getLeft(), target)) return true;
		}
		
		if(root.getRight() != null) {
			if(searchChildren(root.getRight(), target)) return true;
		}
		
		return false;
	}
	
	public BSTNode searchParent(BSTNode root, BSTNode target, BSTNode from) {
		if(root == target) return root;
		
		if(root.getLeft() != null && root.getLeft() != from) {
			if(searchChildren(root.getLeft(), target)) return root;
		} else if( root.getRight() != null && root.getRight() != from) {
			if(searchChildren(root.getRight(), target)) return root;
		}
		
		if(root.getParent() != null) return searchParent(root.getParent(), target, root);
		
		return null;
	}
	
	public BSTNode findAncestorNoParent(BSTNode root, BSTNode a, BSTNode b) {
		return findAncestorHelperNoParent(root, a, b);
	}
	
	public BSTNode findAncestorHelperNoParent(BSTNode root, BSTNode a, BSTNode b) {
		if(root == a) return root;
		if(root == b) return root;
		
		BSTNode left = null;
		if(root.getLeft() != null) left = findAncestorHelperNoParent(root.getLeft(), a, b);
		
		BSTNode right = null;
		if(root.getRight() != null) right = findAncestorHelperNoParent(root.getRight(), a, b);
		
		if(left != null && right != null) {
			if( ( left == a && right == b ) || ( left == b && right == a ) ) {
				return root;
			} else if ( left != a && left != b) return left;
			else if ( right != a && right != b) return right;
		} else if(left != null) {
			return left;
		} else if(right != null) {
			return right;
		} 
		
		return null;
		
	}
}
