package com.mineme.representation.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shahriar Robbani 11-SEP-2016
 *
 */
public class Node implements Cloneable, Serializable {
	private static int next_id = 0;
	private int id;
	private String name;
	private String dataSourceName;
	private String dataSourceAPI;
	private Integer typeId;
	private String position;
	private String parent;
	// Id of Actual Node of renamed node, i.e. venue ----> Conf
	private Integer actualNodeID;

	private ArrayList<Node> childNodes = new ArrayList<>();

	private boolean visited;

	public Node() {
		init();
	}

	public Node(String parent, String name) {
		init();
		this.setParent(parent);
		this.setName(name);
	}

	private void init() {
		visited = false;
		this.id = ++Node.next_id;
	}

	public ArrayList<Node> getChildNodes() {
		return this.childNodes;
	}

	public void addChildNodes(Node childNode) {
		this.childNodes.add(childNode);
	}

	public void clearChildNodes() {
		this.childNodes.clear();
	}

	public boolean hasChildNodes() {
		return !this.childNodes.isEmpty();
	}

	public int getLevel() {
		if (!this.getPosition().contains(".")) {
			return 1;
		}
		String[] level = this.getPosition().split("\\.");
		return level.length;
	}

	public int getActualNodeID() {
		return actualNodeID;
	}

	public String getDataSourceAPI() {
		return dataSourceAPI;
	}

	public String getDataSourceName() {
		return dataSourceName;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getParent() {
		return parent;
	}

	public String getPosition() {
		return position;
	}

	public int getTypeId() {
		return typeId;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setActualNodeID(int actualNodeID) {
		this.actualNodeID = actualNodeID;
	}

	public void setDataSourceAPI(String dataSourceAPI) {
		this.dataSourceAPI = dataSourceAPI;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Node copy() throws CloneNotSupportedException {
		return (Node) this.clone();
	}

	public Node selfTree() {
		return null;
	}

	public Node all_subtrees(int max_depth) {
		List<Node> nodes = new ArrayList<>();
		if (this.getChildNodes().isEmpty()) {
			return this;
		}

		if (max_depth > 0) {

		}

		return this;
	}

	@Override
	public String toString() {
		return this.getName() + this.getChildNodes();
	}
}
