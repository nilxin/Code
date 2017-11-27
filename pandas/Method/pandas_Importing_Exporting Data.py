#!/usr/bin/python
# -*- coding: UTF-8 -*-
''' IMPORTING DATA '''
#read_csv、read_table、read_excel、read_sql、read_json、read_html、read_clipboard、DataFrame(dict)
import pandas as pd
df=pd.read_csv('/Workspace/Code/Python/test.csv',encoding='gbk') #可代参数encodeing
#输出mail列的0-2行
print df[u'mail'][:3]
'''  EXPORTING DATA '''
# to_csv、to_excel、to_sql、to_json、to_html、to_clipboard() 

