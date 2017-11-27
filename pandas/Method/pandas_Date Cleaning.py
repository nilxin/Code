#!/usr/bin/python
# -*- coding: UTF-8 -*-
''' DATA CLEANING '''
# '''isnull() 、notnull()、dropna()、dropna(axis=1)、dropna(axis=1,thresh=n)、fillna(x)、s.fillna(s.mean())
# s.astype(float)、s.replace(1,'one')、s.replace([1,3],['one','three'])、df.rename(columns=lambda x: x + 1)
# df.rename(columns={'old_name': 'new_ name'})、df.set_index('column_one') 、df.rename(index=lambda x: x + 1)
#  '''
import pandas as pd
import numpy as np

dates=pd.date_range('20170729',periods=6)
df = pd.DataFrame( np.random.randn(6,4),index=dates,columns=list('ABCD') )

#初始化FrameDate
print '原FrameDate\n',df
#isnull检查Frame是否有空值，返回Boolean Arrray isnull()
print '检查空值\n',df.isnull()
#notnull 检查Frame是否不为空，返回Boolean Arrray notnull()
print '检查空值\n',df.notnull()
#drops 将所有包含为空的行删除，返回一个仅含非空数据和索引值的 Series。
    #axis 参数可以指定列，axis=1，第一列;
    #how 参数any/or，如果how='all'全为NA时抛弃该列；默认为any
    #thresh 参数，thresh=3，会在一行中至少有 3个非 NA值时将其保留；
print '将所有包含为空的行删除\n',df.dropna(how='any',thresh=None)
#fillna(x) 可以用任意数字替换NaN
df1 = pd.DataFrame([{'col1':1, 'col2':1}, {'col1':1, 'col2':2}])
df2 = pd.DataFrame([{'col1':2, 'col3':11}, {'col1':2, 'col3':33}])
data = pd.merge(left=df1, right=df2, how='left', left_on='col1', right_on='col1')
    #method pad最近前一个数据代替nan、bfill 用后一个数据代替nan、df.mean()平均数或者统计量代替nan
    #可以选择某一列进行替换操作，如：col3
print data.fillna(data.mean()['col3'])
#astype(float) 可对DataFrame某一列进行数据格式转换
print '将某列数据进行格式转换，转换成时间格式\n', data['col3'].astype(np.datetime64)
#dtypes 可以查看每列的数据类型
print '查看一个FrameData每列数据的类型\n',data.dtypes
#replace 参数1：替换索引，参数2：替换值；
    #如果是Series，参数可以使数值、可以使列表、可以是字典
    #如果是FrameData，也可以直接替换
print '直接替换data中值，将col3中的值11替换为20\n', data.replace(11,20)
    #FrameData中指定col2列进行替换
print '指定col2中1的值替换20\n',data['col2'].replace(1,20)
    #FrameData中指定多列的多个值进行替换
print '指定col1、col2列中数值1替换为20\n',data[['col1','col2']].replace(1,20) 
    #FrameData中多个列不同的值替换一个相同值，可以是使用字典方法表示所有需要被替换的值
print '使用字典方法将要替换的值统一替换成缺省值\n',data.replace({'col1':1,'col2':2},np.nan)
data1=data.replace({'col1':1,'col2':2},np.nan)
print '将NaN替换为10\n', data1.fillna(10)
#rename 