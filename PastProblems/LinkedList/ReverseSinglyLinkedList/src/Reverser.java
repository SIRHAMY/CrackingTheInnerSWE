
public class Reverser {

	public Node reverseSLL(Node head) {
		//To reverse:
		//A -> B -> C
		//A <- B <- C
		//Save B's pointer to C
		//Set B's pointer to A/where we came from
		//Save pointer to B
		
		Node prev = null;
		Node next = null;
		Node curr = head;
		
		while(curr != null) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			
			curr = next;
		}
		
		return prev;
	}
}
