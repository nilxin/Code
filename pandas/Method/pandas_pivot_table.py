#!/usr/bin/python
# -*- coding: UTF-8 -*-
''' pivot_table'''
import pandas as pd
import numpy as np
'''
DataFrame.pivot_table(data, values=None, index=None, columns=None, 
aggfunc='mean', fill_value=None, margins=False, dropna=True, margins_name='All'
'''
df = pd.DataFrame({'A' : ['one', 'one', 'two', 'three'] * 3,
'B' : ['A', 'B', 'C'] * 4,'C' : ['foo', 'foo', 'foo', 'bar', 'bar', 'bar'] * 2,
'D' : np.random.randint(12),'E' : np.random.randint(12)})
print '原始值\n',df
#将DataFrame转换成一个table视图，以D作为数值域，A,B为行，C为列的数据视图
print '以D作为数值域，A,B为行，C为列的透视表\n', pd.pivot_table(df,index=['A', 'B'], columns=['C'], values='D')
table = pd.pivot_table(df,index=['A', 'B'], columns=['C'], values='D')
#aggfunc 可以跟一个或多个计算能力函数，如果是多个则可以使用[]进行分别计算。
    #aggfunc单个计算的方式：aggfunc=np.sum对透视表中指定列进行sum操作，可在手册中查询numpy的属性
print '指定C列数据进行sum计算\n', pd.pivot_table(df,index=['A', 'B'], columns=['C'], values='D', aggfunc=np.sum)
    #aggfunc多个计算的方式：aggfunc=np.mean,len对透视表中指定列进行mean和len的操作
print '指定C列数据进行mean、len计算\n', pd.pivot_table(df,index=['A', 'B'], columns=['C'], values='D', aggfunc=[np.mean,len])
    #aggfunc传入一个字典作为计算方式，可完成指定列不同方法的计算
print '对指定列进行不同方法的计算\n', pd.pivot_table(df,index=['A','B'], columns=['C'], aggfunc={'D':np.sum, 'E':[np.sum]}, fill_value=0)
#fill_value可将透视表中的table视图的值由NaN转换为任意数值
print '使用fill_value属性将视图中NaN数据替换成希望的值\n', pd.pivot_table(df,index=['A', 'B'], columns=['C'], values='D', fill_value=30)
#margins 属性，用于查看各列的总和数据，默认为FALSE
print '输出一个视图的总和值（实现如：小计、总计）\n', pd.pivot_table(df,index=['A', 'B'], columns=['C'], values='D', fill_value=30, margins=True)
#dropna 属性，default True,
print '原始table\n',table
print '在原始table增加dropna属性为False\n', pd.pivot_table(df,index=['A', 'B'], columns=['C'], values='D', dropna=False)

#高级透视表过滤
#指定index队列中的某个值，比如：在table中只显示A列中为one的数据集
print 'table中只显示A列中为one的数据集\n', table.query('A == ["one"]')




