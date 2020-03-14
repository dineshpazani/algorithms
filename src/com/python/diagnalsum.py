

arr = [
       [11, 2, 4],
       [4, 5, 6],
       [10, 8, -12]
       ]

def diagnoalsum(arr):
    
    a = 0
    
    r1 = 0
    r2 = 0
    
    for i in range(len(arr)):
        k = arr[i]
        
        for j in range(len(k)):
         #   print(arr[i][j])
            
            
            if j == a:
                r1 += arr[i][j]
                
           # print(j, (len(arr)-1)-a)
            if j ==  (len(arr)-1)-a:
                r2 +=  arr[i][j]
               
        a += 1
                
   
    print(r1- r2, r2-r1)
    if r1-r2 > r2-r1:
        return r1-r2        
    else:        
        return r2-r1
                
            

#print(diagnoalsum(arr))            
        
#Candle problem:
        
    
arr = [18, 90, 90, 13, 90, 75, 90, 8, 90, 43]

def birthdayCakeCandles(arr):
    count = 0
    temp = 0
    pv = 0
    for i in arr:
      #  print(i)
        if temp <= i:
            if pv != i:
                pv = i
                count = 0
            count += 1
            temp = i
    return count

#print(birthdayCakeCandles(arr))
    
#Sherlock valid string:
    
s = "aabbccddeefghi"

def isvalid(s):
    
    map = {}
    res = "YES"
    
    for v in s:
     #   print(v)
        if v in map.keys():
            map[v] = map[v]+1
        else:
            map[v] = 1
            
    list = []
    for k, v in map.items():
        print(k, v)
        list.append(v)
        
    list.sort()

    temp = list[0]
    for l in list:
        print(l, temp, l-temp)
        if (l-temp)>1:
            res = "NO"
        temp = l
    return res

#print(isvalid(s))
    
def weightedUniformStrings(s, queries):

    map = {}
    lm = {}
    
    r = []
    
    for v in s:
        
        if v in map.keys():
            map[v] = map[v]+1
        else:
            map[v] = 1
            
    i = 1
    for a in range(ord('a'), ord('a')+len(map)):
        lm[chr(a)] = i
        i += 1
    

    for k, v in map.items():
        map[k] = v*lm[k]
        
     
    for x in queries:
        
        if x in map.values():
            print("YES")
            r.append("Yes")
        else:
            if x in lm.values():
                print("YES")
                r.append("Yes")
            else:
                print("NO")
                r.append("No")
                
    return r
    
        
        

#weightedUniformStrings("abccddde", [1, 3, 12, 5, 9, 10])
weightedUniformStrings("aaabbbbcccddd", [9, 7, 8, 12, 5])
    
    
    
    
    
    
    
    
    
    
    