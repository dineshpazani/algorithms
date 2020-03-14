package com.tree;

public class SplayTreeApp {

	public static void main(String[] args) {

		SplayTree st = new SplayTree();

		st.add(50);
		st.add(40);
		st.add(60);
		st.add(30);
		st.add(70);
		st.add(20);
		st.add(80);

		st.getAll();

		st.getheight();

	}

}

class SplayTree {

	SplayNode rootNode = null;

	public void add(int data) {

		if (rootNode == null) {
			rootNode = new SplayNode(data);
		} else {
			add(rootNode, data);
		}
	}

	private void add(SplayNode cNode, int data) {

		if (data < cNode.data) {
			if (cNode.lNode != null) {
				add(cNode.lNode, data);
			} else {
				cNode.lNode = new SplayNode(data);
			}

		} else {

			if (cNode.rNode != null) {
				add(cNode.rNode, data);
			} else {
				cNode.rNode = new SplayNode(data);
			}
		}

	}

	public void getheight() {

		if (rootNode != null)
			System.out.println(height(rootNode));
	}

	private int height(SplayNode cNode) {

		if (cNode == null)
			return 0;
		else {

			int lh = height(cNode.lNode);
			int rh = height(cNode.rNode);

			return (lh + 1) + (rh + 1);
		}
	}

	int maxDepth(SplayNode node) {
		if (node == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.lNode);
			int rDepth = maxDepth(node.rNode);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	public void getAll() {

		if (rootNode != null)
			inorderTraverse(rootNode);
	}

	private void inorderTraverse(SplayNode cNode) {

		if (cNode == null)
			return;

		inorderTraverse(cNode.lNode);
		System.out.println(cNode.data);
		inorderTraverse(cNode.rNode);

	}

}

class SplayNode {

	int data;
	SplayNode lNode;
	SplayNode rNode;

	public SplayNode(int data) {
		this.data = data;
	}

}
