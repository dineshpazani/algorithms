#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue May  7 20:25:00 2019

@author: dinesh
"""


class Lrc:
    
    def __init__(self):
        self.root = None
        
    def add(self, key, value):
        if self.root == None:
            self.root = Node(key, value)
        else:
            cNode = self.root
            temp = None
            while cNode.next is not None:
                if(cNode.key == key):
                    print(key, temp.key)
                    ccNode = cNode
                    ccNode.data = value
                    temp.next = cNode.next
                    self.root = ccNode
                    break
                temp = cNode
                cNode = cNode.next
                
            cNode.next = Node(key, value)
                
    
            
    def getAll(self):
        
        if self.root is not None:
            self.printAll(self.root)
    
    def printAll(self, cNode):
        
        if cNode is not None:
            print(cNode.data)
            self.printAll(cNode.next)
            
class Node:
    
    def __init__(self, key, data):
        self.key = key
        self.data = data
        self.next = None
        
class App:
    
    lrc = Lrc()
    lrc.add(10, 100)
    lrc.add(20, 200)
    lrc.add(30, 300)
    lrc.add(40, 400)
    lrc.add(50, 500)
    lrc.add(30, 600)
    
    lrc.getAll()
    