def sum_odd_while_v2(n):
   '''(int)->int
        Returns the sum of all odd integers between 5 and n
        '''
   i = 5
   sum_1 = 0
   while i <= n and n > 0:
      while (i % 2 != 0):
         sum_1 = sum_1 + i
         i = i + 1
      i = i + 1
   return sum_1


