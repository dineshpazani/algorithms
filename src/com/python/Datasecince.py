#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Sep 15 11:50:58 2019

@author: dinesh
"""

import matplotlib
import numpy as np
import matplotlib.pyplot as plt
import sqlite3


x = np.linspace(0, 10, 100)

plt.plot(x, np.sin(x))
plt.plot(x, np.cos(x))

plt.show()

