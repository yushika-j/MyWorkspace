def binary_search(L,v):
     '''
     (list,object)->bool

     Returns an index of v in L
     or returns -1, if v not in L
     
     Precondition: L is sorted
     '''
     b = 0
     e = len(L)- 1

     while e >= b:
          mid = (b + e) // 2
          if (key < L[mid]):
               e = mid - 1
          elif (key == L[mid]):
               return mid
          else:
               b = mid + 1
               
     return - 1; # Now high < low
