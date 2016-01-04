import java.util.Random;

public class Main {
	
	public class Node {
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
		public void printData() {
			System.out.println(data);
		}
	}
	
	public static Node listPartition(Node head, int x) {
		Node less = null;
		Node lessPtr = null;
		Node more = null;
		Node morePtr = null;
		
		Node curr = head;
		
		if(curr.data < x) {
			less = curr;
			lessPtr = less;
		} else {
			more = curr;
			morePtr = more;
		}
		
		//Partition
		while(curr.next != null) {
			curr = curr.next;
			
			if(curr.data < x) {
				if(less != null) {
					lessPtr.next = curr;
					lessPtr = lessPtr.next;
				} else {
					less = curr;
					lessPtr = less;
				}
			} else {
				if(more != null) {
					morePtr.next = curr;
					morePtr = morePtr.next;
				} else {
					more = curr;
					morePtr = more;
				}
			}
		}
		
		//Merge
		if(less != null && more != null) {
			lessPtr.next = more;
			morePtr.next = null;
			return less;
		} else if(less != null) {
			lessPtr.next = null;
			return less;
		} else if (more != null) {
			morePtr.next = null;
			return more;
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		Main stuff = new Main();
		Random rand = new Random();
		
		Node A = stuff.new Node(rand.nextInt(10));
		Node B = stuff.new Node(rand.nextInt(10));
		Node C = stuff.new Node(rand.nextInt(10));
		Node D = stuff.new Node(rand.nextInt(10));
		Node E = stuff.new Node(rand.nextInt(10));
		
		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;
		
		Node curr = A;
		curr.printData();
		while(curr.next != null) {
			curr = curr.next;
			curr.printData();
		}
		
		System.out.println("New partition");
		Node head = listPartition(A, 5);
		
		curr = head;
		curr.printData();
		while(curr.next != null) {
			curr = curr.next;
			curr.printData();
		}
		
	}
}
