
public class DiskNode implements Node{
	private DiskNode next;
	private Disk data;
	
	public DiskNode(Disk data) {
		this.data = data;
	}

	@Override
	public void setNext(Object next) {
		// TODO Auto-generated method stub
		this.next = (DiskNode) next;
		
	}

	@Override
	public void setData(Object data) {
		// TODO Auto-generated method stub
		this.data = (Disk) data;
		
	}

	@Override
	public DiskNode getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public Disk getData() {
		// TODO Auto-generated method stub
		return data;
	}

}
