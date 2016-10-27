package com.mineme.representation.tree;

public class Main {
	public static final String rootParent = "GrandFather";

	public static void main(String[] args) {
		Tree DBLPTree = createSample();
		DBLPTree.packNodes();
		System.out.println(DBLPTree.getRootNode());
	}

	public static Tree createSample() {
		Tree tree = new Tree();

		Node root = new Node("", rootParent);
		tree.addNode(root);

		Node Father = new Node(rootParent, "Father");
		tree.addNode(Father);
		
		Node Me = new Node(rootParent, "Me");
		tree.addNode(Me);

		Node Uncle = new Node(rootParent, "Uncle");
		tree.addNode(Uncle);
		Node Cousine = new Node("Uncle", "Cousine");
		tree.addNode(Cousine);

		Node Aunt = new Node(rootParent, "Aunt");
		tree.addNode(Aunt);
		Node fCousine = new Node("Aunt", "fCousine");
		tree.addNode(fCousine);


		tree.setRootNode(root);

		tree.connectNode(root, Father);
		tree.connectNode(Father, Me);

		tree.connectNode(root, Uncle);
		tree.connectNode(Uncle, Cousine);

		tree.connectNode(root, Aunt);
		tree.connectNode(Aunt, fCousine);

		tree.calcPosition();

		return tree;
	}

}
