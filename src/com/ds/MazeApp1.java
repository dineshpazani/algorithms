package com.ds;

public class MazeApp1 {

	public static void main(String[] args) {

		int[][] mazemap = new int[][] { { 1, 1, 1, 1, 1 }, { 1, 2, 0, 1, 1 }, { 1, 1, 0, 1, 1 }, { 1, 1, 0, 3, 1 },
				{ 1, 1, 1, 1, 1 } };

		MazeSolver1 m = new MazeSolver1(mazemap, 1, 1);
		m.findoutway();

	}

}

class MazeSolver1 {

	int[][] mazemap;
	boolean[][] isvisited;
	int startposrow;
	int startposcol;

	public MazeSolver1(int[][] mazemap, int startposrow, int startposcol) {
		this.mazemap = mazemap;
		this.isvisited = new boolean[mazemap.length][mazemap.length];
		this.startposrow = startposrow;
		this.startposrow = startposcol;
	}

	public void findoutway() {

		try {

			dfs(startposrow, startposcol + 1);
			System.out.println("No Way.....");

		} catch (Exception e) {
			System.out.println("way found....");
		}
	}

	private void dfs(int i, int j) {

		System.out.println(" i=" + i + " j=" + j);

		if (this.mazemap[i][j] == 3)
			throw new RuntimeException();

		int endofmap = mazemap.length - 1;

		if (isvisited[i][j] == true) {
			throw new RuntimeException();
		} else if (i <= 0 || i >= endofmap) {
			return;
		} else if (j <= 0 || j >= endofmap) {
			return;
		} else if (this.mazemap[i][j] == 1) {
			return;
		} else {
			isvisited[i][j] = true;

			dfs(i + 1, j);
			dfs(i, j + 1);
			dfs(i - 1, j);
			dfs(i, j - 1);

		}

	}

}
