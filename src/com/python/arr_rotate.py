#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue May  7 22:18:33 2019

@author: dinesh
"""

arr = [[1, 2, 3, 4],
       [5, 6, 7, 8],
       [9, 10, 11, 12],
       [13, 14, 15, 16]
       ]

def rotate(arr):
    
    for i in arr:
        for j in i:
            print(j, end=" ")
        print()
        
def getVal(arr, i, j):
    return arr[i][j]

def updateVal(arr, i, j, val):
    arr[i][j] = val
    
    
            
#rotate(arr)
# Sorting dictionary     
dic = {'a': 5, 'd': 2, 'c':10}

for k,v in dic.items():
    print(v)
    
def sortdic(dic):
    
    sdic = sorted(dic.items() , key = lambda  t :t[0] )    
    print(sdic)
    sdic = sorted(dic.items() , key = lambda  t :t[1] )
    print(sdic)
    
sortdic(dic)
    
    
    

