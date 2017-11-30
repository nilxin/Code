import talib
import numpy as np
import math
import pandas
import time 
import datetime 
from functools import reduce 

# init方法是您的初始化逻辑，如：设置交易佣金、滑点、基准
# context对象可以在任何函数之间传递
def init(context):
    # 定义全局变量股票池list
    context.stock_list = []
    #设置股票池为平安银行
    context.stock = "300104.SZ"   
    #交易费默认值为0.25‰
    context.set_commission(0.00025)
    #基准默认为沪深300
    context.set_benchmark("000300.SH")
   
#日或分钟或实时数据更新，将会调用这个方法
def hand_data(context, data_dict):
  # get_mavg-移动平均值
    # intervals 时间间隔，例如5
    # frequency 时间间隔的频率
  data_dict['000001.SZ'].get_mavg(5, frequency='day')

  # get_vwap-成交量加权平均价
    # intervals 时间间隔，例如5
    # frequency 时间间隔的频率默认为day（天），有两种类型day和minute
  data_dict['000001.SZ'].get_vwap(5, frequency='day')

  # is_st-是否ST股票
    # order_book_id 股票代码
  #判断平安银行是否为st股票
  reuslt = is_st('000001.SZ')

  # is_delisting-是否退市股票,is_delisting(order_book_id)
    # order_book_id 股票代码
    #判断平安银行是否退市
  reuslt = is_delisting ('000001.SZ')
  print(reuslt) 

  # was_st_or_delisting-是否发生过ST或退市
    # order_book_id 股票代码
   #判断平安银行否发生过st或退市
   reuslt =  was_st_or_delisting ('000001.SZ')
   print(reuslt)

  #开盘前事件函数，每天开盘前执行
def before_trade(context):
   #选取PE大于15的前20个股票的财务数据
   finance_df = get_fundamentals(
      query(
         fundamentals.equity_valuation_indicator.pe_ratio
      ).filter(
         fundamentals.equity_valuation_indicator.pe_ratio>15
      ).limit(20)
   )
   #手动更新股票池  
   context.stock_list = finance_df.columns.values
    
