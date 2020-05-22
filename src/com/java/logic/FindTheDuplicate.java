package com.java.logic;

import java.util.ArrayList;
import java.util.List;
public class FindTheDuplicate {
	public static void main(String[] args) {
		
		
		int[] arr = {4, 3, 2, 4, 1, 5, 7, 6, 3, 2};
		List<Integer> duplicateList = new ArrayList();
		
		for (int i =0;i<arr.length;i++) {


				int index = Math.abs(arr[i]-1);

				if(arr[index] < 0) {
					duplicateList.add(Math.abs(index+1));
				}else{
					arr[index] = 	-arr[index];
				}

		}


		System.out.println(duplicateList);
		

	}

}
