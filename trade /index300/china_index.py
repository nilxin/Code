#!/usr/bin/python
# -*- coding: UTF-8 -*-

import tushare as ts
import pandas as pd
import numpy as np

class Index300(object):
    
    def __init__(self,year,month):

        self.year = year
        self.month = month
        # 获取基础数据
        df = ts.get_h_data('000300', start=self.year+'-'+self.month+'-01', end=self.year+'-10-01', index=True)
        # analysisDataFrame获取要分析的值
        self.analysisDataFrame = df[['close','volume','amount']] 

    #计算上涨幅度
    def CountIndex(self):

        closeTailValue = self.analysisDataFrame.tail(1)[['close']].values
        closeHeadValue = self.analysisDataFrame.head(1)[['close']].values
        # 指数上涨百分比=(最后一行第1列的值-首行第1列的值)/首行第1列的值*100%
        indexPercent = (closeTailValue-closeHeadValue)/closeHeadValue*100
        # 打印大于8%的收益组合
        if indexPercent >= 7.0:
            print self.year+'-'+self.month+'-01:'+str(round(indexPercent[0][0],2))+'%'

if __name__ == '__main__':

    # ['2010','2011','2012','2013','2014','2015','2016','2017']
    for year in ['2010']:
        for month in ['01','02','03','04','05','06','07','08','09']:
            Index300(year,month).CountIndex()
