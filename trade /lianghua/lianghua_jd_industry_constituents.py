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
   

#开盘前事件函数，每天开盘前执行
def before_trade(context):
   #选取PE大于15的前20个股票的财务数据
   finance_df = get_fundamentals(
      query(
         fundamentals.equity_valuation_indicator.pe_ratio_nobtest
      ).filter(
         fundamentals.equity_valuation_indicator.pe_ratio_nobtest>15
      ).limit(20)
   )
   #手动更新股票池  
   context.stock_list = finance_df.columns.values

#日或分钟或实时数据更新，将会调用这个方法
def hand_data(context, data_dict):
    pass
    
