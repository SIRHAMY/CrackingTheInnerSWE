import java.util.List;

public class BSTLL {
	private BSTLLNode head;
	
	public void add(BSTNode toAdd) {
		BSTLLNode toPush = new BSTLLNode(toAdd);
		if(head != null) {
			toPush.setNext(head);
			head = toPush;
		} else {
			head = toPush;
		}
	}
	
	public void printContents() {
		if(head != null) {
			BSTLLNode curr = head;
			
			while(curr != null) {
				System.out.println("Data: " + curr.getData().getData());
				curr = curr.getNext();
			}
		} else {
			System.out.println("List empty");
		}
	}
	
}
