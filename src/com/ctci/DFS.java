package com.ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DFS {

	private Color[] colors;
	private Integer[] predecessors;
	private Integer[] distances;
	private static int count = 0;
	private Graph graph;

	boolean debug = true;

	public enum Color {
		WHITE, GRAY, BLACK;
	}

	public DFS(Graph g_) {
		graph = g_;
		colors = new Color[g_.V()];
		predecessors = new Integer[g_.V()];
		distances = new Integer[g_.V()];
	}

	public void dfs(int source) {
		if (source < 0 || source >= graph.V()) {
			throw new IndexOutOfBoundsException();
		}

		for (int u = 0; u < graph.V(); u++) {
			if (u != source) {
				colors[u] = Color.WHITE;
				distances[u] = Integer.MAX_VALUE;
				predecessors[u] = null;
			}
		}

		colors[source] = Color.GRAY;
		distances[source] = 0;
		predecessors[source] = null;

		Stack<Integer> q = new Stack<Integer>();
		q.add(source);

		while (!q.isEmpty()) {
			Integer u = q.pop();

			for (Integer v : graph.adj(u)) {
				if(colors[v]==Color.GRAY)
					count++;
				if (colors[v] == Color.WHITE) {
					colors[v] = Color.GRAY;
					distances[v] = distances[u] + 1;
					predecessors[v] = u;
					q.add(v);
				}
				
			}

			colors[u] = Color.BLACK;
			if (debug) {
				System.out.println(this);
			}
		}

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Arrays.toString(colors));
		sb.append("\n");

		sb.append(Arrays.toString(distances));
		sb.append("\n");

		sb.append(Arrays.toString(predecessors));
		sb.append("\n");

		return new String(sb);
	}

	public static void main(String[] args) {
		int V = 5;
		Graph g = new Graph(V);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(1, 2);
		g.addUndirectedEdge(0, 2);
		g.addUndirectedEdge(1, 4);
		g.addUndirectedEdge(1, 3);
		g.addUndirectedEdge(4, 3);
		g.addUndirectedEdge(3, 2);
		System.out.println(g);

		DFS dfs = new DFS(g);

		dfs.dfs(0);

		System.out.println(dfs);
		System.out.println(count);
	}

}
class Graph {

	private int V;
	private int E = 0;
	private List<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int V_) {
		this.V = V_;
		adj = new List[V_];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}

	public List<Integer> adj(int v) {
		return adj[v];
	}

	public void addDirectedEdge(int from, int to) {
		if (!adj[from].contains(to)) {
			E++;
			adj[from].add(to);
		}
	}

	public void addUndirectedEdge(int from, int to) {
		addDirectedEdge(from, to);
		addDirectedEdge(to, from);
	}

	public int V() {
		return V;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Graph with V = " + V + " , E = " + E + "\n");
		for (int i = 0; i < this.V(); i++) {
			sb.append(i + ": ");
			sb.append(adj[i]);
			sb.append("\n");
		}

		return new String(sb);
	}

	private class VertexIterator implements Iterator<Integer> {
		private int vertex = 0;

		@Override
		public boolean hasNext() {
			return (vertex < Graph.this.V);
		}

		@Override
		public Integer next() {
			int current = vertex;
			vertex++;
			return current;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

	public Iterator<Integer> iterateVertices() {
		return new VertexIterator();
	}

	public Iterator<Integer> iterateEdges(int v) {
		return this.adj[v].iterator();
	}

	public static void main(String[] args) {
		int V = 0;
		Graph g = new Graph(V);

		System.out.println(g);

	}
}