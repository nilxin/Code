import talib
import numpy as np
import math
import pandas
import time 
import datetime 
from functools import reduce 

# init方法是您的初始化逻辑
def init(context):

    # get_sector-获取板块数据
        # Energy能源、Materials材料、ConsumerDiscretionary可选消费
        # ConsumerStaples日常消费、Industrials工业、HealthCare医疗保健
        # Financials金融、InformationTechnology信息技术、TelecommunicationServices电信服务
        # Utilities公用事业
    context.stock = get_sector('Industrials')  

    # get_industry-获取行业数据
        # A01农业、A02林业、A03畜牧业、A04渔业、A05农、林、牧、渔服务业
        # http://quant.jd.com/help 板块代码列表
    context.stock = get_industry('I64') 

    # get_index_constituents-获取指数成份股
        # 0000002 获取工业板块指数
    context.stock = get_index_constituents('000002.SH')

    # get_all_securities-获取指数成份股，get_all_securities(types=[], date=None)
    # type list 如果不输入默认是所有值,type的值有 stock、etf、lof、sf、index、fund
    # date str 参数可传入字符串或datetime.datetime/datetime.date对象。
        # 字符串格式为’YYYY-mm-dd’或’ YYYY-mm-dd HH:MM:SS'，如’2015-06-01’或’2015-06-01 13:26:23’。
        # 也可以传入datetime.datetime(2015, 6, 1, 11, 0, 0)对象。此参数默认值为None, 不传入则表示获取所
        # 有日期的股票信息获得2015年10月18日还在上市的 etf 和 lof 基金列表
    df = get_all_securities(['fund'])
    print(df)

    # get_securities-获取股票基本信息,返回dict
    # {'end_date': datetime.datetime(2017, 4, 26, 0, 0), 'sub_type': '主板', 'sector_code': 'Financials', 'sector_name': '金融', 'abbrev_symbol': 'zgyh', 'listed_date': datetime.datetime(2006, 7, 5, 0, 0), 'industry_name': '货币金融服务', 'change_dt1': datetime.datetime(2015, 12, 31, 0, 0), 'type': 'stock', 'listing': True, 'float_a_share': 21076551.4846, 'market': '上交所', 'industry_code': 'J66', 'ann_dt': None, 'is_st': False, 'order_book_id': '601988.SH', 'restricted_a_share': 0.0, 'total_share': 29438779.1241, 'symbol': '中国银行', 'sector_en_code': 'financials'
    # 如何使用dict的值security.sub_type
    security  = get_securities("601988.SH")
    print(security)  #打印中国银行的基本信息

    # get_history-获取历史行情数据
    # get_price(security_id, start_date= None, end_date= None, frequency='1d', fields=None)
      # security_id 一支股票代码或者多支股票代码的list
      # start_date 此参数可传入字符串或datetime.datetime/datetime.date对象。字符串格式为’YYYY-mm-dd’或’ YYYY-mm-dd HH:MM:SS'，如’2015-01-01’或’ 2015-06-01 13:26:23’。 也可以传入datetime.datetime(2015, 6, 1, 11, 0, 0)对象。 如果是取天数据传入带时分秒的日期，则传入的时分秒会进行忽略。如果是取分钟数据传入年月日日期，则时分秒默认为’ 00:00:00’
      # end_date 此参数传入格式与start_dat相似，输入请参照start_date描述。
      # frequency 此参数为历史数据的频率，现在支持一日/一分钟级别的历史数据，'1d'代表日线，'1m'代表分钟线。默认为'1d'。
      # fields 此参数为list字符串, 默认值是None，行情据字段的list值为[‘open’, ‘close’, ‘high’, ‘low’, ‘volume’,‘turover’]
    #取中国银行5天的开盘价，收盘价，最高价，最低价，成交量
    open = get_history(5,'1d','open')['601988.SH'].values
    close = get_history(5,'1d','close')['601988.SH'].values
    high = get_history(5,'1d','high')['601988.SH'].values
    low = get_history(5,'1d','low')['601988.SH'].values
    volume = get_history(5,'1d','volume')['601988.SH'].values
    print("打印开盘价历史",open)
    print("打印收盘价历史",close)
    print("打印最高价历史",high)
    print("打印最低价历史",low)
    print("打印成交量历史",volume)

    #get_price-获取历史行情数据，存在问题？
    # get_price(security_id, start_date= None, end_date= None, frequency='1d', fields=None)
      # security_id 一支股票代码或者多支股票代码的list
      # start_date 此参数可传入字符串或datetime.datetime/datetime.date对象。字符串格式为’YYYY-mm-dd’或’ YYYY-mm-dd HH:MM:SS'，如’2015-01-01’或’ 2015-06-01 13:26:23’。 也可以传入datetime.datetime(2015, 6, 1, 11, 0, 0)对象。 如果是取天数据传入带时分秒的日期，则传入的时分秒会进行忽略。如果是取分钟数据传入年月日日期，则时分秒默认为’ 00:00:00’
      # end_date 此参数传入格式与start_dat相似，输入请参照start_date描述。
      # frequency 此参数为历史数据的频率，现在支持一日/一分钟级别的历史数据，'1d'代表日线，'1m'代表分钟线。默认为'1d'。
      # fields 此参数为list字符串, 默认值是None，行情据字段的list值为[‘open’, ‘close’, ‘high’, ‘low’, ‘volume’,‘turover’]
    df=get_price('000001.SZ', start_date='2015-01-01', end_date='2015-01-31 23:00:00', frequency='1m', fields=['open', 'close'])
    # 获得000001.SH'的2015年1月1号-2015年1月31日天数据
    df = get_price('000001.SZ', start_date='2015-01-01', end_date='2015-01-31', frequency='1d') 
    #取上证50指数数据，返回一个[pandas.Panel]
    panel = get_price(get_index_constituents('000016.SH'))
    print(df)

    # share_holder_numbers-股东人数
      # symbols 股票代码list
      result = share_holder_numbers(['000001.SZ'])
      print(result)

    # share_top_10-十大流通股东比例
      # symbols 股票代码list
      result = share_top_10(['000001.SZ'])
      print(result)

    # share_institution_holding-机构持股比例
      # symbols 股票代码list
      result = share_institution_holding(['000001.SZ'])    
      print("打印结果",result)


 
#日或分钟或实时数据更新，将会调用这个方法。行情事件handle_data
def handle_data(context, data_dict):

      # TradeData-当前行情数据对象，此对象可通过handle_data函数的data_dict参数获取
      # order_book_id  证券的唯一的标识符，比如：“000089.SZ”
      # date 行情数据的时间
      # open 开盘价
      # close 收盘价
      # high 最高价
      # low 最低价
      # last 行情数据的最新价
      # volume 总成交量
      # sf 该证券是否在交易中。0可以交易；1停牌等，无法交易。
      # 获取当前行情收盘价
      tradeData = data_dict['0000006.SZ']
      tradeData.close

      #获取平安银行当前行情收盘价
      close  = data_dict['000001.SZ'].close
      print(close)

      #判断000006.SZ当前是否可交易
      data_dict['000006.SZ'].sf

      # kline是截止到当前时间点的多维度行情数据函数。可以看作常用行情软件上的K线图的数据，该函数可取到当前时间点的1分钟、5分钟、15分钟、30分钟、60分钟、天、周、月维度的数据。skip_paused为是否跳过停牌数据，skip_paused不传或为True时为跳过停牌数据。
        # security_id 股票代码
        # data_count 数据条数
        # frequency 数据维度，参考值1m,5m,60m,1d,week,month
        # fields 参数值为一个列表，open、close、high、low、volume、turnover
        # skip_paused True为停牌、False为不跳过 
      #取中国银行5条60分钟的K线收盘价格，跳过停牌数据
      close = kline('601988.SH', 5, '60m',['close'], skip_paused=True)

#开盘前事件函数，每天开盘前选取股票
    # get_fundamentals-财务数据选股,get_fundamentals(query, date=None)  
      # SQLAlchemy的query对象,查询条件，包含>,<,=,>=,<=,in_
      # date,年月日的str类型，该日期不能超过策略运行的日期，如果超过会调整到当前时间。示例'2015-03-05'
      # 同时该函数可通过order_book_id属性查询一只或多只股票的财务数据
def before_trade(context):

    # 通过财务数据的pb_ratio和market_cap_2指标筛选股票，降序排序之后获取前5个
   finance_df = get_fundamentals(
      query(
         fundamentals.equity_valuation_indicator.pe_ratio
      ).filter(
         fundamentals.equity_valuation_indicator.pe_ratio>15
      ).order_by(
        fundamentals.equity_valuation_indicator.market_cap_2.desc()
      ).limit(
         20
      )
   )

   #筛选一只或多只股票的财务信息可用fundamentals.order_book_id.in_(['000001.SZ'])
   finance_df = get_fundamentals(
      query(
         fundamentals.equity_valuation_indicator.pe_ratio
      ).filter(
         fundamentals.equity_valuation_indicator.pe_ratio>5
      ) .filter(
         fundamentals.order_book_id.in_(['000001.SZ'])
      ).limit(
         20
      )
   )

   #设置股票池到全局context中
   context.stock_list = finance_df.columns.values
   print(context.stock_list)  #打印股票列表


