

def isValid(s):
    
    list = ["()", "{}"]
    
    stack = []
    
    for v in s:
        #print(v)
        if v == "(" or v == "{":
            stack.append(v);
        else:
            if len(stack) > 0:
                c = stack.pop()+""+v            
                if c not in list:
                    return False
                
            else:
                return False
    return True
        
        
print(isValid("(())"))
print(isValid("((){{()}})"))