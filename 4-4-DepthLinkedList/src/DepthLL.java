import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DepthLL {
	public static void main(String[] args) {
		DepthLL depth = new DepthLL();
		
		BSTNode a = new BSTNode(0);
		BSTNode b = new BSTNode(1);
		BSTNode c = new BSTNode(1);
		BSTNode d = new BSTNode(2);
		BSTNode e = new BSTNode(2);
		BSTNode f = new BSTNode(3);
		
		a.setLeft(b);
		a.setRight(c);
		
		b.setLeft(d);
		b.setRight(e);
		
		e.setLeft(f);
		
		ArrayList<BSTLL> check = (ArrayList<BSTLL>) depth.depthToLL(a);
		
		Iterator<BSTLL> it = check.iterator();
		
		while(it.hasNext()) {
			System.out.println("At new depth");
			it.next().printContents();
		}
		
	}
	

	public List<BSTLL> depthToLL(BSTNode root) {
		ArrayList<BSTLL> result = new ArrayList();
		
		encodeLL(root, 0, result);
		
		return result;
	}
	
	//Have to work from top up so that depth uniform
	public void encodeLL(BSTNode root, int depth, ArrayList<BSTLL> result) {
		pushToDepth(root, depth, result);
		
		if(root.getLeft() != null) encodeLL(root.getLeft(), depth + 1, result);
		if(root.getRight() != null) encodeLL(root.getRight(), depth + 1, result);
	}
	
	public void pushToDepth(BSTNode root, int depth, ArrayList<BSTLL> result) {
		if(result.size() <= depth) {
			//System.out.println("Debug: setting arraylist");
			
			result.add(depth, new BSTLL());
			
			//System.out.println("Debug: result" + result.toString());
		} 
		
		result.get(depth).add(root);
	}
	
	
}
