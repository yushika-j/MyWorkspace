###############################################################
#Programming exercise 1

def ah(l,x,y):
    count = 0
    minimum = 1000
    for i in range(len(l)):
        if l[i] >= x and l[i] <= y:
            count = count + 1
            if l[i] <= minimum:
                minimum = l[i]
    return (count,minimum)
t = [5, 1, -2.5, 10, 13, 8]
#print (ah(t,2,11))

###############################################################
#Programming exercise 2
def divisor(num):
    lst=[]
    for i in range(1,num+1):
        if (num % i) == 0 :
            lst.append(i)
    return (lst)
#print(divisor(6))


def is_perfect(num):
    lst = divisor(num)
    lst.remove(num)
    
    sum_1 = sum(lst)
    
    if num == sum_1:
        return True
    else:
        return False
#print(is_perfect(10))

###############################################################
#Programming exercise 3a

def arithmetic(lst):
    if len(lst) < 2:
        return True
    difference = lst[1] - lst[0]
    for i in range(1,len(lst)-1):
        if lst[i+1] - lst[i] != difference:
            return False
        else:
            return True
#print(arithmetic([1,3,5,7]))

###############################################################
#Programming Exercise 3b

def is_sorted(lst):
    for i in range(len(lst)):
        if lst[i] <= lst[i + 1]:
            return True
        else:
            return False
#print(is_sorted([1, 1, 1, 7, 7]))
