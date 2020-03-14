

def getperm(s):
    
    if len(s) == 0:
        return []
    elif len(s) == 1:
        return s
    else:
        l = []
        for i in range(len(s)):
            x = s[i]
            xs  = s[:i] + s[i+1:]
            for p in getperm(xs):
                l.append(x+p)
                
        return l
                
    


for i in getperm("ABCD"):
    print(i)


#def minimumCostPath(matrix,m,n): minimumCostPath = [[0 for x in range(n+1)] for y in range(m+1)] minimumCostPath[0][0] = matrix[0][0] for i in range (1,m+1): aboveCost = minimumCostPath[i - 1][0] minimumCostPath[i][0] = aboveCost + matrix[i][0] for j in range (1,n+1): leftCost = minimumCostPath[0][j - 1] minimumCostPath[0][j] = leftCost + matrix[0][j] for i in range (1,m+1): for j in range (1,n+1): leftCost = minimumCostPath[i - 1][j] aboveCost = minimumCostPath[i][j - 1] diagonalCost = minimumCostPath[i - 1][j - 1] minimumCostPath[i][j]= matrix[i][j] + min(leftCost,aboveCost,diagonalCost) return minimumCostPath[m][n] matrix = [ [ 2, 3, 4 ], [ 5, 9, 8 ], [ 7, 2, 1 ]] cost = minimumCostPath(matrix,2,2) print("Cost to reach : ",cost)