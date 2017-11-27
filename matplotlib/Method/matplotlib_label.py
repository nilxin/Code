#!/usr/bin/python
# -*- coding: UTF-8 -*-
import matplotlib.pylab as plt
x = [1,2,3]
y = [5,7,4]

x2 = [1,2,3]
y2 = [10,14,12]
#label使用，线条指定名称
plt.plot(x, y, label='First Line')
plt.plot(x2, y2, label='Second Line')

plt.xlabel('Plot Number')#指定X坐标的标签
plt.ylabel('Important var')#指定Y坐标的标签
plt.title('Interesting Graph\nCheck it out')
plt.legend()
plt.show()