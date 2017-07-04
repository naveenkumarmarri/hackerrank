import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class GraphDFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numEdges = sc.nextInt();
		HashMap<Integer, Stack<Integer>> adList = new HashMap<Integer,Stack<Integer>>();
		for(int i=0;i<numEdges;i++)
		{
			int vertex = sc.nextInt();
			int edge = sc.nextInt();
			if(adList.containsKey(vertex))
			{
				Stack<Integer> edges = adList.get(vertex);
				edges.add(edge);
				adList.put(vertex, edges);
			}
			else
			{
				Stack<Integer> edges= new Stack<Integer>();
				edges.add(edge);
				adList.put(vertex, edges);
			}
			
		}
		//Iterator<Entry<Integer,ArrayList<Integer>>> it =adList.entrySet().iterator() ;
		DFS(adList,1);
	}
	public static void DFS(HashMap<Integer,Stack<Integer>> adList,int start)
	{
		Stack<Integer> visited = new Stack<Integer>();
		Stack<Integer> edges = new Stack<Integer>();
		LinkedList<Integer> visit = new LinkedList<Integer>();
		edges.push(start);
		//visited.add(start);
		while(!edges.isEmpty())
		{
			//System.out.println(edges);
			int top = edges.peek();
			edges.pop();
			if(!visited.contains(top))
			{
				visited.add(top);
				edges.addAll(adList.get(top));
				visit.add(top);
			}
				
		}
		System.out.println(visit);
	}
}
