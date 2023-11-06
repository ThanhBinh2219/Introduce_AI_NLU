package k21;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");

		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);

		ISearchAlgo algo1 = new BreadthFirstSearch_GS();
		ISearchAlgo algo2 = new DepthFirstSearch_GS();
		ISearchAlgo algo3 = new BreadthFirstSearch_TS();
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("Task 1:");

		Node result = algo1.execute(nodeS, "G");

		if (result != null) {
			List<String> path = NodeUtils.printPath(result);
			System.out.println("Đường đi từ S đến G theo BFS: " + String.join(" -> ", path));
		} else {
			System.out.println("Không tìm thấy đường đi từ S đến G theo BFS.");
		}

		Node result2 = algo2.execute(nodeS, "G");

		if (result2 != null) {
			List<String> path = NodeUtils.printPath(result2);
			System.out.println("Đường đi từ S đến G theo DFS: " + String.join(" -> ", path));
		} else {
			System.out.println("Không tìm thấy đường đi từ S đến G theo DFS.");
		}
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
		System.out.println("Task 2:");
		Node bfsResult = algo1.execute(nodeS, "S", "G");
		if (bfsResult != null) {
			List<String> bfsPath = NodeUtils.printPath(bfsResult);
			System.out.println("Đường đi từ S đến G (BFS): " + String.join(" -> ", bfsPath));
		} else {
			System.out.println("Không tìm thấy đường đi từ S đến G (BFS).");
		}
		Node dfsResult = algo2.execute(nodeS, "S", "G");
		if (dfsResult != null) {
			List<String> dfsPath = NodeUtils.printPath(dfsResult);
			System.out.println("Đường đi từ S đến G (DFS): " + String.join(" -> ", dfsPath));
		} else {
			System.out.println("Không tìm thấy đường đi từ S đến G (DFS).");
		}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		System.out.println("Task 3:");
		Node bfsTreeSeach = algo3.execute(nodeS, "G");
		if (bfsTreeSeach != null) {
			List<String> bfsPath = NodeUtils.printPath(bfsTreeSeach);
			System.out.println("Đường đi từ S đến G (BFS_TS): " + String.join(" -> ", bfsPath));
		} else {
			System.out.println("Không tìm thấy đường đi từ S đến G (BFS_TS).");
		}
//		Node dfsResult = algo2.execute(nodeS, "S", "G");
//		if (dfsResult != null) {
//			List<String> dfsPath = NodeUtils.printPath(dfsResult);
//			System.out.println("Đường đi từ S đến G (DFS): " + String.join(" -> ", dfsPath));
//		} else {
//			System.out.println("Không tìm thấy đường đi từ S đến G (DFS).");
//		}
	}
}
