import queue

class Vertax:
    
    def __init__(self, data):
        self.data = data
        self.isvisited = False
        self.neighboutList = []
        
    
class Bst:
        
    def bfs(self, v):
        
        q = queue.Queue(maxsize=20)
        v.isvisited = True
        q.put(v)
        
        while True:
            
            if q.empty():
                return;
            
            nq = q.get()
            print(nq.data)
            
            for n in nq.neighboutList:
                if  n.isvisited == False:
                    n.isvisited = True;
                    q.put(v)

class App:
    
    v1 = Vertax(1)
    v2 = Vertax(2)
    v3 = Vertax(3)
    v4 = Vertax(4)
    v5 = Vertax(5)
    
    v1.neighboutList.append(v2)
    v1.neighboutList.append(v4)
    v4.neighboutList.append(v5)
    v2.neighboutList.append(v3)
                    
        
    bfs = Bst()
    bfs.bfs(v1)
    