#!/usr/bin/python
# -*- coding: UTF-8 -*-
import pandas as pd
import numpy as np

dates=pd.date_range('20170729',periods=6)
df = pd.DataFrame(np.random.randn(6,4),index=dates,columns=list('ABCD'))

''' DataFrame类  '''

''' T method '''
#Transpose index and columns
print '反转\n%s\n' % (df.T)

''' SELECTION '''
''' at/iat loc/iloc method '''
#Fast label-based scalar accessor 切片方式 类似于Python中的list
#at的使用方法与loc类似，但是比loc有更快的访问数据的速度，而且只能访问单个元素，不能访问多个元素。
print '使用行切片2-3行\n%s\n' % (df[1:3])
#根据索引进行切片
print '使用索引切片\n%s\n' % (df['2017-7-29':'2017-7-30'])
#筛选D序列大于0或者组合查询条件
print '序列D大于0\n%s\n' % ( df[df.D>0] )
print '组合条件实现判断D序列大于0和C序列小于0同时满足条件\n%s\n' % ( df[ (df.D>0)&(df.C<0) ])
#我们只需要A和B列数据，而D和C列数据都是用于筛选
print '我们只需要A和B列数据，而D和C列数据都是用于筛选\n%s\n' % ( df[['A','B']][(df.D>0)&(df.C<0)] )
#loc方法
print '选择索引位置为1的一行数据\n%s\n' % (df.loc[dates[1]])
#loc方法选择多个数据列
print '选择多个数据列\n%s\n' % (df.loc[:,['A','B']])
#loc方法假如我们要选择的是一个局部数据，是行和列的交叉区域
print '假如我们要选择的是一个局部数据，是行和列的交叉区域\n%s\n' % (df.loc['2017-7-29':'2017-7-30',['A','B']])
#at方法专门用于获取某个值 用法和loc类似但速度远高于loc,类似写法df.loc[dates[0],'A']
print 'at方法专门获取某个值\n%s\n' % (df.at[dates[0],'A'])
#使用iloc方法来像操作array（数组）一样对DataFrame进行切片操作,这种方法得到的返回值是一个series数据
print '提取第4行数据\n%s\n' % (df.iloc[3])
#iloc方法，返回4-5行，1-2列数据
print '返回4-5行，1-2列数据\n%s\n' % (df.iloc[3:5,0:2])
#iloc方法，我们也可以提取不连续行和列的数，如：取124行，12列
print '我们也可以提取不连续行和列的数，如：取124行，12列\n%s\n' % (df.iloc[[1,2,4],[0,2]]) 
#iloc方法，提取几行数据的所有列 df.iloc([:,2:3])
print '提取2-3行中的所有列\n%s\n' % (df.iloc[1:3,:])
#iloc方法，取第2行第2列的这个数
print '取第2行第2列的这个数，也可以使用iloc\n%.2f\n' % ( df.iloc[1,1] )
#提取某个数据时也可以使用iat,效率高于iloc
print '取第2行第2列的这个数，iat方法效率更高\n%.2f\n' % ( df.iat[1,1] ) 

''' axes method '''


















