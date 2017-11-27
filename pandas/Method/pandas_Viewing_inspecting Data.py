#!/usr/bin/python
# -*- coding: UTF-8 -*-
''' VIEWING/INSPECTING DATA '''
#head、tail、shape、info、describe、value_count、apply
import pandas as pd
from scipy import stats as ss

data_url = "https://raw.githubusercontent.com/alstat/Analysis-with-Programming/master/2014/Python/Numerical-Descriptions-of-the-Data/data.csv"

df = pd.read_csv(data_url)

print "前五行:\n%s" % df.head()
print "后五行:\n%s" % df.tail()
print "前五行:\n%s" % df.head(n=10)

# Extracting column names 列
print df.columns
# Extracting row names or the index start=0, stop=79, step=1
print df.index
#  输出df的值
print df.values
# 统计第一列求sub值
print df.sub(df.ix[1], axis=1).head()

# 数据转置使用T方法，横竖坐标互换
print "Transpose data", df.T

# 我们需数据第一列的前10行
print df.ix[:, 0].head(n=10)

# 11到20行的前3列数据
print df.ix[10:20, 0:3]

#  Drop1、2列输出前五行,axis =0 舍弃行 ，axis=1 舍弃列
print df.drop(df.columns[[2, 3]], axis=1).head()

# 统计属性count mean std min 25% 50% 75% max
print(df.describe()).tail(1)

# Perform one sample t-test using 1500 as the true mean 设置均值为15000
print ss.ttest_1samp(a=df.ix[:, 'Abra'], popmean=15000)
print ss.ttest_1samp(a=df, popmean=15000)

# 设置基准值威15000
print df.gt(15000)

# 比较df是否相等
print df + df == df * 3  # 逐行逐值比较
print(df + df).equals(df * 2)
