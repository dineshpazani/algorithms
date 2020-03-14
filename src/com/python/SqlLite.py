#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Sep 15 12:32:06 2019

@author: dinesh
"""

import sqlite3


connection = sqlite3.Connection("/home/dinesh/titanic.db")


cursor = connection.cursor()

table = """
        CREATE TABLE classroom (        
        student_id INTEGER PRIMARY KEY,
        name VARCHAR(20),
        math INTEGER,
        phy INTEGER,
        chi INTEGER
        );
        """
        
#cursor.execute(table)

#cursor.commit()
        
query = """ select * from classroom;"""

cursor.execute(query) 

r = cursor.fetchall()

for i in r:
    print(i)

connection.close()