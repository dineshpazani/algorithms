#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue May  7 17:53:43 2019

@author: dinesh
"""

def fibanaci(n):
    
    if n <= 1:
        return n
    
    return fibanaci(n-1) + fibanaci(n-2)

print(fibanaci(5))