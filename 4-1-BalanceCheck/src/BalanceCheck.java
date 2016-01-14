
public class BalanceCheck {
	public static void main(String[] args) {
		BalanceCheck check = new BalanceCheck();
		
		Node balance = new Node();
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		Node e = new Node();
		Node f = new Node();
		
		balance.setLeft(a);
		balance.setRight(b);
		
		a.setLeft(c);
		a.setRight(d);
		
		b.setLeft(e);
		b.setRight(f);
		
		System.out.println("balance balanced? " + check.isBalanced(balance));
		
		Node unbalance = new Node();
		
		unbalance.setLeft(a);
		
		System.out.println("unbalance balanced? " + check.isBalanced(unbalance));
	}

	public boolean isBalanced(Node root) {
		
		if(checkBalance(root) != -1) return true;
		return false;
	}
	
	public int checkBalance(Node root) {
		if(root == null) return 0;
		
		if(root.getRight() == null && root.getLeft() == null) return 1;
		
		int leftHeight = 0;
		int rightHeight = 0;
		
		if(root.getLeft() != null) leftHeight = checkBalance(root.getLeft());
		if(root.getRight() != null) rightHeight = checkBalance(root.getRight());
		
		if(leftHeight == -1 || rightHeight == -1) return -1;
		else if(Math.abs(leftHeight - rightHeight) > 1) return -1;
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
