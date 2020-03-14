package com.ds;

import java.util.Scanner;

public class MazeApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int i = scan.nextInt();

		System.out.println(i);

		int[][] mazemap = new int[][] {

				{ 3, 1, 1, 1, 1, 1 },

				{ 0, 2, 0, 1, 1, 1 },

				{ 0, 1, 0, 0, 1, 1 },

				{ 0, 1, 1, 0, 1, 1 },

				{ 0, 0, 0, 0, 1, 1 },

				{ 1, 1, 1, 1, 1, 1 } };

		MazeSolver mz = new MazeSolver(mazemap, 1, 1);
		mz.findWayOut();

	}
}

class MazeSolver {

	private int[][] mazeMap;
	private boolean[][] visited;
	private int startPositionCol;
	private int startPositionRow;

	public MazeSolver(int[][] mazeMap, int startPositionCol, int startPositionRow) {
		this.mazeMap = mazeMap;
		this.visited = new boolean[mazeMap.length][mazeMap.length];
		this.startPositionCol = startPositionCol;
		this.startPositionRow = startPositionRow;
	}

	public void findWayOut() {

		try {
			dfs(startPositionRow, startPositionCol + 1);
			System.out.println("No solution found...");
		} catch (RuntimeException e) {
			System.out.println("Route found to exit!!!");
		}
	}

	private void dfs(int i, int j) {

		// if (mazeMap[i][j] != 1)
		System.out.println("Visiting i=" + i + ", j=" + j);

		if (this.mazeMap[i][j] == 3) {
			throw new RuntimeException(); // if we have found the 3 "exit" we break out the iteration with an excaption
		}

		int endOfMap = this.mazeMap.length - 1;

		if (this.visited[i][j] == true) { // if it has been already visited, we just skip it
			return;
		} else if (i < 0 || i >= endOfMap) { // out of map
			return;
		} else if (j < 0 || j >= endOfMap) { // out of map
			return;
		} else if (this.mazeMap[i][j] == 1) { // if it is a wall we cannot go in that direction
			return;
		} else {

			this.visited[i][j] = true; // set the current position to visited

			dfs(i + 1, j); // going down
			dfs(i, j + 1); // going right
			dfs(i, j - 1); // going left
			dfs(i - 1, j); // going up
		}
	}
}

/*
 * class MazeSolver {
 * 
 * int[][] mazemap; boolean[][] visited; int startposCol; int startposRow;
 * 
 * public MazeSolver(int[][] mazemap, int startposCol, int startposRow) {
 * 
 * this.mazemap = mazemap; this.visited = new
 * boolean[mazemap.length][mazemap.length]; this.startposCol = startposCol;
 * this.startposRow = startposRow; }
 * 
 * public void findWayOut() {
 * 
 * try { dfs(startposRow, startposCol + 1);
 * System.out.println("No Solutions found....");
 * 
 * } catch (Exception e) { System.out.println("Route found to exit...."); }
 * 
 * }
 * 
 * private void dfs(int i, int j) {
 * 
 * System.out.println(" Visiting i=" + i + ", j=" + j);
 * 
 * if (this.mazemap[i][j] == 3) { throw new RuntimeException(); }
 * 
 * int endofmap = this.mazemap.length - 1;
 * 
 * if (visited[i][j]) { return; } else if (i < 0 || i >= endofmap) { return; }
 * else if (j < 0 || j >= endofmap) { return; } else if (this.mazemap[i][j] ==
 * 1) { return; } else { this.visited[i][j] = true;
 * 
 * dfs(i + 1, j); dfs(j, j + 1); dfs(i, j - 1); dfs(i - 1, j);
 * 
 * }
 * 
 * }
 * 
 * }
 */