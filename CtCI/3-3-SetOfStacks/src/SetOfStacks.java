
public class SetOfStacks {
	private Stack headStack;
	private final int MAXSIZE;
	
	public SetOfStacks() {
		MAXSIZE = 5;
	}
	
	public void push(int data) {
		if(headStack == null) headStack = new Stack();
		
		if(headStack.getSize() < MAXSIZE) {
			headStack.push(data);
		} else {
			Stack newStack = new Stack();
			newStack.setNext(headStack);
			newStack.push(data);
			headStack = newStack;
		}
	}
	
	public int pop() {
		if(headStack != null) {
			if(headStack.getSize() > 1) {
				return headStack.pop();
			} else if(headStack.getSize() == 1) {
				int toReturn = headStack.pop();
				headStack = headStack.getNext();
				return toReturn;
			} else {
				if(headStack.getNext() != null) {
					headStack = headStack.getNext();
					return headStack.pop();
				} else {
					headStack = null;
				}
			}
		} 
		return (int) Double.POSITIVE_INFINITY;
	}
	
	public int popAt(int index) {
		int counter = 0;
		Stack curr = headStack;
		
		while(curr.getNext() != null && counter<index) {
			curr = curr.getNext();
			counter++;
		}
		
		if(counter == index) {
			return curr.pop();
		}
		
		return (int) Double.POSITIVE_INFINITY;
	}
	
}
