package k21;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch_TS implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<>();
	    frontier.add(root);

	    while (!frontier.isEmpty()) {
	        Node currentNode = frontier.poll();
	        if (currentNode.getLabel().equals(goal)) {
	            return currentNode;
	        }

	        for (Edge edge : currentNode.getChildren()) {
	            Node child = edge.getEnd();
	            frontier.add(child);
	        }
	    }

	    return null;
	}



	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
}
