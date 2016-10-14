package com.mineme.representation.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Tree {

	private String id;
	private String dataSourceName;
	private Node rootNode;
	private List<Node> nodes = new ArrayList<>();
	private int[][] adjMatrix;// Edges will be represented as adjacency Matrix
	private int size;

	public String getDataSourceName() {
		return dataSourceName;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}


	public void setRootNode(Node n) {
		this.rootNode = n;
		this.rootNode.setPosition("0");
	}

	public Node getRootNode() {
		return this.rootNode;
	}

	public List<Node> getnodes() {
		return nodes;
	}

	public void addNode(Node n) {
		this.nodes.add(n);
	}

	// This method will be called to make connect two nodes
	public void connectNode(Node start, Node end) {
		if (adjMatrix == null) {
			size = nodes.size();
			adjMatrix = new int[size][size];
		}

		int startIndex = nodes.indexOf(start);
		int endIndex = nodes.indexOf(end);
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] = 1;
	}

	private Node getUnvisitedChildNode(Node n) {

		int index = nodes.indexOf(n);
		int j = 0;
		while (j < size) {
			if (adjMatrix[index][j] == 1 && ((Node) nodes.get(j)).isVisited() == false) {
				return (Node) nodes.get(j);
			}
			j++;
		}
		return null;
	}

	// BFS traversal of a tree is performed by the bfs() function
	public void bfs() {

		// BFS uses Queue data structure
		Queue<Node> q = new LinkedList<>();
		q.add(this.rootNode);
		// printNode(this.rootNode);
//		System.out.println(this.rootNode.getName() + ":" + this.rootNode.getPosition());
		rootNode.setVisited(true);

		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			Node child = null;
			int pos = 0;
			while ((child = getUnvisitedChildNode(n)) != null) {
				child.setVisited(true);
				child.setPosition(
						nodes.get(getNodeIndex(child.getParent())).getPosition() + "." + new Integer(pos).toString());
//				 printNode(child);
//				System.out.println(child.getName() + ":" + child.getPosition());
				q.add(child);
				pos++;
			}

		}
		// Clear visited property of nodes
		clearNodes();
	}

	// DFS traversal of a tree is performed by the dfs() function
	public void dfs() {
		// DFS uses Stack data structure
		Stack<Node> s = new Stack<>();
		s.push(this.getRootNode());
		rootNode.setVisited(true);
		printNode(rootNode);
		while (!s.isEmpty()) {
			Node n = (Node) s.peek();
			Node child = getUnvisitedChildNode(n);
			if (child != null) {
				child.setVisited(true);
				printNode(child);
				s.push(child);
			} else {
				s.pop();
			}
		}
		// Clear visited property of nodes
		clearNodes();
	}

	// Utility methods for clearing visited property of node
	private void clearNodes() {
		int i = 0;
		while (i < size) {
			Node n = (Node) nodes.get(i);
			n.setVisited(false);
			i++;
		}
	}

	// Utility methods for printing the node's label
	private void printNode(Node n) {
		System.out.print(n.getName() + " ");
	}

	public int getNodeIndex(String name) {
		for (int i = 0; i < this.nodes.size(); i++) {
			if (this.nodes.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public void calcPosition() {
		this.bfs();
	}

	public int getHeighestLevel() {
		int heighestLevel = 0;
		for (Node node : this.getnodes()) {
			if (node.getLevel() > heighestLevel) {
				heighestLevel++;
			}
		}
		return heighestLevel;
	}

	public Map<Integer, ArrayList<Node>> getLevelsWithNodes() {
		Map<Integer, ArrayList<Node>> levels = new HashMap<>();

		// initialize all the ArrayLists with map keys
		for (int i = 1; i <= this.getHeighestLevel(); i++) {
			levels.put(i, new ArrayList<Node>());
		}

		for (Node node : this.getnodes()) {
			levels.get(node.getLevel()).add(node);
		}

		return levels;
	}
	
	public Node packNodes() {
		Map<Integer, ArrayList<Node>> levels = this.getLevelsWithNodes();
		for (int i = levels.size(); i > 1; i--) {
			ArrayList<Node> nodes = levels.get(i);
			for (Node node : nodes) {
				this.getnodes().get(this.getNodeIndex(node.getParent())).addChildNodes(node);
			}
		}
		return this.getRootNode();
	}

}
