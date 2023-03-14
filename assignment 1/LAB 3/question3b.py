def is_divisible(n,m):
   
    if (n % m == 0) :
       return True
    else:
        return False



def is_divisible23n8(num):
    '''(number)-> none
    Takes a number as parameter and checks if it is divisible by 2 and 3 but not 8'''
    
    if is_divisible(num,2) or is_divisible(num,3) == True:
        if is_divisible(num,8)== False:
            return print( num , " is divisible by 2 or 3 but not 8")
        else:
            return print("It is not true that ", num ," is divisible by 2 or 3 but not 8")
    else:
        return print(num ," is not divisible by 2, 3 or 8")
num = int(input("Enter an integer: "))
