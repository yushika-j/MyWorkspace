
# this function computes the sum 1+2+3+...+n
# this is an ITERATIVE SOLUTION	(a solution with a for or while loop)

def sum_i(n):
     '''int->int
     Returns the sum of 1+2+3+...+n
     Precondition: n positive integers'''
     
     current_sum = 0

     for i in range(1,n+1):
          current_sum=current_sum+i

     return current_sum

# this function computes the product 1*2*3*...*n, thus it computes n!
# this is a RECURSIVE SOLUTION (no while or for loops, only function calls)
def sum_r(n):
     '''int->int
     Returns the sum of 1+2+3+...+n
     Precondition: n positive integers'''

     if n == 1:
          return 1
     else:
          return sum_r(n-1)+n


# this function computes the product 1*2*3*...*n, thus it computes n!
# this is an ITERATIVE SOLUTION	(a solution with a for or while loop)

def fact_i(n):
     ''' (int)->int
     Returns n! = n*(n-1) .... 2*1
     Precondition: n>=1
     '''
     prod=1
     for i in range(1,n+1):
          prod=prod*i
     return prod

# this function computes the product 1*2*3*...*n, thus it computes n!
# this is a RECURSIVE SOLUTION (no while or for loops, only function calls)
def fact(n):
     ''' (int)->int
     Returns n! = n*(n-1) .... 2*1
     Precondition: n>=1
     '''
     if n==1: # base case
          return 1
     else:
          partial=fact(n-1) # make recursive call to a smaller problem and then merge solutions
          return n*partial
