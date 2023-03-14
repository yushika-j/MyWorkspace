############################################################
# PROGRAMMING EXERCISE 1
############################################################
def linear_search_v1(lst, value):
     """ (list, object) -> int
     Return the index of the last occurrence of value in lst, or return
     -1 if value is not in lst.
     >>> linear_search_v1([2, 5, 1, -3], 5)
     1
     >>> linear_search_v1([2, 4, 2], 2)
     0
     >>> linear_search_v1([2, 5, 1, -3], 4)
     -1
     >>> linear_search_v1([], 5)
     -1
     """

     i = len(lst)-1 # The index of the next item in lst to examine.
     # Keep going until we reach the end of lst or until we find value.
     while i != 0 and lst[i] != value:
          i=i-1
     # If we fell off the start of the list, we didn't find value.
     if i == 0:
          return -1
     else:
          return i

#print(linear_search_v1([2, 4, 2], 2))


def linear_search_v2(lst, value):
     """ same docstring as above
     """

     for i in range(len(lst)-1,0,-1):
          if lst[i] == value:
               return i
     return -1
print(linear_search_v2([2, 4, 2], 2))

def linear_search_v3(lst, value):
     """ same docstring as above
     """     
     
     print(lst)
     i=len(lst)-1
     # Keep going until we find value.
     while lst[i] != value:
          i=i-1
     # Remove the sentinel.
     #lst.remove(value)
     # If we reached the end of the list we didn't find value.
     if i == -1:
          return -1
     else:
          return i
#print(linear_search_v3([1, 4, 5, 2, 4], 2))
#print(linear_search_v3([2, 5, 1, -3], 5))

########################################################
#Programming exercise 3
########################################################
def first_one(L):
    for i in range(0,len(L)):
        if L[i] == 1:
            return i
#print(first_one([0,0,0,0,0,0,1,1,1,1,1]))
