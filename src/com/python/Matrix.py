#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun May  5 12:46:25 2019

@author: dinesh
"""

def twoSum(nums, target):
    
        list = []
        map = {}
        for n in range(0, len(nums)):
            v = target-nums[n]    
            p = nums[n]
            if p in map.keys(): 
                list.append(map[p])
                list.append(n)
                return list
            else:
                map[v] = n
     
#print(twoSum([2,7,11,15], 9))


arr =  [[ 1,  2,  3,  4] ,
[ 5,  6,  7,  8 ],
[ 9, 10, 11, 12 ],
[13, 14, 15, 16 ]]


def matrixrotate(mat):
    
    N = len(mat[0])
     # Consider all squares one by one 
    for x in range(0, int(N/2)): 
          
        # Consider elements in group    
        # of 4 in current square 
        for y in range(x, N-x-1): 
              
            # store current cell in temp variable 
           # print(x, y)
            temp = mat[x][y] 
            
            
            
    for n in range(len(mat)):
        for m in range(len(mat[n])):
            print(mat[n][m], end=", ")
        print()
        
#matrixrotate(arr)
        
        


    
    

    


















