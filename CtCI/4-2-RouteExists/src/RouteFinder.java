import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class RouteFinder {
	public static void main(String[] args) {
		RouteFinder rf = new RouteFinder();
		
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		Node e = new Node();
		
		a.addAdjacent(b);
		
		b.addAdjacent(c);
		
		c.addAdjacent(d);
		
		d.addAdjacent(b);
		d.addAdjacent(e);
		
		System.out.println("A -> B");
		System.out.println(rf.routeExists(a, b));
		
		System.out.println("B -> A");
		System.out.println(rf.routeExists(b, a));
		
		System.out.println("B -> D");
		System.out.println(rf.routeExists(b, d));
		
		System.out.println("C -> B");
		System.out.println(rf.routeExists(c, b));
		
		System.out.println("D -> C");
		System.out.println(rf.routeExists(d, c));
		
		System.out.println("A -> E");
		System.out.println(rf.routeExists(a, e));
		
		System.out.println("E -> B");
		System.out.println(rf.routeExists(e, b));
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
