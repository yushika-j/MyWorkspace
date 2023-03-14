from math import *
def pythagorean_pair(a,b) :
    #temp = pow(float(a),2) + pow(float(b),2)
    a= float(a)
    b=float(b)
    
    temp= sqrt((a*a) + (b*b))

    return temp.is_integer()

       
a= input("Enter a: ")
b= input("Enter b: ")
print(pythagorean_pair(a,b))
