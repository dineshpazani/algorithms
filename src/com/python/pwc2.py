def list_comprehension(arr):
    
    # Complete the function
    #
    # Hint: Do NOT use any loops
    
    
    
    print([[n*n for n in group if n > 0] for group in arr])
    
    
    return arr



# DO NOT EDIT BELOW...
list_comprehension([[-1, 1, 2, -2, 6], [3, 4, -5]])