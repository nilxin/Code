import talib
import numpy as np
import math
import pandas
import time 
import datetime 
from functools import reduce 

def init(context):
	pass

import talib
import numpy as np
import math
import pandas
import time 
import datetime 
from functools import reduce 

#init方法是您的初始化逻辑，context对象可以在任何函数之间传递
def init(context): 
    #滑点默认值为2‰
    context.set_slippage(0.002)
    #交易费默认值为0.25‰
    context.set_commission(0.00025)
    #基准默认为沪深300
    context.set_benchmark("000300.SH")
    #调仓周期
    task.weekly(option_stock, weekday=2, time_rule=market_open(minute=5))
    #下面为几个定时执行的策略代码，可放开注释替换上面的执行时间
    #task.daily(option_stock, time_rule=market_close(minute=5))  #每天收盘前5分钟运行
    #task.weekly(option_stock, weekday=2, time_rule=market_open(minute=5))  #每周周二开盘后5分钟运行
    #task.monthly(option_stock, tradingday=1 ,time_rule=market_open(minute=5))  #每月第1个交易日开盘后5分运行

#每天开盘前进行选股    
def before_trade(context):
    context.stock_list = choose_stock_finance()
    
#日或分钟或实时数据更新，将会调用这个函数
def handle_data(context,data_dict):
    pass

#操作股票
def option_stock(context,data_dict):
    stock_list = context.stock_list
    sell_stock(context,stock_list,data_dict)  #先卖出股票再买入
    for stock in stock_list:
         buy_stock(context,stock)  #买入股票

#策略买入信号函数
def buy_stock(context, stock):
    context.percentage = 1  #设置单支股票最大买入仓位
    stock_buy_num = 10 #最多买入股票数量
    stock_percentage = 0.99/stock_buy_num  #每支股票买入的最大仓位
    if len(context.portfolio.positions) < stock_buy_num:
       if stock_percentage > context.percentage:  #设置单支股票最大买入仓位
          stock_percentage = context.percentage   #更换买入仓位
       order_percent(stock, stock_percentage)     #买入股票

#策略卖出信号函数
def sell_stock(context,stock_list,data_dict):
    for stock in list(context.portfolio.positions.keys()):
        if not (stock in stock_list):
           order_target_value(stock,0)  #如果不在股票列表中则全部卖出

# 高转送可能性股票
# pe_ratio_ttm 市盈率小于15
# market_cap_2 总市值超过10亿
# book_value_per_share 每股净资产BPS大于5
# earnings_per_share 基本每股收益EPS大于1
# inc_profit_before_tax 利润总额(同比增长率) 50%
def choose_stock_finance():
    dataframe = get_fundamentals(
     query(
         fundamentals.equity_valuation_indicator.market_cap_2, fundamentals.financial_analysis_indicator.book_value_per_share, fundamentals.financial_analysis_indicator.earnings_per_share, fundamentals.financial_analysis_indicator.inc_profit_before_tax, fundamentals.equity_valuation_indicator.pe_ratio_ttm
     ).filter(
         fundamentals.equity_valuation_indicator.market_cap_2 > 1000000000
     ).filter(
         fundamentals.financial_analysis_indicator.book_value_per_share > 5
     ).filter(
         fundamentals.financial_analysis_indicator.earnings_per_share > 1
     ).filter(
         fundamentals.financial_analysis_indicator.inc_profit_before_tax > 50
     ).filter(
         fundamentals.equity_valuation_indicator.pe_ratio_ttm < 15
     )
    )
    stock_list = dataframe.columns.values
    return stock_list

  
