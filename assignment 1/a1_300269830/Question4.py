#  Write a function safe(n) that takes a non-negative integer n as input where n
# has at most 2 digits. The function determines if n is a safe number. A number is not
# safe if it contains a 9 as a digit, or if it can be divided by 9. The function should test if
# n is safe and return True if n is safe and False otherwise.
from math import *
def safe(n) :
    
    result = (float(n) > 0) and (float(n) < 100) 
    x = not("9" in str(n))
    is_safe = (result and not((float(n) % 9)== 0) and x)
    return is_safe

n = input("Enter a number between 0 and 99 inclusive: ")
print(safe(n))