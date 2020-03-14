package com.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BFS1 {
	public static void main(String[] args) {

		Vertax1 v1 = new Vertax1(10);
		Vertax1 v2 = new Vertax1(20);
		Vertax1 v3 = new Vertax1(30);
		Vertax1 v4 = new Vertax1(40);
		Vertax1 v5 = new Vertax1(50);

		v1.nb.add(v2);
		v1.nb.add(v2);
		v2.nb.add(v3);
		v3.nb.add(v4);
		v4.nb.add(v5);
		v5.nb.add(v1);

		Bfs1 bfs1 = new Bfs1();
		bfs1.bfs(v1);

	}
}

class Bfs1 {

	public void bfs(Vertax1 root) {

		Queue<Vertax1> q = new LinkedList<>();

		root.isv = true;
		q.add(root);

		while (!q.isEmpty()) {

			Vertax1 av = q.remove();
			System.out.println(av);

			for (Vertax1 v : av.nb) {
				if (!v.isv) {

					v.isv = true;
					q.add(v);
				}

			}

		}

	}
}

class Vertax1 {

	int data;
	boolean isv;
	List<Vertax1> nb;

	public Vertax1(int data) {
		this.data = data;
		nb = new ArrayList<>();
	}

	@Override
	public String toString() {
		return Integer.toString(this.data);
	}

}