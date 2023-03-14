def divisor(num):
    for i in range(1,num+1):
        if (num % i) == 0 :
            print(i, end=' ')
#print(divisor(6))

def prime(x):
    '''(number)-> bool
    Function prime takes a positive integer as input parameter and tests if it is a prime'''
    y = divisor(x)
    y = str(y)
    y = y.strip()
    if len(y) == 2 and x >= 2 :
        return True
    else:
        return False

print(prime(6))