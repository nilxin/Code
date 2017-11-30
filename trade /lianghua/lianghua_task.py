import talib
import numpy as np
import math
import pandas
import time 
import datetime 
from functools import reduce 

# init方法是您的初始化逻辑
def init(context):

    context.stock = "000001.SZ"   #设置股票池为平安银行
    # Task-计划任务事件对象
     #下面为几个定时执行的策略代码，可放开注释替换上面的执行时间time_rule
    # market_close:收盘前, market_open:开盘后
    # task.(daily\weekly\monthly) 定义每天、每月、每周
    # hour\minute
    task.daily(option_stock, time_rule=market_close(minute=5))  #每天收盘前5分钟运行
    task.weekly(option_stock, weekday=2, time_rule=market_open(minute=5))  #每周周二开盘后5分钟运行
    task.monthly(option_stock, tradingday=1 ,time_rule=market_open(minute=5))  #每月第1个交易日开盘后5分运行
 
#日或分钟或实时数据更新，将会调用这个方法。行情事件handle_data
def handle_data(context, data_dict):

    #全部买入平安银行
    order_target_percent(context.stock, 1)


