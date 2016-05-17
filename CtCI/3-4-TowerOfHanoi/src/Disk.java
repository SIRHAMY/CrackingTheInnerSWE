
public class Disk {
	private int data;
	
	public Disk(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data + "";
	}
}
