def exponent(x,n):
    if n == 0:
        return 1
    elif n == 1:
        return x
    else:
        return (x*exponent(x,n-1))

print(exponent(3,2))