import java.util.Iterator;
import java.util.LinkedList;

public class ShelterQueue {
	public static void main(String[] args) {
		ShelterQueue s = new ShelterQueue();
		
		s.enqueue(new Dog());
		s.enqueue(new Cat());
		s.enqueue(new Dog());
		s.enqueue(new Cat());
		s.enqueue(new Cat());
		s.enqueue(new Cat());
		s.enqueue(new Dog());
		s.enqueue(new Dog());
		s.enqueue(new Dog());
		s.enqueue(new Cat());
		s.enqueue(new Dog());
		
		//Dequeue
		System.out.println("Expected/Actual: Dog/" + s.dequeue().getSpecies());
		System.out.println("Expected/Actual: Cat/" + s.dequeue().getSpecies());
		
		//Dequeue Cat
		System.out.println("Expected/Actual: Cat/" + s.dequeueCat().getSpecies());
		System.out.println("Expected/Actual: Cat/" + s.dequeueCat().getSpecies());
		
		//Dequeue
		System.out.println("Expected/Actual: Dog/" + s.dequeue().getSpecies());
		
		//Dequeue Dog
		System.out.println("Expected/Actual: Dog/" + s.dequeueDog().getSpecies());
		System.out.println("Expected/Actual: Dog/" + s.dequeueDog().getSpecies());
		
		//Dequeue
		System.out.println("Expected/Actual: Cat/" + s.dequeue().getSpecies());
		System.out.println("Expected/Actual: Dog/" + s.dequeue().getSpecies());
		System.out.println("Expected/Actual: Cat/" + s.dequeue().getSpecies());
		System.out.println("Expected/Actual: Dog/" + s.dequeue().getSpecies());
		
		//NULL?
		//System.out.print("Expected/Actual: Null?/" + s.dequeue().getSpecies());
	}
	
	
	private LinkedList<Animal> shelter;
	
	public ShelterQueue() {
		shelter = new LinkedList<Animal>();
	}
	
	public void enqueue(Animal pet) {
		shelter.push(pet);
	}
	
	public Animal dequeue() {
		return shelter.removeLast();
	}
	
	public Dog dequeueDog() {
		return (Dog) dequeueHelper("Dog");
	}
	
	public Cat dequeueCat() {
		return (Cat) dequeueHelper("Cat");
	}
	
	public Animal dequeueHelper(String search) {
		Iterator<Animal> handler = shelter.descendingIterator();
		Animal result = null;
		
		Animal curr;
		while(handler.hasNext()) {
			curr = handler.next();
			if(curr.getSpecies().equals(search)) {
				handler.remove();
				result = curr;
				break;
			}
		}
		
		return result;
	}
}
