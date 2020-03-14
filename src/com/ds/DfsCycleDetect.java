package com.ds;

import java.util.ArrayList;
import java.util.List;

public class DfsCycleDetect {

	public static void main(String[] args) {

		Cv v1 = new Cv(10);
		Cv v2 = new Cv(20);
		Cv v3 = new Cv(30);
		Cv v4 = new Cv(40);
		Cv v5 = new Cv(50);
		Cv v6 = new Cv(60);

		v1.adjL.add(v2);
		v1.adjL.add(v3);
		v2.adjL.add(v3);
		v4.adjL.add(v1);
		v4.adjL.add(v5);
		v5.adjL.add(v6);
		v6.adjL.add(v4);

		List<Cv> v = new ArrayList<>();
		v.add(v1);
		v.add(v2);
		v.add(v3);
		v.add(v4);
		v.add(v5);
		v.add(v6);

		CycleDetection cd = new CycleDetection();
		cd.detectCycle(v);

	}

}

class CycleDetection {

	public void detectCycle(List<Cv> vL) {

		for (Cv cv : vL) {
			if (!cv.visited) {
				dfs(cv);
			}
		}

	}

	private void dfs(Cv cv) {

		System.out.println("DFS vertex" + cv);

		cv.beingV = true;

		for (Cv v : cv.adjL) {
			System.out.println("nb " + v);

			if (v.beingV) {
				System.out.println("There is backwared edge ");
				return;
			}

			if (!v.visited) {
				System.out.println("Visiting v recursicve " + v);
				v.visited = true;
				dfs(v);
			}

		}

		System.out.println("Vertex set flase ");
		cv.beingV = false;
		cv.visited = true;

	}

}

class Cv {

	int data;
	String name;
	boolean visited;
	boolean beingV;
	List<Cv> adjL;

	public Cv(int data) {
		this.data = data;
		this.adjL = new ArrayList<>();
	}

	@Override
	public String toString() {
		return Integer.toString(this.data);
	}

}