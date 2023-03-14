# Write a function fun(x) that takes as input a positive number x and solves
# the following equation for y and returns y. The equation is 104y=x+3. 
from math import *
def fun(x):
    y = (log((float(x) + 3), 10) / 4)
    return(y)


