#!/usr/bin/python
# -*- coding: UTF-8 -*-
'''
-urlopen()->response
->response->read()抓取网页数据
->response->info() 抓取网页请求报头信息
->response->geturl()抓取访问地址
->response->getcode()抓取访问错误码
'''
import urllib2
import sys,re,random

#爬取网页html
def getHtml(url):
    '''
    随机添加/修改User-Agent,有些服务器或 Proxy 会通过该值来判断是否是浏览器发出的请求
    '''
    ua_list = [
    "Mozilla/5.0 (Windows NT 6.1; ) Apple.... ",
    "Mozilla/5.0 (X11; CrOS i686 2268.111.0)... ",
    "Mozilla/5.0 (Macintosh; U; PPC Mac OS X.... ",
    "Mozilla/5.0 (Macintosh; Intel Mac OS... "
    ]
    user_agent = random.choice(ua_list)
    '''
    伪装浏览器访问，第二种方式
    '''
    my_header={'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.108 Safari/537.36 2345Explorer/8.7.0.16013'}
    #request = urllib2.Request(url) #通过在request增加add_header属性，伪装user_agent进行访问
    request = urllib2.Request(url,headers=my_header) #通过设置haders，伪装user_agent进行访问
    
    request.add_header("User-Agent", user_agent)
    print request.get_header("User-agent")

    '''
    urlopen(url, data, timeout)
    第一个参数url即为链接，
    第二个参数data是访问url时要传送的数据，
    第三个timeout是设置超时时间。
    '''
    response = urllib2.urlopen(request)
    html = response.read()
    print html
    return html

html = getHtml("http://tieba.baidu.com/p/3205263090")

# sys.getfilesystemencoding() 
html = html.decode('utf-8','replace').encode(sys.getfilesystemencoding()) #转码:避免输出出现乱码，返回整个结构体

#获取图片链接的方法
def getImg(html):
    # 利用正则表达式匹配网页里的图片地址
    reg = r'src="([.*\S]*\.jpg)" pic_ext="jpeg"'
    imgre=re.compile(reg)
    imglist=re.findall(imgre,html)
    return imglist

imgList=getImg(html)
imgCount=0
#for把获取到的图片都下载到本地pic文件夹里，保存之前先在本地建一个pic文件夹
for imgPath in imgList:
    f=open("/Workspace/Code/urllib/Method/pic/"+str(imgCount)+".jpg",'wb')
    f.write((urllib2.urlopen(imgPath)).read())
    f.close()
    imgCount+=1
print("全部抓取完成")