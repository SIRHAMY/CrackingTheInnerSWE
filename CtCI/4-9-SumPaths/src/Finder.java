import java.util.ArrayList;

public class Finder {
	public static void main(String[] args) {
		Finder find = new Finder();
		
		BSTNode a = new BSTNode(3);
		BSTNode b = new BSTNode(4);
		BSTNode c = new BSTNode(5);
		BSTNode d = new BSTNode(6);
		BSTNode e = new BSTNode(2);
		BSTNode f = new BSTNode(2);
		BSTNode g = new BSTNode(7);
		BSTNode h = new BSTNode(3);
		BSTNode i = new BSTNode(1);
		BSTNode j = new BSTNode(1);
		BSTNode k = new BSTNode(1);
		BSTNode l = new BSTNode(2);
		BSTNode m = new BSTNode(2);
		BSTNode n = new BSTNode(8);
		
		a.setLeft(b);
		a.setRight(c);;
		
		b.setLeft(d);
		b.setRight(e);
		
		c.setLeft(f);
		c.setRight(g);
		
		d.setLeft(h);
		d.setRight(i);
		
		e.setLeft(j);
		
		f.setLeft(k);
		f.setRight(l);
		
		g.setLeft(m);
		g.setRight(n);
		
		System.out.println("Test 7");
		find.findValuedPath(a, 7);
		
		System.out.println("Test 9");
		find.findValuedPath(a, 9);
	}

	public void findValuedPath(BSTNode root, int target) {
		ArrayList<BSTNode> path = new ArrayList<BSTNode>();
		
		findValuedPathHelper(root, target, 0, path);
		
		//System.out.println("Debug: root = " + root.getData());
		
		if(root.getLeft() != null) {
			//System.out.println("Debug: leftChild = " + root.getLeft().getData());
			findValuedPath(root.getLeft(), target);
		}
		
		if(root.getRight() != null) {
			//System.out.println("Debug: rightChild = " + root.getRight().getData());
			findValuedPath(root.getRight(), target);
		}
	}
	
	private void findValuedPathHelper(BSTNode root, int target, int pathValue, ArrayList<BSTNode> path){
		int nPathValue = root.getData() + pathValue;
		
		ArrayList subPath = (ArrayList) path.clone();
		subPath.add(root);
	
		if(nPathValue == target) {
			printArrayList(subPath);

		}
			
		if(root.getLeft() != null) findValuedPathHelper(root.getLeft(), target, nPathValue, subPath);
		if(root.getRight() != null) findValuedPathHelper(root.getRight(), target, nPathValue, subPath);
	}
	
	private void printArrayList(ArrayList<BSTNode> path) {
		System.out.println("Printing ArrayList");
		for(BSTNode node: path) {
			System.out.println(node.getData());
		}
	}
}
