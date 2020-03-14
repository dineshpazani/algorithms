#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed May  8 20:36:09 2019

@author: dinesh
"""

class SLL:
    
    def __init__(self):
        self.root = None
        self.size = 0
        
    def add(self, key, value):
        if self.root is None:
            self.root = Node(key, value)
            self.size += 1
        else:
            self.genNode(self.root, key, value)
    
    def genNode(self, cNode, key, value):
        if cNode.next is not None:   
            self.genNode(cNode.next, key, value)
        else:
            cNode.next = Node(key, value)
            self.size += 1
            
    def getAll(self):
        cNode = self.root
        while cNode is not None:
            print(cNode.key, cNode.value)
            cNode = cNode.next
            
    def midList(self):
        
        if self.root is not None:
            return self.findMid(self.root)
            
    def findMid(self, cNode):
        
        s = cNode
        f = cNode
        
        while f is not None and f.next is not None:
            s = s.next
            f = f.next.next
        return s
    
    def removeList(self, key):
        
        cNode = self.root
        while cNode is not None:
            if cNode.key == key:
                print("yes")
                cNode = cNode.next
            else:
                cNode = cNode.next
        self.root =  cNode
        

class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None
        
        
class App:
    
    s = SLL()
    s.add(10, 100)
    s.add(20, 200)
    s.add(30, 300)
    s.add(40, 400)
    s.add(50, 500)
    s.add(60, 600)
    
    s.getAll()
    print("Size of the list is ",s.size)
    m = s.midList()
    print("Mid of the liked list", m.key, m.value)
    
    s.removeList(30)
    s.getAll()

        
        