def binary_search(L, v):
     """ (list, object) -> int
     Return the index of the first occurrence of value in L, or return
     -1 if value is not in L.
     >>> binary_search([1, 3, 4, 4, 5, 7, 9, 10], 1)
     0
     >>> binary_search([1, 3, 4, 4, 5, 7, 9, 10], 4)
     2
     >>> binary_search([1, 3, 4, 4, 5, 7, 9, 10], 5)
     4
     >>> binary_search([1, 3, 4, 4, 5, 7, 9, 10], 10)
     7
     >>> binary_search([1, 3, 4, 4, 5, 7, 9, 10], -3)
     -1
     >>> binary_search([1, 3, 4, 4, 5, 7, 9, 10], 11)
     -1
     >>> binary_search([1, 3, 4, 4, 5, 7, 9, 10], 2)
     -1
     >>> binary_search([], -3)
     -1
     >>> binary_search([1], 1)
     0
     """
     # Mark the beginning and the end indices of the unexplored sublist.
     b=0
     e = len(L) - 1

     while b != e + 1:
          mid = (b + e) // 2
          if L[mid] < v:
               b=mid+1
          else:
               e=mid-1
          
     if 0 <= b < len(L) and L[b] == v:
          return b
     else:
          return -1
print(binary_search([1, 3, 4, 4, 5, 7, 9, 10], 4))