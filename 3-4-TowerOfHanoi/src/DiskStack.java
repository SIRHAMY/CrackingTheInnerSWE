
public class DiskStack implements Stack{
	private DiskNode head;
	
	@Override
	public void push(Object toPush) {
		// TODO Auto-generated method stub
		DiskNode pushMe = new DiskNode((Disk) toPush);
		if(head != null) {
			pushMe.setNext(head);
			head = pushMe;
		} else {
			head = pushMe;
		}
	}

	@Override
	public Disk pop() {
		// TODO Auto-generated method stub
		if(head != null) {
			Disk toReturn = head.getData();
			head = head.getNext();
			return toReturn;
		}
		
		return null;
	}

	@Override
	public Disk peek() {
		// TODO Auto-generated method stub
		if(head != null) {
			return head.getData();
		}
		return null;
	}
	
	@Override
	public String toString() {
		
		DiskNode curr = head;
		StringBuffer result = new StringBuffer();
		
		while(curr != null) {
			result.append(curr.getData().toString() + " ");
			curr = curr.getNext();
		}
		
		return result.toString();
	}

}
