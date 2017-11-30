#!/usr/bin/python
# -*- coding: UTF-8 -*-
''' Index'''
# FILTER, SORT, & GROUPBY Method
import pandas as pd
import numpy as np

dates=pd.date_range('20170729',periods=6)
df = pd.DataFrame(np.random.randn(6,4),index=dates,columns=list('ABCD'))
#原始值	
print '原始值',df
#Rows where the column col is greater than 0.5
print '小于0.5',df[df[1:3] < 0.5]
#Rows where 0.7 > col > 0.5 value在两个数之间
print '大于0.5小于0.7',df[ (df[1:3] > 0.5) & (df[1:3] < 0.7) ]
#Sort values by col1 in ascending order 指定列按升序排列，asceding默认为false，当asceding默认为true时按降序排列
print df.sort_values('A',ascending=True) 
# Returns a groupby object for values from one column，它使你能以一种自然的方式对数据集进行切片、切块、摘要等操作。
df = pd.DataFrame({'key1':['a', 'a', 'b', 'b', 'a'],
    'key2':['one', 'two', 'one', 'two', 'one'],
    'data1':np.random.randn(5),
    'data2':np.random.randn(5)})
print '原始值',df
    #假设你想要按key1进行分组，并计算data1列的平均值
#     data1     data2     key1 key2
# 0 -0.410673  0.519378    a  one
# 1 -2.120793  0.199074    a  two
# 2  0.642216 -0.143671    b  one
# 3  0.975133 -0.592994    b  two
# 4 -1.017495 -0.530459    a  one
#指定列分组key1求平均值
grouped_key1 = df['data1'].groupby(df['key1'])
print '平均值',grouped_key1.mean()
#多次分组（key1、key2)求平均值
grouped_key1_key2 = df['data1'].groupby([df['key1'], df['key2']])
print '平均值',grouped_key1_key2.mean()
#将DataFrame转换成一个Series
print '将DataFrame转换成一个Series\n',grouped_key1_key2.mean().unstack()
#GroupBy对象支持迭代，可以产生一组二元元组（由分组名和数据块组成）
for name, group in df.groupby('key1'):
    print '得到DataFrame下的name与group\n',(name, group)
    break;










