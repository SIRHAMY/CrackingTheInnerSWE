
public class SinglyLinkedList {
	private Node head;
	
	public void add(Node toAdd) {
		if(head == null) {
			head = toAdd;
		} else {
			//Find the last element in the LL
			//Set its next to toAdd
			Node llIterator = head;
			while(llIterator.getNext() != null) {
				llIterator = llIterator.getNext();
			}
			llIterator.setNext(toAdd);
		}
	}
	
	public void add(int toAdd) {
		if(head == null) {
			head = new Node(toAdd);
		} else {
			//Find the last element in the LL
			//Set its next to toAdd
			Node llIterator = head;
			while(llIterator.getNext() != null) {
				llIterator = llIterator.getNext();
			}
			llIterator.setNext(new Node(toAdd));
		}
	}
	
	//Iterate through LL til index
	//If long enough, remove that element
	public Node removeByIndex(int index) {
		//Check if head == null
		//Check if index == null
		if(head == null) {
			return null;
		} else if (index == 0) {
			head = head.getNext();
		} else {
			
			//Iterate to index - 1 for removal
			Node llIterator = head;
			int iteratorIndex = 0;
			while(llIterator.getNext() != null && iteratorIndex < index - 1) {
				llIterator = llIterator.getNext();
				iteratorIndex++;
			}
			
			//Check if in correct position for removal
			if(iteratorIndex == index - 1) {
				
				//To remove:
				// A -> B -> C
				// A -> C
				Node removed = llIterator.getNext();
				llIterator.setNext(llIterator.getNext().getNext());
				return removed;
			}
		}
		
		return null;
	}
	
	//**Helpers**
	
	public void printList() {
		if(head != null) {
			System.out.println("Singly Linked List not empty: Printing list...");
			
			//Iterate through singly linked list
			//Print data of each node
			Node llIterator = head;
			while(llIterator != null) {
				System.out.println("Node data: " + llIterator.getData());
				llIterator = llIterator.getNext();
			}
		} else {
			System.out.println("Singly Linked List is empty.");
		}
	}
	
	//**Getters**
	
	public Node getHead() {
		return head;
	}
	
	//**Setters**
	public void setHead(Node head) {
		this.head = head;
	}
}
