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

        # analysisDataFrame获取要分析的值，将数据机型切片，获取需要的列open、close、volume、price_change，并将数据切分为：
            
        analysis_first = ts.get_hist_data('300470','2016-01-01','2016-03-31')
        analysis_secord = ts.get_hist_data('300470','2016-04-01','2016-07-04')
        analysis_three = ts.get_hist_data('300470','2016-07-05','2016-12-31')

        self.analysis_first = analysis_first.loc[:,['open','close','volume','price_change']]
        self.analysis_secord = analysis_secord.loc[:,['open','close','volume','price_change']]
        self.analysis_three = analysis_three.loc[:,['open','close','volume','price_change']]
        self.analysis_concat_1A2 = self.analysis_secord.append(self.analysis_first)
        print self.analysis_concat_1A2

    #交易量分析
    def tradeVolume(self):
        
        

        # analysis_first 在01-01到03-31日，分析volume日平均量
        self.analysis_first_volume_mean = self.analysis_first['volume'].mean()

        # analysis_secord 在04-01到07-04日
            # 计算平均成交量
            # 大于volume日均量、最大量的日期
            # 成交量大于日均量前10的成交日
        print '04-01到07-04的平均成交量：%s\n' % (self.analysis_secord['volume'].mean())

        self.analysis_secord_averagetrade = self.analysis_secord[self.analysis_secord.volume>self.analysis_first_volume_mean]
        print '04-01到07-04大于%s日均成交量的天：%s\n' % (self.analysis_secord['volume'].mean(),self.analysis_secord_averagetrade)

        print '04-01到07-04日大于日均成交量的前10成交日%s\n' % (self.analysis_secord_averagetrade.sort_values(by=['volume']).tail(10))

        print '04-01到07-04登记日趋势百分比：%s %% \n' % ( round( ((self.analysis_concat_1A2.head(1)[['close']].values- self.analysis_concat_1A2.tail(1)[['close']])/self.analysis_concat_1A2.head(1)[['close']].values*100).values[0][0],2) )

        
        # analysis_three 在07-05到-12-31日，大于中的最大量的日期

    	

if __name__ == '__main__':

    lianghua_trade_300470().tradeVolume()

