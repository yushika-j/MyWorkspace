#######################################
# QUESTION 1
#######################################

def largest_34(a):
    'returns the sum of the 3rd and 4th largest values in list a'
    lst = a[:]
    if len(lst) >= 4:
        
            largest_1 = max(a)
            a.remove(largest_1)
            largest_2 = max(a)
            a.remove(largest_2)
            largest_3 = max(a)
            temp = largest_3
            a.remove(largest_3)
            largest_4 = max(a)
# 100 appears 2 times causing an error
            return temp+largest_4
print(largest_34([1000,1,100,2,99,200,100]))

def largest_third(a):
    '''computes the sum of the len(a)//3 of the largest values in the list a'''
    num = len(a)//3
    lst = a[:]
    temp = 0
    for i in range(0,(len(lst)//3)+1):
        print(i)
        largest = max(a)
        temp = temp + largest
        a.remove(largest)
    return temp
print(largest_third([1000,1,100,2,99,200,100]))

def third_at_least(a):
    num = len(a)//3 + 1
    for item in a:
        if a.count(item) == num:
            return item

def sum_tri(a,x):
    length = len(a)
    for i in range(0,len(a)):
        for j in range(0,len(a)):
            for k in range(0,len(a)):
                if ( a[i] + a[j] + a[k]) == x :
                    return True
    return False

print(sum_tri([1,5,8,2,6,5,90],103))


