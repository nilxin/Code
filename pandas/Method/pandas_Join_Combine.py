#!/usr/bin/python
# -*- coding: UTF-8 -*-
''' Join/Combine'''
import pandas as pd
import numpy as np
data_url = "https://raw.githubusercontent.com/alstat/Analysis-with-Programming/master/2014/Python/Numerical-Descriptions-of-the-Data/data.csv"

dframe2 = pd.read_csv(data_url)
dframe1 = dframe2
print '原始%s\n' % (dframe2)
#append 属性将dframe2加入到dframe1中，158 rows，5columns
print '将dframe2加入到dframe1中\n', dframe1.append(dframe2)
#concat 属性指定从dframe1中的axis=1加入行，axis=0加入列，79row，10columns
print '从dframe1中的axis=1列中将两个df合并为一个\n', pd.concat([dframe1,dframe2],axis=1)
#join 属性 how属性可为 on=None 用于显示指定列名（键名），left、right、outer、inner
# print '通过jonin实现两个df的拼接\n', dframe1.join(dframe2,on='Abra',left_on=)
