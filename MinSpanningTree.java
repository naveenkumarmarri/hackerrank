import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class MinSpanningTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int numverticies = sc.nextInt();
		int numEdges = sc.nextInt();
		HashMap<Integer, ArrayList<Edge>> adList = new HashMap<Integer,ArrayList<Edge>>();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		HashMap<Integer,ArrayList<Integer>> weightMap = new HashMap<Integer,ArrayList<Integer>>();
		for(int i=0;i<numEdges;i++)
		{
			int vertex = sc.nextInt();
			int edge = sc.nextInt();
			int weight = sc.nextInt();
			queue.add(weight);
			if(adList.containsKey(vertex))
			{
				ArrayList<Edge> edges = adList.get(vertex);
				edges.add(new Edge(edge,weight));
				adList.put(vertex, edges);
			}
			else
			{
				ArrayList<Edge> edges= new ArrayList<Edge>();
				edges.add(new Edge(edge,weight));
				adList.put(vertex, edges);
			}
			if(weightMap.containsKey(weight))
			{
				ArrayList<Integer> node = weightMap.get(weight);
				node.add(edge);
				weightMap.put(weight, node);
			}
			else
			{
				ArrayList<Integer> node = new ArrayList<Integer>();
				node.add(edge);
				weightMap.put(weight, node);
			}
			
		}
		Iterator<Entry<Integer,ArrayList<Integer>>> it =weightMap.entrySet().iterator() ;
		System.out.println(queue);
		System.out.println(weightMap);
	}
	
	public static void minSpanTree(HashMap<Integer,ArrayList<Edge>> adList,
									PriorityQueue<Integer> queue, 
									HashMap<Integer,ArrayList<Integer>> weightMap,
									int start)
	{
		Set<Integer> nodes = adList.keySet();
		int minSum=0;
		ArrayList<Integer> visited = new ArrayList<Integer>();
		visited.add(start);
		while(visited.size()!=nodes.size())
		{
			int node = queue.poll();
			ArrayList<Integer> list = weightMap.get(node);
			for(int i:list)
			{
				if(!visited.contains(i))
				{
					ArrayList<Edge> edge = adList.get(i);
					
					visited.add(i);
					minSum = minSum+node;
				}
			}
		}
	}

}
class Edge{
	Edge(int edge,int weight)
	{
		this.edge=edge;
		this.weight=weight;
	}
	int weight;
	int edge;
	public String toString()
	{
		return (this.edge+"-"+this.weight);
	}
}
