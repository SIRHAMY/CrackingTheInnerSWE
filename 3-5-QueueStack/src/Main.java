
public class Main {
	public static void main(String[] args) {
		boolean answer;
		answer = Double.POSITIVE_INFINITY == Double.POSITIVE_INFINITY;
		System.out.println(answer);
		
		QueueStack myQueue = new QueueStack();
		
		for(int i = 1; i<6; i++) {
			System.out.println("Pushing: " + i);
			myQueue.push(i);
		}
		
		for(int j = 1; j<6; j++) {
			System.out.println("Pop: " + myQueue.pop());
		}
		
		for(int i = 1; i<6; i++) {
			System.out.println("Pushing: " + i);
			myQueue.push(i);
		}
		
		System.out.println("Peeking: " + myQueue.peek());
		
		for(int i = 6; i<11; i++) {
			System.out.println("Pushing: " + i);
			myQueue.push(i);
		}
		
		for(int j = 1; j<11; j++) {
			System.out.println("Pop: " + myQueue.pop());
		}
	}
}
