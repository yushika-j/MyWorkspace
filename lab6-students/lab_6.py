
def prog_ex2():
    #Programming Exercise 2
    answer = "yes"
    while answer.lower() == "yes" :
        num1 = input("Enter an integer: ")
        num2 = input("Enter another integer: ")
        sum_1 = int(num1) + int(num2)
        print("The sum of the 2 integers are " , sum_1)
        answer = input("Do you want to perform the same operation again?: ")

def first_neg(lst):
    i = 0
    while lst[i] > 0 and (i < len(lst) - 1):
        i = i + 1
    if len(lst) == 0 or lst[i] > 0:
        return None
    else:
        return i
   
#print(first_neg(([2, 3, 1, 4, 2])))

def sum_5_consecutive_v1(lst):
    sum_1=0
    if len(lst) < 5:
        return False
    else:
        for i in range(0,len(lst)-1):
            sum_1 = sum(lst[i:i+5])
            if sum_1 == 0:
                return True
            
#print(sum_5_consecutive_v1([2, 1, -3, -3, -3, 2, 7, 4, -6]))

def sum_5_consecutive_v2(lst):
    i = 0
    if len(lst) < 5:
        return False
    else:
        while i != len(lst):
            if (lst[i]+lst[i+1]+lst[i+2]+lst[i+3]+lst[i+4]+lst[i+5]) == 0:
                return True
            i = i + 1
            

#print(sum_5_consecutive_v2([2, 1, -3, -3, -3, 2, 7, 4, -6]))

def fib(n):

    if n == 0:
        return []
    elif n == 1: 
        return [1]
    else:
        lst=[1,1,2]
        for i in range(3,n-1):
            num = lst[i-1] + lst[i-2]
            
            lst.append(num)

    return (lst)
#print(fib(7))

def inner_product(l1,l2):
    result = 0
    for i in range(0,len(l1)):
        result = result + (l1[i] * l2[i])
    return result

#print(inner_product([2,3,4], [1,0,2]))
