package k21;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch_GS implements ISearchAlgo {

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
				if (child.getParent() == null) {
					child.setParent(currentNode);
					frontier.add(child);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		if (root == null || start == null || goal == null) {
			return null;
		}

		Queue<Node> frontier = new LinkedList<>();
		HashSet<String> explored = new HashSet<>();

		root.setParent(null);
		frontier.add(root);

		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
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
					frontier.add(child);
				}
			}
		}

		return null;
	}

}
