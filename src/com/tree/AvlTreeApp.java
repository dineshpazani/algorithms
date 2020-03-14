package com.tree;

public class AvlTreeApp {

	final static long M = 24 * 60 * 60 * 1000 * 1000;

	final static long L = 24 * 60 * 60 * 1000;

	public static void main(String[] args) {

		AvlTree avl = new AvlTree();

		avl.insert(1);
		avl.insert(2);
		avl.insert(3);

	}

}

class AvlTree {

	Node root;

	public void insert(int data) {

		root = insert(root, data);

	}

	private Node insert(Node node, int data) {

		if (node == null)
			node = new Node(data);

		if (data < node.data) {
			if (node.lNdoe != null) {
				insert(node.lNdoe, data);
			} else
				node.lNdoe = new Node(data);
		} else {
			if (node.rNode != null) {
				insert(node.rNode, data);
			} else
				node.rNode = new Node(data);
		}

		node.h = Math.max(height(node.lNdoe), height(node.rNode)) + 1;

		node = settleViolation(data, node);

		return null;
	}

	private Node settleViolation(int data, Node node) {

		int balance = getBalance(node);

		if (balance > 1 && data < node.lNdoe.data)
			return rightRotation(node);

		if (balance < -1 && data > node.rNode.data)
			return leftRotation(node);

		if (balance > 1 && data > node.lNdoe.data) {
			node.lNdoe = leftRotation(node.lNdoe);
			return rightRotation(node);
		}

		if (balance < 1 && data < node.lNdoe.data) {
			node.rNode = rightRotation(node.rNode);
			return leftRotation(node);
		}

		return null;
	}

	public Node leftRotation(Node node) {

		System.out.println("Rotating to left...." + node.data);

		Node tNode = node.rNode;
		Node t = tNode.rNode;

		tNode.rNode = node;
		node.rNode = t;

		node.h = Math.max(height(node.lNdoe), height(node.rNode) + 1);
		node.lNdoe.h = Math.max(height(node.lNdoe), height(node.rNode) + 1);

		return tNode;

	}

	public Node rightRotation(Node node) {

		System.out.println("Rotating to right...." + node.data);

		Node tNode = node.lNdoe;
		Node t = tNode.rNode;

		tNode.rNode = node;
		node.lNdoe = t;

		node.h = Math.max(height(node.lNdoe), height(node.rNode) + 1);
		node.lNdoe.h = Math.max(height(node.lNdoe), height(node.rNode) + 1);

		return tNode;

	}

	public int getBalance(Node node) {

		if (node == null)
			return 0;

		return height(node.lNdoe) - height(node.rNode);

	}

	public int height(Node node) {

		if (node == null)
			return -1;

		return node.h;
	}

	public void traverse() {

		if (root == null)
			return;

		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node node) {

		if (node == null)
			return;

		inOrderTraversal(node.lNdoe);
		System.out.println(node.data);
		System.out.println(node.rNode);
	}

}

class Node {

	int data;
	Node lNdoe;
	Node rNode;
	int h;

	Node(int data) {
		this.data = data;
	}

}
