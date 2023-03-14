from math import*
def overlap(set1,list1):
    set = {}
    set = set1.intersection(list1)
    return set


#print(overlap({0,19,14,15,5,8,9,3},[0,19,11,12,7,5,1,15]))

def reverse(dict1):
    #print(dict1)
    lstValues = []
    for value in dict1.values():
        if (value not in lstValues):
            lstValues.append(value)

    set1 = {}
    for name in lstValues:
        lstKeys = []
        result = ()
        for key,value in dict1.items():
            if (name == value):
                lstKeys.append(key)
                
        
        set1[name] = lstKeys
        #print(set1[name])
    return set1
#print(reverse({42:"Marty",81:"Sue", 17:"Ed",31:"Dave",56:"Ed",3:"Marty",29: "Ed"}))

def digit_sum(n):
    length = len(str(n))
    if length == 1:
        return n
    else:
        #print(n)
        return (int(n) % 10 + digit_sum(int(n) // 10))

def digital_root(n):
    '''(number)->('''
    n = str(n)
    if len(n) == 1:
        return n
    n = digit_sum(n)
    #print(n)
    return digital_root(n)
#print(digit_sum(1969))
#print(digital_root("1969"))
