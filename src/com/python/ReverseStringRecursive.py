
def reverse(s, k):
    
    if k == len(s):
        return;
        
    reverse(s, k+1);
    print(s[k])
    
def reverseNby2(s):
    
    if len(s) == 0:
        print(s)
        
    ls = list(s)
    l = len(s)-1
        
    for i in range(len(ls)//2):
        t = ls[i]
        ls[i] = ls[l-i]
        ls[l-i] = t
    
    print(ls)
        
    
#reverse("dinesh", 0)
reverseNby2("dinesh")