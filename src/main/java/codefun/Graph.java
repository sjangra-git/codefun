package codefun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

	private int numVertices;
	private int numEdges;
	private List<Integer>[] list;
	private boolean[] discovered;
	private boolean[] processed;
	
	Graph(int numVertices, int numEdges) {
		this.numVertices = numVertices;
		this.numEdges = numEdges;				
		list = (ArrayList<Integer>[])new ArrayList[numVertices + 1];
		for(int i = 0; i<numVertices+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		discovered = new boolean[numVertices + 1];
		processed = new boolean[numVertices + 1];
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(5, 4);
		g.createGraph();
		g.dfs(1);
	}
	
	private void addEdges(int i, int... end) {
		for(int j : end) {
			addEdge(i, j);
		}
	}
	
	private boolean addEdge(int i, int j) {
		boolean added = false;
		
		// Add i-> j
		added = list[i].add(j);
		
		return added;
	}
	
	private boolean removeEdge(int i, int j) {
		boolean removed = false;
		
		Integer removedVal = list[i].remove(j);
		
		return (removedVal != null);
	}
	
	public void createGraph() {
		addEdges(1,3,5,2,4);
		addEdges(2,5,1);
		addEdges(3,1,4);
		addEdges(4, 3,1);
		addEdges(5,1,2);		
	}
	

	// BFS starting at node 'i'
	public void bfs(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		
		// Mark vertices as visited
		boolean[] visited = new boolean[numVertices + 1];		
		
		while(!queue.isEmpty()) {
			int curr = queue.remove();
			visited[curr] = true;
			
			// Go over connected edges of current element
			List<Integer> connected = list[curr];
			for(Integer v : connected) {
				if(!visited[v]) {
					queue.add(v);
					visited[v] = true;
				}
			}
			
			// Process current node
			System.out.println(curr);			
		}
		
	}
	
	public void dfs(int i) {
		
		discovered[i] = true;
		// Process current node
		System.out.print(i+">");
		
		// Go over all edges
		for(Integer v : list[i]) {
			if(!discovered[v]) {
				dfs(v);
			}
		}
		
		processed[i] = true;
	}
	
}
