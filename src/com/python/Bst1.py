#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Sep  1 04:25:04 2019

@author: dinesh
"""

class Node:
    
    def __init__(self,  data):
        self.data = data
        self.leftNode = None
        self.rightNode = None

class Bst:
    
    def __init__(self):
        self.rootNode = None
        
    def createNode(self, data):
        
        if self.rootNode is None:
            self.rootNode = Node(data)
        else:
            self.genNode(self.rootNode, data)
            
    def genNode(self, node, data):
        
        if node.data > data:
            
            if node.leftNode is not None:
                self.genNode(node.leftNode, data)
            else:
                node.leftNode = Node(data)
        else:
            
            if node.rightNode is not None:
                self.genNode(node.rightNode, data)
            else:
                node.rightNode = Node(data)
                
    def traverse(self):
        
        if self.rootNode is not None:            
            self.inOrderTraverse(self.rootNode)
            
    def inOrderTraverse(self, node):            
        if node is not None:      
            self.inOrderTraverse(node.leftNode)
            print(node.data)
            self.inOrderTraverse(node.rightNode)
            
class BstApp:
    
    bst = Bst()
    
    bst.createNode(80)
    bst.createNode(10)
    bst.createNode(20)
    bst.createNode(30)
    bst.createNode(40)
    bst.createNode(50)
    bst.createNode(60)
    bst.createNode(70)

    bst.traverse()
            
        
       
        
     
            
    
    
    