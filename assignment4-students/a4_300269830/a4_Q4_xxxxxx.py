
def read_raw(file):
    '''str->list of str
    Returns a list of strings that was stored in a file.'''
    raw = open(file).read().splitlines()
    for i in range(len(raw)):
        raw[i]=raw[i].strip()
    return raw


def clean_up(l):
    '''list of str->list of str

    The functions takes as input a list of characters.
    It returns a new list containing the same characters as l except that
    one of each characters that appears odd number of times in l is removed
    and all the * characters are removed

    clean_up(['A', '*', '$', 'C', '*', '*', 'P', 'E', 'D', 'D', '#', 'D', 'E', 'B', '$', '#'])
    ['#', '#', '$', '$', 'D', 'D', 'E', 'E']

    clean_up(['A', 'B', '*', 'C', '*', 'D', '*', '*', '*', 'E'])
    []
    '''
    
    
    clean_board = []
    # #YOUR CODE GOES HERE
    # for char in l:
    #     while (char != "*") and (l.count(char)!= 1) :
    #         #if l.count(char) % 2 == 0:     #not odd
    #             clean_board.append(char)
    #         #elif l.count(char) % 2 == 1:
    #             # pos = l.index(char)
    #             # clean_board.append(pos)
    # print(clean_board)
    for char in l :
       
        if '*' in char:
            l.remove(char)
            
        if l.count(char) == 1 :
            l.remove(char)
        
        if l.count(char) % 2 != 0:
            char1 = l.index(char)
            l.remove(l[char1])
        
    
    for i in range(0,len(l)):
        if l[i] != "*":
            clean_board.append(l[i])
        
    clean_board.sort()
    return (clean_board)
    


def is_rigorous(l):
    '''list of str->bool
    Returns True if every character in the list appears exactlly 2 times or the list is empty.
    Otherwise, it returns False.

    Precondition: You may assume that every element in the list appears even number of times
    (i.e. that the list is clean-up by clean_up function)

    >>> is_rigorous(['E', '#', 'D', '$', 'D', '$', 'E', '#'])
    True
    >>> is_rigorous(['A', 'B', 'A', 'A', 'A', 'B'])
    False
    '''
    #YOUR CODE GOES HERE
    ans = True
    for char in l:
        if (l.count(char) != 2) or len(l) != 0:
            ans = False

    return ans



    
#main
file=input("Enter the name of the file: ")
file=file.strip()
b=read_raw(file)
print("\nBefore clean-up:\n", b)
b=clean_up(b)
print("\nAfter clean-up:\n", b)
if is_rigorous(b):
    print("\nThis list is now rigorous; it has no * and it has "+str(len(b))+" characters.")
else:
    print("\nThis list has no * but is not rigorous and it has "+str(len(b))+" characters.")
     




#print(clean_up([['E', '#', 'D', '$', 'D', '$', 'E', '#']]))