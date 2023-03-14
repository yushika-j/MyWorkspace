# Write a function
# alogical(n) , that takes as
# input a number, n, where n
# is bigger or equal to 1, and
# returns the minimum
# number of times that n
# needs to be divided by 2 in
# order to get a number
# equal or smaller than 1. For
# example 5.4/2=2.7. Since
# 2.7 is bigger than 1, dividing 5.4 once by 2 is not enough, so we continue. 2.7/2=1.35
# thus dividing 5.4 twice by 2 is not enough since 1.35 is bigger than 1. So we continue.
# 1.35/2=0.675. Since 0.675 is less than 1, the answer is 3. In particular, these
# calculations determine that 5.4 needs to be divided by 2 three times minimum in order
# to get a number that is less than or equal to 1.
def alogical(n):
    n = float(n)
    n = (n // 2)
    count = int()
    count = count + 1 
    print(count)
    return (alogical(n//2)) 
