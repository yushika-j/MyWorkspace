#Yushika Jhundoo
#Student number : 300269830
#ITI 1120 Assignment 3

####################################################
# Task 1.1
def sum_odd_divisors(n):
    '''(number)-> number
    Returns the sum of all the postive odd divisors of n
    '''
    sum_1 = 0
    if n == 0:
        return None
    
    for i in range(1,abs(n)+1):
        if (abs(n) % i) == 0 and ((i % 2) != 0) :
            sum_1 = sum_1 + i
   
    return sum_1 


####################################################
# Task 1.2
def series_sum():
    '''(none)-> number
    return the sum of a series for the given integer n
    Preconditions-> n must be a positive integer'''

    n = int(input("Please enter a non-negative integer: "))
    if n < 0 :
        return None

    result = 1000
    for i in range(1,n+1):
        result = result + (1/(i**2))

    return result

####################################################
# Task 1.3
def pell(n):
    '''(int)-> int
    Pell returns the nth Pell number'''
    if n < 0:
        return None
    if n == 0 or n == 1 :
        return n
    else:
        result = (2*pell(n-1) + pell(n-2))
        return result

####################################################
# Task 1.4
def countMembers(s):
    '''(str)-> int
     returns the number of characters in s, that are extraordinary'''
    count = 0
    for i in s:
        if i in '\!,23456' or (ord(i) >= 101 and ord(i) <= 106) or (ord(i)>= 70 and ord(i)<= 88):
            count += 1
    return count


####################################################
# Task 1.5

def casual_number(s):
    '''(str)-> int
    should return an integer representing a number in s, removing all commas
    '''
    answer = ""

    if s.isdigit() == True:
        return s
    elif s[0] == '-' and s.count("-") == 1 :
            answer = answer + '-'
    else:
        return None
    for i in s:
        if i in '0123456789':
            answer = answer + i
    return answer


####################################################
# Task 1.6
'''(str)-> int
returns the integer value represented by s
'''
def alienNumbers(s):
    result=0
    if s == "":
        return 0
    
    for i in range(0,len(s)):
        if s[i] == 'T':
            result = result + 1024
        elif s[i]== 'y':
            result = result + 598
        elif s[i] == '!': 
            result = result + 121
        elif s[i] == 'a':
            result = result + 42
        elif s[i] == 'N':
            result = result + 6
        elif s[i] == 'U':
            result = result + 1
    return result


####################################################
# Task 1.7

def alienNumbersAgain(s):
    '''(str)-> int
    takes a single string parameter s, and returns the numeric value of
    the number that s represents in the alien numbering system'''
    result=0
    if s == "":
        return 0
    for i in s:
        if i == 'T':
            result = result + 1024
        elif i== 'y':
            result = result + 598
        elif i == '!': 
            result = result + 121
        elif i == 'a':
            result = result + 42
        elif i == 'N':
            result = result + 6
        elif i == 'U':
            result = result + 1
        
    return result


####################################################
# Task 1.8
def encrypt(s):
    '''(str)-> str
    Returns a string which is the encrypted version of s'''
    reverseText = s[::-1]
    i=0
    cipher = ''
    while i <= len(s)-1:
        
        cipher = cipher + reverseText[i]
        cipher = cipher + s[i]
        i = i + 1
    cipher = cipher[::-1]
    cipher = cipher[0:len(s)]
    return cipher


####################################################
# Task 1.9
'''(str)-> str
. It returns a string with the letters o and p (either uppercase or lowercase) inserted between every pair of
consecutive characters of s, depending on the string'''
def oPify(s):
    result = s[0]
    for i in range(0,len(s)-1):

        if s[i].isalpha() == True and s[i+1].isalpha() == True:
            
            if s[i].isupper() == True:
                result = result + "O"
            else:
                result = result + "o"
            if s[i+1].isupper() == True:
                result = result + "P"
            else:
                result = result + "p"
        result = result+ s[i+1]

    return result


####################################################
# Task 1.10
def nonrepetitive(str):
    for i in range(0,len(str)-1):
        sub_2 = str[i:i+1]
        result = sub_2 + sub_2
        if result in str:
                return False

    for i in range(0,len(str)-1):
        sub_2 = str[i:i+2]
        result = sub_2 + sub_2
        if result in str:
                return False
            

    for i in range(0,len(str)-1):
        sub_2 = str[i:i+3]
        result = sub_2 + sub_2
        if result in str:
            return False
        

    for i in range(0,len(str)-1):
        sub_2 = str[i:i+4]
        result = sub_2 + sub_2
        if result in str:
            return False
    return True


