#!/usr/bin/python
# -*- coding: UTF-8 -*-
import matplotlib.pyplot as plt_bar
import matplotlib.pyplot as plt_histbar

#bar
plt_bar.bar([1,3,5,7,9],[5,2,7,8,2], label="Example one",color='r')
plt_bar.bar([2,4,6,8,10],[8,6,2,5,6], label="Example two", color='g')

plt_bar.xlabel('x')
plt_bar.ylabel('y')
plt_bar.title('Interesting Graph\nCheck it out')

#histbar
population_ages = [22,55,62,45,21,22,34,42,42,4,99,102,110,120,121,122,130,111,115,112,80,75,65,54,44,43,42,48]
bins = [0,10,20,30,40,50,60,70,80,90,100,110,120,130]

plt_histbar.hist(population_ages, bins, histtype='bar', rwidth=0.8)

plt_histbar.xlabel('bar number')
plt_histbar.ylabel('bar height')
plt_histbar.title('Epic Graph\nAnother Line! Whoa')

#legend、show
plt_bar.legend()
plt_histbar.legend()
plt_bar.show()
plt_histbar.show()