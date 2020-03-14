package com.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraApp {

	public static void main(String[] args) {

		Dv v0 = new Dv("A");
		Dv v1 = new Dv("B");
		Dv v2 = new Dv("C");

		v0.adjl.add(new Edge(1, v0, v1));
		v0.adjl.add(new Edge(1, v0, v2));
		v1.adjl.add(new Edge(1, v1, v2));

		DA da = new DA();
		da.computePath(v0);

		System.out.println(da.getShortPath(v2));

	}

}

class DA {

	public void computePath(Dv sv) {
		sv.distance = 0;
		PriorityQueue<Dv> pq = new PriorityQueue<>();
		pq.add(sv);

		while (!pq.isEmpty()) {
			Dv av = pq.poll();

			for (Edge edge : av.adjl) {

				Dv v = edge.tV;
				double nD = av.distance;

				if (nD < v.distance) {
					pq.remove();
					v.distance = nD;
					v.predeccssor = av;
					pq.add(v);
				}

			}

		}
	}

	public List<Dv> getShortPath(Dv tv) {

		List<Dv> shortPath = new ArrayList<>();

		for (Dv v = tv; v != null; v = v.predeccssor) {
			shortPath.add(v);
		}

		Collections.reverse(shortPath);
		return shortPath;
	}
}

class Dv implements Comparable<Dv> {

	String name;
	boolean visited;
	List<Edge> adjl;
	Dv predeccssor;
	double distance = Double.MIN_VALUE;

	public Dv(String name) {
		this.name = name;
		this.adjl = new ArrayList<>();
	}

	public void addNeighbour(Edge edge) {
		this.adjl.add(edge);
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Dv oV) {

		return Double.compare(this.distance, oV.distance);
	}

}

class Edge {

	double weight;
	Dv sV;
	Dv tV;

	public Edge(double weight, Dv sv, Dv tv) {
		this.weight = weight;
		this.sV = sv;
		this.tV = tv;
	}

}
