package com.logicsinjava;

public class MaxmumSumSubArray {
	
	public static void main(String[] args) {
		
		int[] arr = {-2, 2, 5, -11, 7};
		
		
		
		int currSum = 0;
		int maxSum = 0;
		
		
		for(int i=0; i < arr.length; i++) {
			
			currSum += arr[i];
			
			if(i <= 0)
				currSum = 0;
			
			if(currSum > maxSum) {
				maxSum = currSum;
			}
			
			
		}
		
		
		System.out.println(maxSum);
		
		
	}

}
