package k21;

import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
        Stack<Node> frontier = new Stack<>();
        HashSet<String> explored = new HashSet<>();

        root.setParent(null);
        frontier.push(root);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.pop();
            String currentLabel = currentNode.getLabel();

            explored.add(currentLabel);

            if (currentLabel.equals(goal)) {
                return currentNode;
            }
            for (Edge edge : currentNode.getChildren()) {
                Node child = edge.getEnd();
                String childLabel = child.getLabel();

                if (!explored.contains(childLabel) && !frontier.contains(child)) {
                    child.setParent(currentNode);
                    frontier.push(child);
                }
            }
        }

        return null; 
     }
	

	@Override
	public Node execute(Node root, String start, String goal) {
        Stack<Node> frontier = new Stack<>();
        HashSet<String> explored = new HashSet<>();

        root.setParent(null);
        frontier.push(root);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.pop();
            String currentLabel = currentNode.getLabel();
            explored.add(currentLabel);

            if (currentLabel.equals(goal)) {
                return currentNode;
            }

            for (Edge edge : currentNode.getChildren()) {
                Node child = edge.getEnd();
                String childLabel = child.getLabel();

                if (!explored.contains(childLabel) && !frontier.contains(child)) {
                    child.setParent(currentNode);
                    frontier.push(child);
                }
            }
        }

        return null; 
    }

	@Override
	public Node uniformCostSearch(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
