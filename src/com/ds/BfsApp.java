package com.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsApp {

	public static void main(String[] args) {
		
		Bfs bfs = new Bfs();
		
		
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		
		v1.neighbourList.add(v2);
		v1.neighbourList.add(v4);
		v4.neighbourList.add(v5);
		v2.neighbourList.add(v3);
		
		bfs.bfs(v1); 

	}

}

class Bfs{
	
	public void bfs(Vertex root) {
	
		Queue<Vertex> queue = new LinkedList<>();
		
		root.isVisited = true;
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Vertex actualVertex = queue.remove();
			System.out.println(actualVertex+" ");
			
			for(Vertex v: actualVertex.neighbourList) {
				if(!v.isVisited) {
					v.isVisited = true;
					queue.add(v);
				}
			}
		}
	}
}


class Vertex{
	
	public int data;
	public boolean isVisited;
	public List<Vertex> neighbourList;
	
	
	public Vertex(int data) {
		this.data = data;
		this.neighbourList = new ArrayList<>();
	}

	@Override
	public String toString() {
		return Integer.toString(data);
	}
}
