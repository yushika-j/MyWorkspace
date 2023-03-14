def is_divisible(n,m):
     '''(int, int)->bool
     returns True if n is divisible by n, and False otherwise.'''
     return n%m==0

def is_divisible23n8(n):
     '''(int)->str
     returns string "yes" if n is divisible by 2 or 3 but not 8, and "no" otherwise.'''
     if ( (is_divisible(n,2) or is_divisible(n,3)) and not(is_divisible(n,8))):
          return "yes"
     else:
          return "no"


num = int(input("Enter an integer: "))

if( is_divisible23n8(num) == 'yes'):
     print(num, "is divisible by 2 or 3 but not 8")
else:
     print("It is not true that", num, "is divisible by 2 or 3 but not 8")
