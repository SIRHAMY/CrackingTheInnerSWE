
public class Test {
	public static void main(String[] args) {
		System.out.println("Testing initiated...");
		
		SinglyLinkedList ll = new SinglyLinkedList();
		
		for(int i = 0; i<10; i++) {
			ll.add(i);
		}
		
		ll.printList();
		
		System.out.println("Reversal");
		
		Reverser r = new Reverser();
		ll.setHead( r.reverseSLL(ll.getHead()) );
		
		ll.printList();
	}
}
