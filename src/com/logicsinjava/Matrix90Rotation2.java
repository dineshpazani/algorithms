package com.logicsinjava;

public class Matrix90Rotation2 {

	public static void main(String[] args) {

		int[][] m = { 	{ 1, 2, 3, 4, 5 }, 
						{ 6, 7, 8, 9, 10 }, 
						{ 11, 12, 13, 14, 15 }, 
						{ 16, 17, 18, 19, 20 },
						{ 21, 22, 23, 24, 25 } };

		for (int i = 0; i < m.length; i++) {

			for (int j = 0; j < m.length; j++) {

				int temp = m[i][j];

			//	m[i][j] = m[j][i];

				m[j][i] = temp;
				
				System.out.println(m[i][j] +" "+temp);
			}

		}

		for (int i = 0; i < m.length; i++) {

			for (int j = 0; j < m[i].length; j++) {

				System.out.print(m[i][j] + " ");

			}

			System.out.println("");

		}

	}

}
