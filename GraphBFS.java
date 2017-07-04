import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import sun.misc.Queue;

public class GraphBFS {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int numverticies = sc.nextInt();
		int numEdges = sc.nextInt();
		HashMap<Integer, ArrayList<Integer>> adList = new HashMap<Integer,ArrayList<Integer>>();
		for(int i=0;i<numEdges;i++)
		{
			int vertex = sc.nextInt();
			int edge = sc.nextInt();
			if(adList.containsKey(vertex))
			{
				ArrayList<Integer> edges = adList.get(vertex);
				edges.add(edge);
				adList.put(vertex, edges);
			}
			else
			{
				ArrayList<Integer> edges= new ArrayList<Integer>();
				edges.add(edge);
				adList.put(vertex, edges);
			}
			
		}
		Iterator<Entry<Integer,ArrayList<Integer>>> it =adList.entrySet().iterator() ;
		/*while(it.hasNext())
			System.out.println(it.next());*/
		BFG(adList,6);
		
	}
	
	public static void BFG(HashMap<Integer,ArrayList<Integer>> adList,int start) throws InterruptedException
	{
		ArrayList<Integer> visited = new ArrayList<Integer>();
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(start);
		visited.add(start);
		while(!q.isEmpty())
		{
			int currEdge = q.dequeue();
			ArrayList<Integer> edges = adList.get(currEdge);
			if(adList.containsKey(edges))
			{
				Iterator<Integer> it = edges.iterator();
				while(it.hasNext())
				{
					int edge = it.next();
					if(!visited.contains(edge))
					{
						q.enqueue((edge));
						
					}
					if(!visited.contains(currEdge))
						visited.add(currEdge);
				}
			}
				
			
			
		}
		System.out.println(visited);
	}

}
