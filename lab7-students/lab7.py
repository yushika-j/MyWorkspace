#Question 5.16

def indexes(str,char):
    lst = []
    for i in range(0,len(str)):
        if char == str[i]:
            lst.append(i)
    return lst
#print(indexes("mississipi","i"))

#Question 5.17
def doubles(lst):
    for i in range(1,len(lst)-1):
        if lst[i] == (lst[i + 1] / 2):
            print(lst[i+1])
#print(doubles([3,0,1,2,3,6,2,4,5,6,5]))

#Question 5.18
def four_letter(lst):
    sublist = []
    for item in lst:
        if len(item) == 4 :
            sublist.append(item)
    print(sublist)

#print(four_letter(['dog','stop','door','bus','dust']))

#Question 5.19
def inBoth(l1,l2):
    for item in l1:
        if item in l2:
            return True
    return False
#print(inBoth([3,2,5,4,7],[9,0,1]))
 
#Question 5.20
def intersect(l1,l2):
    sublist = []
    for item in l1:
        if item in l2:
            sublist.append(item)
    return sublist
#print(intersect([3,2,5,4,7,9],[9,0,1,5]))

#Question 5.21
def pair(l1,l2,n):
    for num1 in l1:
        for num2 in l2:
            if num1+num2 == n:
                print(num1 , num2)
#print(pair([2,3,4],[5,7,9,12],9))

#Question 5.22
def pairSum(lst,n):
    length = len(lst)//2
    lst1 = lst[0:length]
    for i in lst1:
        for j in lst:
            if i+j == n :
                print(lst.index(i) , lst.index(j))
#print(pairSum([7,8,5,3,4,6],11))

#Question 5.29
def LastFirst(lst):
    first = []
    last = []
   
    for name in lst:
        i = name.find(',')
        last.append(name[0:i])
        first.append(name[i+2:])
    result = [first,last]
    return result
#print(LastFirst(['Gerber, Len','Fox, Kate','Dunn, Bob']))

#question 5.30
def subsetSum(lst,n):
    num1 = 0
    num2 = 0
    num3 = 0
    for i in range(0,len(lst)):
        for j in range(0,len(lst)):
                for k in range(0,len(lst)):
                    num1 = lst[i]
                    num2 = lst[j]
                    num3= lst[k]
                    if num1 + num2 + num3 == n:
                        return True
    return False
#print(subsetSum([5,4,10,20,15,19],10))

#Question 5.33
def mystery(n):
    count = 0
    while n > 1:
        n = n // 2
        count = count + 1
    return count
#print(mystery(11))

#Question 5.46
def inversions(str):
    count = 0
    for i in range(0,len(str)):
        for j in range(i,len(str)):
            if ord(str[i]) > ord(str[j]):
                count = count + 1
    return count
#print(inversions('DCBA'))

#Question 5.48
def sublist(list1,list2):
    common = ''
    for item in list1:
        if item not in list2:
            return False
        common = item
        next
        if list2.index(common) > list2.index(item):
            return False
    return True
print(sublist([15,50,20],[20,15,30,50,1,100]))


    
