def prime(n):
     '''(int)->bool
     returns True if n is a prime, and False otherwise
     Precondition: n is a positive integer'''
     is_prime=True
     for i in range(2,n):
          if(n%i == 0):
               is_prime=False
     if(is_prime and n!=1):
          return True
     else:
          return False

def prime_v2(n):
     '''(int)->bool
     returns True if n is a prime, and False otherwise
     Precondition: n is a positive integer'''
     if(n==1):
          return False
     for i in range(2,n):
          if(n%i == 0):
               return False
     return True

def divisors(n):
     '''(int)->None
     prints all the divisors of n
     Precondition: n is a positive integer'''
     for i in range(1,n+1):
          if(n%i == 0):
               print(i, end=" ")
     print()

# prompt for a number
number=int(input("Enter a positive integer whose divisors you want to know: "))

# divisors:
print("All the divisor of ", number, "are:")
divisors(number)

# primality
if(prime(number)):
     print("thus", number, "is a prime")
else:
     print("thus", number, "is not a prime")

if(number==1):
     print("Do you know one of the reasons why 1 is not defined as a prime?")

# all primies less than
n=int(input("Enter a positive integer and I will display your all the primes less than that. "))
for i in range(n):
     if(prime(i)):
          print(i, end=" ")
print()
print("Good bye")
     
