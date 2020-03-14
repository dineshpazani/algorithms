package com.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DfsApp {

	public static void main(String[] args) {

		DVertax v1 = new DVertax(10);
		DVertax v2 = new DVertax(20);
		DVertax v3 = new DVertax(30);
		DVertax v4 = new DVertax(40);
		DVertax v5 = new DVertax(50);

		List<DVertax> list = new ArrayList<>();

		v1.nb.add(v2);
		v1.nb.add(v3);
		v3.nb.add(v4);
		v4.nb.add(v5);
		v1.nb.add(v1);

		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);

		Dfs1 dfs = new Dfs1();
		dfs.dfs(list);

	}

}

class Dfs1 {

	private Stack<DVertax> s;

	public Dfs1() {
		s = new Stack<>();
	}

	public void dfs(List<DVertax> lv) {

		for (DVertax v : lv) {
			if (!v.isv) {
				v.isv = true;
				dfsWithStack(v);
			}
		}

	}

	private void dfsWithStack(DVertax v) {
		this.s.add(v);
		v.isv = true;

		while (!s.isEmpty()) {
			DVertax dv = this.s.pop();
			System.out.println(dv);

			for (DVertax l : dv.nb) {
				if (!l.isv) {
					l.isv = true;
					s.add(l);
				}
			}
		}
	}

}

class DVertax {

	int data;
	boolean isv;

	List<DVertax> nb;

	public DVertax(int data) {
		this.data = data;
		this.nb = new ArrayList<>();
	}

	@Override
	public String toString() {
		return Integer.toString(this.data);
	}

}