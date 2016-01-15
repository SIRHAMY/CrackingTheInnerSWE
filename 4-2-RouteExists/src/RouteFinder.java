import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class RouteFinder {
	public static void main(String[] args) {
		RouteFinder rf = new RouteFinder();
		
		Node a = new Node();
		Node b = new Node();
		
		a.addAdjacent(b);
		
		System.out.println(rf.routeExists(a, b));
		System.out.println(rf.routeExists(b, a));
	}

	public boolean routeExists(Node start, Node end) {
		Stack<Node> toVisit = new Stack();
		ArrayList<Node> visited = new ArrayList();
		
		toVisit.push(start);
		
		//While there are nodes to be visited
		while(!toVisit.isEmpty()) {
			Node visiting = toVisit.pop();
			//Make sure the node hasn't been visited
			if(visited == null || !visited.contains(visiting)) {
				
				//Add node we're visiting to visited
				visited.add(visiting);
				
				//Check if this is what we're looking for
				if(visiting == end) return true;
				
				//Add nodes to toVisit stack
				List<Node> visitingAdj = visiting.getAdjacent();
				Iterator it = visitingAdj.listIterator();
				
				while(it.hasNext()) {
					toVisit.push((Node) it.next());
				}
			}
		}
		
		return false;
	}
}
