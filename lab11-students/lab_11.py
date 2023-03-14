###########################################
# PROGRAMMING EXERCISE 1
###########################################

def m(n):
    if n == 1 :
        return 1/ (2*n + 1)
    else:
        return (n/(2*n + 1) + m(n-1))
# print(m(3)) 

###########################################
# PROGRAMMING EXERCISE 2
###########################################

def count_digit(n):
    #n = str(n)
    if n < 10:
        return 1
    else:
        return(1 + count_digit(n//10))
print(count_digit(345678))

###########################################
# PROGRAMMING EXERCISE 3
###########################################

def is_palindrome(str):
    
    if len(str) <= 1:
        return True
    else:
        str.strip().lower()
        return (str[0] == str[len (str)  - 1]) and(is_palindrome(str[1 : len (str) - 1]))
    return False
print(is_palindrome("bannab"))

###########################################
# PROGRAMMING EXERCISE 4
###########################################

def is_palindrome_v2(str):
    str.strip().lower()
    if str.isalpha() == True:
        if len(str) <= 1:
            return True
        else:
            str.strip().lower()
            return (str[0] == str[len (str)  - 1]) and(is_palindrome(str[1 : len (str) - 1]))
        
is_palindrome_v2("A man, a plan, a canal -- Panama!")

###########################################
# PROGRAMMING EXERCISE 5
###########################################

def gcd(a,b):
    def gcd(x , y):
        if y == 0:
            return x
        else:
            return gcd(y, x % y)
print(gcd(12,8))