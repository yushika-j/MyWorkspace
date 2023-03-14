def is_divisible(n,m):
     '''(int, int)->bool
     returns True if n is divisible by n, and False otherwise.'''
     return n%m==0

first = int(input("Enter 1st integer: "))
second = int(input("Enter 2nd integer: "))

if (is_divisible(first,second)):
     print(first, "is divisble by", second)
else:
     print(first, "is not divisble by", second)
 
