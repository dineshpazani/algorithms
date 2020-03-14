package com.ds.disjoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DisJoinApp {

	public static void main(String[] args) {
		
		
		

	}

}

class KVertex{
	
	
	public String name;
	public KNode node;
	
	public KVertex(String name) {
		this.name = name;
	}

	
	
}

class KEdge implements Comparable<KEdge> {
	
	public Double weight;
	public KVertex sv;
	public KVertex tv;
	
	
	public KEdge(Double weight, KVertex sv, KVertex tv) {
		super();
		this.weight = weight;
		this.sv = sv;
		this.tv = tv;
	}

	@Override
	public int compareTo(KEdge edge) {
		return Double.compare(this.weight, edge.weight);
	}	
}

class KNode{
	
	public Integer id;
	public Integer rank;
	public KNode parent;
	public KNode(Integer id, Integer rank, KNode parent) {
		this.id = id;
		this.rank = rank;
		this.parent = parent;
	}
}

class DisjoinSet{
	
	public Integer nodeCount = 0;
	public Integer setCount = 0;
	public List<KNode> rootNode;
	
	public DisjoinSet(List<KVertex> kVertex) {
		this.rootNode = new ArrayList<>(kVertex.size());
		
		makeSets(kVertex);
	}
	
	public Integer find(KNode n) {
		
		KNode currentNode = n;
		
		while(currentNode.parent != null) {
			currentNode = currentNode.parent;
		}
		
		KNode rootKNode = currentNode;
		
		while(currentNode != rootKNode) {
			KNode temp = currentNode.parent;
			currentNode.parent = rootKNode;
			currentNode = temp;
		}
		
		return rootKNode.id;
	}
	
	public void union(KNode node1, KNode node2) {
		
		
		Integer index1 = find(node1);
		Integer index2 = find(node2);
		
		if(index1 == index2) {
			return;
		}
		
		KNode root1 = this.rootNode.get(index1);
		KNode root2 = this.rootNode.get(index2);
		
		if(root1.rank < root2.rank) {
			
			root1.parent = root2;
			
		}else if(root1.rank > root2.rank){
			root2.parent = root1;
		}else {
			root2.parent = root1;
			root1.rank = root1.rank+1;
		}
		
		this.setCount--;
		
	}

	public void makeSets(List<KVertex> kVertex) {
		
		for(KVertex v : kVertex) {
			makeSet(v);
		}
		
	}

	public void makeSet(KVertex v) {
		
		KNode n = new KNode(0, rootNode.size(), null);
		v.node = n;
		this.rootNode.add(n);
		this.setCount++;
		this.nodeCount++;
		
	}
	
	
	
}


class KuAlgorithm {
	
	
	public void sapnningTree(List<KVertex> vertaxList, List<KEdge> edgeList) {
		
		DisjoinSet disjoinSet = new DisjoinSet(vertaxList);
		
		List<KEdge> mst = new ArrayList<>();
		
		Collections.sort(edgeList);
		
		for(KEdge edge: edgeList) {
			KVertex u = edge.sv;
			KVertex v = edge.tv;
			
			if(disjoinSet.find(u.node) != disjoinSet.find(v.node)) {
				mst.add(edge);
				
				disjoinSet.union(u.node, v.node);
			}
		}
		
		for(KEdge edge : mst) {
			System.out.println(edge.sv+" "+edge.tv+" -- ");
		}
		
	}
	
	
}




