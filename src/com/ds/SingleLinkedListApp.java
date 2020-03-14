package com.ds;

public class SingleLinkedListApp {

	public static void main(String[] args) {
	
		SingleLinkedListimpl sll = new SingleLinkedListimpl();
		
		sll.addAtLast(10);
		sll.addAtLast(20);
		sll.addAtLast(30);
		sll.addAtLast(40);
		sll.addAtLast(50);
		
		sll.print();

	}

}

class NodeSL{
	
	int data;
	NodeSL nNode;
	
	NodeSL(int data){
		this.data = data;
	}
	
}

class SingleLinkedListimpl{
	
	NodeSL headNode;
	
	public void addAtLast(int data) {
		
		if(headNode == null) {
			headNode = new NodeSL(data);
		}else {
			generateNode(this.headNode, data);
		}
		
	}

	private void generateNode(NodeSL headNode2, int data) {
		
		if(headNode2.nNode != null)
			generateNode(headNode2.nNode, data);
		else
			headNode2 .nNode = new NodeSL(data);
		
	}
	
	
	public void print() {
		
		if(this.headNode != null)
			recursive(this.headNode);
	}

	private void recursive(NodeSL headNode2) {
		
		if(headNode2 == null)
				return;
						
		
		System.out.println(headNode2.data);
		recursive(headNode2.nNode);
		
	}
}
