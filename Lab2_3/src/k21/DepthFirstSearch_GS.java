package k21;

import java.util.List;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch_GS implements ISearchAlgo {

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
            List<Node> nodes = currentNode.getChildrenNodes();
            Collections.reverse(nodes);
            if (currentLabel.equals(goal)) {
                return currentNode;
            }
            for (Node node : nodes) {
            	
                if (!explored.contains(node) && !frontier.contains(node)) {
                	frontier.push(node);
                    node.setParent(currentNode);
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
}
