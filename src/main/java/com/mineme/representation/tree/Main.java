package com.mineme.representation.tree;

public class Main {
	public static final String rootParent = "root";

	public static void main(String[] args) {
		Tree DBLPTree = createDBLPTree();
		DBLPTree.packNodes();
		System.out.println(DBLPTree.getRootNode());
	}

	public static Tree createDBLPTree() {
		Tree tree = new Tree();
		tree.setDataSourceName("DBLP");

		Node root = createNode("", rootParent);
		tree.addNode(root);

		Node id = createNode(rootParent, "id");
		tree.addNode(id);

		Node article = createNode(rootParent, "article");
		tree.addNode(article);
		Node title = createNode("article", "title");
		tree.addNode(title);

		Node venue = createNode(rootParent, "venue");
		tree.addNode(venue);
		Node name = createNode("venue", "Name");
		tree.addNode(name);
		Node year = createNode("venue", "year");
		tree.addNode(year);

		tree.setRootNode(root);

		tree.connectNode(root, id);

		tree.connectNode(root, article);
		tree.connectNode(article, title);

		tree.connectNode(root, venue);
		tree.connectNode(venue, name);
		tree.connectNode(venue, year);

		tree.calcPosition();

		return tree;
	}

	public static Node createNode(String parent, String name) {
		Node node = new Node();
		node.setParent(parent);
		node.setName(name);
		return node;
	}
}
