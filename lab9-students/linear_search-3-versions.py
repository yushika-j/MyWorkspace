# an implementation with while loop
def linear_search_v1(lst, value):
     """ (list, object) -> int
     Return the index of the first occurrence of value in lst, or return
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
     # If we fell off the end of the list, we didn't find value.
     if i == 0:
          return -1
     else:
          return i


# an implementation with for loop
def linear_search_v2(lst, value):
     """ same docstring as above
     """

     for i in range(len(lst)):
          if lst[i] == value:
               return i
     return -1


# an implementation with sentinel

# all three versions are correct and do roughly n operations on a list of size n
# the following solution uses no branching (i.e. if statements)

def linear_search_v3(lst, value):
     """ same docstring as above
     """     
     lst.append(value)
     i=0
     # Keep going until we find value.
     while lst[i] != value:
          i=i+1
     # Remove the sentinel.
     lst.pop()
     # If we reached the end of the list we didn't find value.
     if i == len(lst):
          return -1
     else:
          return i


print(linear_search_v1([2, 5, 1, -3], 5))