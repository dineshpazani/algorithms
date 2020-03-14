#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue May  7 07:41:12 2019

@author: dinesh
"""

#Blute force methid
def findLongestSubstring(s): 
    
    maximum_length = 0
    for i in range(len(s)):
        maximum_length = max(maximum_length, helper(s, i))
    return maximum_length

def helper(string, start):
    seen = set()
    for i in range(start, len(string)):
        if string[i] not in seen:
            seen.add(string[i])
        else:
            return i - start
    return len(string) - start
        
        

#print(findLongestSubstring("abcabcbb"))
#print(findLongestSubstring("pwwkew"))
    
def permutate(arr):
    
    if arr == []:
        return [[]]
    per = []
    for idx, num in enumerate(arr):
        op = permutate(arr[:idx] + arr[idx+1:])
        per += map(lambda per : [num]+per, op)
    return per

#print(permutate([1, 2, 3, 4]))

def validparanths(p):

    
    stack = []
    s = set()
    s.add("{}")
    s.add("[]")
    s.add("()")
    for i in p:
       # print(i)
        if i == "{" or i == "[" or i == "(":
            stack.append(i)
        else:
            if stack.pop()+i not in s:
                return False
    return True

#print(validparanths("{{[({})]}}"))
    
def climbstairs(n):
    
    if n == 0:
        return 1    
    if n < 0:
        return 0    
    print(n)
    return climbstairs(n-1)+climbstairs(n-2)

#print(climbstairs(3))
#print(climbstairs(5))
    
def maximun_subarray_sum(n):
    
    if len(n) == 0:
        return 0
    
    
def generate_paranths(s):
    
    if s == 0:
        return []
    return generate_parens_helper('', s, 0)
    
    
    
def generate_parens_helper(curr, num_available, num_unclosed):
    
   # print(curr, num_available, num_unclosed)
    
    if num_available == 0:
        return [curr + ')' * num_unclosed]
    elif num_unclosed == 0:
        return generate_parens_helper(curr + '(', num_available - 1, num_unclosed + 1)
    return generate_parens_helper( curr + '(', num_available - 1, num_unclosed + 1) + generate_parens_helper(curr + ')', num_available, num_unclosed - 1)

print(generate_paranths(4))

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
























    
    
    
