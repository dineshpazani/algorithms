#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue May  7 20:52:51 2019

@author: dinesh
"""


def maze(arr):
    
    barr = [[0 for x in range(len(arr))] for y in range(len(arr))] 
    
    traverse(arr, barr, 1, 2)
    print("No route found")
    
    for i in barr:
        for j in i:
            print(j, end=" ")
        print()

def traverse(arr, barr, sr, sc):
    
    if arr[sr][sc] == 3:
        print(sr, sc)
        return True    
    
    if barr[sr][sc] == 1:
        return
    elif sr < 0 or sr >= len(arr)-1:
        return
    elif sc < 0 or sc >= len(arr)-1:
        return
    elif arr[sr][sc] == 1:
        return
    else:        
        barr[sr][sc]  = 1
        print(sr, sc)
        
        traverse(arr, barr, sr+1, sc)
        traverse(arr, barr, sr, sc+1)
        
        traverse(arr, barr, sr, sc-1)
        traverse(arr, barr, sr-1, sc)
        
arr = [[0, 0, 0, 1, 0],
       [0, 1, 2, 1, 0],
       [0, 1, 1, 1, 0],
       [0, 0, 0, 3, 0],
       [1, 1, 1, 1, 1]]

maze(arr)