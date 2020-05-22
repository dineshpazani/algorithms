package com.logicsinjava;

public class Matrix90Rotation1 {

	public static void main(String[] args) {

		int[][] m = { { 1, 2, 3,4,5 }, { 6,7,8,9,10}, { 11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25} };

		int k = m.length;

		int[][] temp = new int[k][k];
		 k = k-1;

		 for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m[i].length; j++) {

					System.out.print(m[i][j]+" ");

				}
				System.out.println();
			}
		 
		 System.out.println();
		 
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
			
				temp[k - j][k - i] = m[i][j];

			}
		}

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {

				System.out.print(temp[i][j]+" ");

			}
			System.out.println();
		}

	}

}
