
public class Main {
	
	public static void printList(Node head) {
		if(head == null) {
			System.out.println("Err: Head was null");
			return;
		}
		
		Node curr = head;
		System.out.println(curr.value);
		
		while(curr.next != null) {
			curr = curr.next;
			System.out.println(curr.value);
		}
	}
	
	public static Node sumList (Node head1, Node head2) {
		if(head1 == null && head2 == null) return null;
		else if(head1 == null) return head2;
		else if(head2 == null) return head1;
		
		//Find value of first number
		Node curr1 = head1;
		int val1 = 0;
		int placeHolder1 = 0;
		
		val1 += curr1.value;
		
		while(curr1.next != null) {
			curr1 = curr1.next;
			placeHolder1++;
			
			val1 += curr1.value * Math.pow(10, placeHolder1);
		}
		
		//Find value of second number
		Node curr2 = head2;
		int val2 = 0;
		int placeHolder2 = 0;
		
		val2 += curr2.value;
		
		while(curr2.next != null) {
			curr2 = curr2.next;
			placeHolder2++;
			
			val2 += curr2.value * Math.pow(10, placeHolder2);
		}
		
		//Find the sum of the two numbers
		int result = val1 + val2;
		System.out.println("Debug: result = " + result);
		
		//Encode result in new linked list
		int encode = result % 10;
		Node rHead = new Node(encode);
		Node rPtr = rHead;
		int encoded = encode;
		
		int modPlaceHolder = 2;
		while(encoded != result) {
			encode = (int) (result % Math.pow(10, modPlaceHolder)) - encoded;
			rPtr.next = new Node((int) (encode / Math.pow(10, modPlaceHolder - 1)) );
			
			rPtr = rPtr.next;
			encoded += encode;
			modPlaceHolder++;			
		}
		
		return rHead;
	}
	
	public static Node sumListCorrect(Node head1, Node head2) {
		if(head1 == null && head2 == null) return null;
		else if(head1 == null) return head2;
		else if(head2 == null) return head1;
		
		Node result = new Node(0);
		Node resultPtr = result;
		
		Node listOnePtr = head1;
		Node listTwoPtr = head2;
		int carry = 0;
		
		while(listOnePtr != null || listTwoPtr != null || carry != 0) {
			Node toAdd;
			int encode = carry;
			
			if(listOnePtr == null) {
				encode += listTwoPtr.value;
			} else if(listTwoPtr == null) {
				encode += listOnePtr.value;
			} else {
				encode = listOnePtr.value + listTwoPtr.value;
			}
			
			if(encode > 9) {
				carry = 1;
				encode -= 9;
			} else {
				carry = 0;
			}
			
			toAdd = new Node(encode);
			resultPtr.next = toAdd;
			resultPtr = resultPtr.next;
			
			if(listOnePtr.next != null) listOnePtr = listOnePtr.next;
			else listOnePtr = null;
			if(listTwoPtr.next != null) listTwoPtr = listTwoPtr.next;
			else listTwoPtr = null;
		}
		
		return result.next;
		
	}
	
	public static int listLength(Node head) {
		if(head == null) return 0;
		Node curr = head;
		int count = 1;
		
		while(curr.next != null) {
			curr = curr.next;
			count++;
		}
		
		return count;
	}
	
	public static Node sumListForward(Node head1, Node head2) {
		if(head1 == null && head2 == null) return null;
		else if(head1 == null) return head2;
		else if(head2 == null) return head1;
		
		//Determine value of first list
		int placeHolder1 = listLength(head1) - 1;
		Node curr1 = head1;
		
		int val1 = (int) (curr1.value * Math.pow(10, placeHolder1));
		placeHolder1--;
		
		while(curr1.next != null) {
			curr1 = curr1.next;
			val1 += curr1.value * Math.pow(10, placeHolder1);
			placeHolder1--;
		}
		
		//Determine value of second list
		int placeHolder2 = listLength(head2) - 1;
		Node curr2 = head2;
		
		int val2 = (int) (curr2.value * Math.pow(10, placeHolder2));
		placeHolder2--;
		
		while(curr2.next != null) {
			curr2 = curr2.next;
			val2 += curr2.value * Math.pow(10, placeHolder2);
			placeHolder2--;
		}
		
		//Add both values together
		int total = val1 + val2;
		System.out.println("Debug: total = " + total);
		
		//Encode answer into new linked list
		int resultPlaceHolder = Math.max(listLength(head1), listLength(head2));
		
		System.out.println("Debug: resulPlaceHolder = "  + resultPlaceHolder);
		System.out.println("Debug: total mod = " + total % Math.pow(10,  resultPlaceHolder));
		if(total % Math.pow(10, resultPlaceHolder) != total) resultPlaceHolder += 1;
		
		int encode = (int) ( (total % Math.pow(10,  resultPlaceHolder) ) - (total % Math.pow(10, resultPlaceHolder - 1) ) );
		System.out.println("Debug: encode = " + encode);
		
		Node rHead = new Node(encode);
		resultPlaceHolder -= 1;
		Node rCurr = rHead;
		
		while(resultPlaceHolder > 1) {
			encode = (int) ( ( (total % Math.pow(10,  resultPlaceHolder) ) - (total % Math.pow(10, resultPlaceHolder - 1) ) ) 
					/ Math.pow(10, resultPlaceHolder) );
			
			rCurr.next = new Node(encode);
			rCurr = rCurr.next;
			resultPlaceHolder -= 1;
		}
		
		encode = total % 10;
		rCurr.next = new Node(encode);
		
		return rHead;
	}
	
	public static Node sumListCorrectForward(Node head1, Node head2) {
		int length1 = listLength(head1);
		int length2 = listLength(head2);
		
		Node runner1 = head1;
		Node runner2 = head2;
		
		if(length1 < length2) {
			while(length1 < length2) {
				Node filler = new Node(0);
				filler.next = runner1;
				runner1 = filler;
				length1++;
			}
		} else if(length2 < length1) {
			while(length2 < length1) {
				Node filler = new Node(0);
				filler.next = runner2;
				runner2 = filler;
				length2++;
			}
		}
		
		Node resultHead = new Node(-1);
		Node resultRunner = resultHead;
		
		//Both lists same length, so only have to check one
		while(runner1 != null) {
			resultRunner.next = new Node(runner1.value + runner2.value);
			resultRunner = resultRunner.next;
			
			if(runner1.next != null) runner1 = runner1.next;
			else runner1 = null;
			if(runner2.next != null) runner2 = runner2.next;
			else runner2 = null;
		}
		
		if(sumHelper(resultHead.next) == 0) return resultHead.next;
		else {
			resultHead.value = 1;
			return resultHead;
		}
	}
	
	public static int sumHelper(Node currNode) {
		if(currNode.next != null) currNode.value += sumHelper(currNode.next);
		
		if(currNode.value > 9) {
			currNode.value -= 9;
			return 1;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Node a1 = new Node(3);
		Node a2 = new Node(4);
		Node a3 = new Node(3);
		
		a1.next = a2;
		a2.next = a3;
		
		Node b1 = new Node(0);
		Node b2 = new Node(2);
		Node b3 = new Node(4);
		
		b1.next = b2;
		b2.next = b3;
		
		System.out.println("Linked List A");
		printList(a1);
		
		System.out.println("Linked List B");
		printList(b1);
		
		System.out.println("Result list");
		printList(sumList(a1, b1));
		
		//System.out.println("Forward Result List");
		//printList(sumListForward(a1,b1));
		
		System.out.println("Efficient sumList");
		printList(sumListCorrect(a1, b1));
		
		System.out.println("Efficient sumListForward");
		printList(sumListCorrectForward(a1, b1));
	}
}
