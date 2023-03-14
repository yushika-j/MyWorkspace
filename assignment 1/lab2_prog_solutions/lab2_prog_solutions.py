from math import *
#exercise 1
def repeater(s1, s2, n):
    return "_" + n * (s1 + s2) + "_"


#exercise 2
def roots(a,b,c):
    solution_1 = (-b + sqrt((b**2)-(4 * a * c))/(2 * a))
    solution_2 = (-b - sqrt((b**2)-(4 * a * c))/(2 * a))
    print("The quadratic equation with coefficients a = ", a , "b = ", b , "c = " , c ," has the following solutions (roots): ")
    print(solution_1, "and ", solution_2)

#exercise 3
def real_roots(a,b,c):
    return ((b**2) - (4*a*c)) >=0

#exercise 4
def reverse(x):
    return x//10 + (x%10)*10
