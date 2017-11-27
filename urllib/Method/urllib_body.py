#!/usr/bin/python
# -*- coding: UTF-8 -*-
import urllib2
from urllib2 import Request

#伪装浏览器访问
my_header={'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.108 Safari/537.36 2345Explorer/8.7.0.16013'}

request=Request('https://www.baidu.com',headers=my_header)
response=urllib2.urlopen(request)
content=response.read()
print(content)