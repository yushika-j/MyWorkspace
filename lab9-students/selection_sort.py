import random
import time

'''We study algorithms

O(1) - basic operations addition/multiplication function call, accessing a set

O(log n) - bigger than O(1), but less than O(n)

O(n) - iterating over a list (of length n)

O(n^2)

'''

def selection_sort_v1(L):
     ''' sorts given list L'''
     for i in range(len(L)-1):
          # Find the minimum in the list[i..len(L)-1]
          min_index=i
          for j in range(i+1, len(L)):
               if(L[min_index]>L[j]):
                    min_index=j
          #Swap L[i] with L[min_index] if necessary
          L[i],L[min_index]=L[min_index], L[i]

def insert(L,b):
     '''(list,int)->NoneType
     Precondition: elements L[0]...L[b-1] already sorted
     Insert L[b]where it belogs in subliest L[0] ... L[b-1]
     >>> L[3,4,-1,7,2,5]
     >>> insert(L,2)
     [-1,3,4,7,2,5]
     '''
     i=b
     while i!=0 and L[i-1]>=L[b]:
          i=i-1

     tmp=L[b]
     del L[b]
     L.insert(i,tmp)

def insertion_sort(L):
     for i in range(len(L)):
          insert(L,i)


import time
def print_times(L):
     '''list->None
     '''
     # selection sort:
     print("SELECTION SORT:")
     copy=L[:]
     t1=time.perf_counter()
     selection_sort_v1(copy)
     t2=time.perf_counter()
     print(t2-t1)

     #python's sort
     print("PYTHON SORT:")
     copy=L[:]
     t1=time.perf_counter()
     copy.sort()
     t2=time.perf_counter()
     print(t2-t1)
     

lst=random.sample(range(100000), 10000)
print_times(lst)
