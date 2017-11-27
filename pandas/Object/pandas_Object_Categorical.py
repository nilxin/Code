#!/usr/bin/python
# -*- coding: UTF-8 -*-

from pandas import Categorical

#按顺序获取最长序列，支持str或者int
print Categorical([1, 2, 3, 1, 2, 4])
print Categorical(['a', 'b', 'c', 'a', 'b', 'c'])

a = Categorical(['a','b','c','a','b','c'], ['c', 'b', 'a'],ordered=True)

print a.min()