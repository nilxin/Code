#!/usr/bin/python
# -*- coding: UTF-8 -*-
# 分析 日机密封 300470 分析除权前后的放量情况，看是否可以找到规律
    	# 公告日 2016-04-14
    	# 登记日 2016-07-04
    	# 除权日 2016-07-05
# 计算01-01到04-01日，日平均量，最大量
# 分析1：在04-01到07-04日，大于日均量、最大量的日期
# 分析2：在07-05到-12-31日，大于分析1中的最大量的日期
import tushare as ts
import pandas as pd
import numpy as np
import datetime


class lianghua_trade_300470(object):
    
    def __init__(self):

        # 获取基础数据
        df = ts.get_hist_data('300470','2016-01-01','2016-12-31')
        print df.index.values[0].encode("utf-8")
        print datetime.datetime.strptime(df.index.values[0].encode("utf-8"),'%Y-%M-%D')
        # analysisDataFrame获取要分析的值，将数据机型切片，获取需要的列open、close、volume、price_change，并将数据切分为：
        	# analysis_first 在01-01到03-31日，分析volume日平均量
        	# analysis_secord 在04-01到07-04日，大于volume日均量、最大量的日期
			# analysis_three 在07-05到-12-31日，大于中的最大量的日期
        self.analysis_first = df.loc['2016-01-04':'2016-03-31',['open','close','volume','price_change']]
        print 'analysis_first:%s\n' % (self.analysis_first)

    #交易量分析
    def tradeVolume(self):

    	pass

if __name__ == '__main__':

    lianghua_trade_300470().tradeVolume()

