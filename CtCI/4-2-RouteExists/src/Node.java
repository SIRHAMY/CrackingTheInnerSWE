import java.util.ArrayList;
import java.util.List;

public class Node {
	private ArrayList<Node> adjacent;
	
	public Node() {
		adjacent = new ArrayList();
	}
	
	//Setters
	public void addAdjacent(Node toAdd) {
		if(!adjacent.contains(toAdd)) adjacent.add(toAdd);
	}
	
	//Getters
	public List<Node> getAdjacent() {
		return adjacent;
	}
}
