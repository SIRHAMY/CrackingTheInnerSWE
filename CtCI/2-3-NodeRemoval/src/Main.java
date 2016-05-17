
public class Main {
	
	public class Node {
		public String data;
		public Node next;
		
		public Node(String data) {
			this.data = data;
		}
	}
	
	public static void removeNode(Node rem) {
		if(rem.next != null) {
			rem.data = rem.next.data;
			rem.next = rem.next.next;
		}
		else rem = null;
	}
	
	public static void printList(Node head) {
		if(head != null) {
			Node curr = head;
			System.out.println(curr.data);
			
			while(curr.next != null) {
				curr = curr.next;
				System.out.println(curr.data);
			}
		}
	}
	
	public static void main(String[] args) {
		Main stuff = new Main();
		
		Node A = stuff.new Node("A");
		Node B = stuff.new Node("B");
		Node C = stuff.new Node("C");
		Node D = stuff.new Node("D");
		Node E = stuff.new Node("E");
		
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		
		printList(A);
		removeNode(C);
		printList(A);
		removeNode(C); //This removes "D" as C was never actually deleted
		printList(A);
		
	}
}
