package k21;

public interface ISearchAlgo {
	public Node execute(Node root, String goal);
	public Node execute(Node root, String start, String goal); 
	public Node uniformCostSearch(Node root, String goal); 
}
