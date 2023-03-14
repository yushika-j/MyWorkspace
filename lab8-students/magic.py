def is_square(m):
     '''2d-list => bool
     Return True if m is a square matrix, otherwise return False
     (Matrix is square if it has the same number of rows and columns'''
     for i in range(len(m)):
          if len(m[i]) != len(m):
               return False
     return True


def magic(m):
     '''2D list->bool
     Returns True if m forms a magic square
     Precondition: m is a matrix with at least 2 rows and 2 columns '''

     # this tests the condition that is implied by the definition
     # i.e. that m has to be a square matrix
     if(not(is_square(m))): # if matrix is not square
          return False      # return False

     # YOUR CODE GOES HERE
     n = len(m)
     sum_diag1 = 0
     sum_diag2 = 0 
     # TEST CONDITION 1
     # for row in range(0,n):
     #      sum_diag1 += m[row][row]
          
     # for row in range(0,n):
     #      for col in range(0,len(m[row]),-1):
     #           sum_diag2 += m[row][col]
     
     # if sum_diag1 != sum_diag2:
     #      return False

     for column in range(len(m[0])):
        total = 0
        for row in range(len(m)):
            total += m[row][column]
        return total
     # # TEST CONDITION 2
     # for i in range(n):
     #      sum_row=0
     #      sum_col=0
     #      for j in range(n):
     #           sum_row+=m[i][j]
     #           sum_col+=m[j][i]
     #      if not(sum_row==sum_col==sum_diag1):
     #           return False

     # return True

          # for col in range(len(m[row])):
          #      if not( m[row][col] > 0 and m[row][col] < n**2):
          #           return False

     # # TEST CONDITION 2

     sum_elements = sum(m[row])
     # print(sum_elements)
     # #testing rows
     for row in range(len(m)):
          for col in range(len(m[row])):
               if sum(m[row]) != sum_elements:
                    return False
     
     # #testing columns
     
     
     for col in range(len(m)):
          sum_col = 0
          for row in range(len(m)):
               sum_col = sum_col + m[row][col]
          if sum_col != sum_elements:
               return False

     # #testing diagonals
     # sum_diag1 = 0
     # sum_diag2 = 0
     # while row <= len(m):
     #      while col <= len(m):
     #           sum_diag1 = sum_diag1 + m[row][col]
     #           row += row
     #           col += col
     
     # if sum_elements != sum_diag1:
     #      return False
     # return True

     for i in range(1,(n**2)):
          if i not in m: 
               return False
     # check row sums
     for r in m:
          if sum(r) != sum(m[0]):
               return False
     
    # check column sums
     cols = [[r[c] for r in m] for c in range(len(m[0]))]
     for c in cols:
          if sum(c) != sum(m[0]):
               return False
       
     return True
# main
# TESTING OF magic functions

# this should print True

m0=[[2,7,6],[9,5,1],[4,3,8]]
print(magic(m0))
    
# this should print True
m1 = [[16,3,2,13], [5,10,11,8],[9,6,7,12], [4,15,14,1]]
print(magic(m1))
    
# this should print False. Why? Which condition imposed on magic squares is not true for m3
m2 = [[1,2,3,4], [5,6,7,8],[9,10,11,12], [13,14,15,16]]
print(magic(m2))
    
#this should print False. Why? Which condition imposed on magic squares is not true for m3
m3 =  [[1,1],[1,1]]
print(magic(m3))

# #this should print False. Why? Which condition imposed on magic squares is not 
m3 =  [[1,1],[1,1],[1,2]]
print(magic(m3))
