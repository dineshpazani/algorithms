class Node:
    
    def __init__(self, data):
        
        self.data = data
        self.leftNode = None
        self.rightNode = None
        
class BinarySearchTree:
    
    def __init__(self):        
        self.rootNode = None
    
    def insert(self, data):
        
        if self.rootNode is None:
            self.rootNode = Node(data)
        else:
            self.generateTree(self.rootNode, data)
    
    def generateTree(self, currentNode, data):
        
        if data < currentNode.data:
            if currentNode.leftNode is not None:
                self.generateTree(currentNode.leftNode, data)
            else:
                currentNode.leftNode = Node(data)
        else:            
            if currentNode.rightNode is not None:
                self.generateTree(currentNode.rightNode, data)
            else:
                currentNode.rightNode = Node(data)
    
    def traverse(self):
        
        if self.rootNode is not None :            
            self.traverseTree(self.rootNode)
    
    def traverseTree(self, currentNode):
        
        if currentNode is not None:
            self.traverseTree(currentNode.leftNode)
            print(currentNode.data)
            self.traverseTree(currentNode.rightNode)
            
            
class App:
    
    bst = BinarySearchTree()
    bst.insert(60)
    bst.insert(70)
    bst.insert(80)
    bst.insert(50)
    bst.insert(30)
    bst.insert(10)
    bst.insert(20)
            
        
    bst.traverse()
    
        
            