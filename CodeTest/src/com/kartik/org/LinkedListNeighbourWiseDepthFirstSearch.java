package com.kartik.org;

import java.util.ArrayList;
import java.util.List;
/**
Depth First Search or DFS for a Graph
Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree. The only catch here is, 
unlike trees, graphs may contain cycles, so we may come to the same node again. To avoid processing a node more than 
once, we use a boolean visited array.

For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0, we look for all adjacent 
vertices of it. 2 is also an adjacent vertex of 0. If we don’t mark visited vertices, then 2 will be processed again and 
it will become a non-terminating process. A Depth First Traversal of the following graph is 2, 0, 1, 3.



See this post for all applications of Depth First Traversal.
Following are implementations of simple Depth First Traversal. The C++ implementation uses adjacency list representation
 of graphs. STL‘s list container is used to store lists of adjacent nodes.
 
 
 * @author kmandal
 *
 */
public class LinkedListNeighbourWiseDepthFirstSearch {

	static class Node {
		int data;
		boolean visited;
		List<Node> neighbours;

		Node(int data) {
			this.data = data;
			this.neighbours = new ArrayList<>();

		}

		public void addNeighbours(Node neighbourNode) {
			this.neighbours.add(neighbourNode);
		}

		public List<Node> getNeighbours() {
			return neighbours;
		}

		public void setNeighbours(List<Node> neighbours) {
			this.neighbours = neighbours;
		}
	}

	// Recursive DFS
	public void dfs(Node node) {
		System.out.print(node.data + " ");
		List<Node> neighbours = node.getNeighbours();
		node.visited = true;
		for (int i = 0; i < neighbours.size(); i++) {
			Node n = neighbours.get(i);
			if (n != null && !n.visited) {
				dfs(n);
			}
		}
	}


	public static void main(String arg[]) {

		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);

		node40.addNeighbours(node10);
		node40.addNeighbours(node20);
		node10.addNeighbours(node30);
		node20.addNeighbours(node10);
		node20.addNeighbours(node30);
		node20.addNeighbours(node60);
		node20.addNeighbours(node50);
		node30.addNeighbours(node60);
		node60.addNeighbours(node70);
		node50.addNeighbours(node70);

		LinkedListNeighbourWiseDepthFirstSearch dfsExample = new LinkedListNeighbourWiseDepthFirstSearch();

     	System.out.println("The DFS traversal of the graph using recursion ");
		dfsExample.dfs(node40);
	}
}
