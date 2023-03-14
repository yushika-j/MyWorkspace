# Implement function reverse_int() that takes a three-digit integer as input
# and returns the integer obtained by reversing its digits. For example, if the input is 123,
# your function should return 321. You are not allowed to use the string data type operations
# to do this task. Your program should simply read the input as an integer and process it as an
# integer using operators such as // and %. You may assume that the input integer does not
# end with the 0 digit.

def reverse_int(myNum):
    myNum= int(myNum)
    num1 = ((myNum%10)) 
    num2 = ((myNum//10)%10) 
    num3 = (myNum//100)
    reverse_num = str(num1) +str(num2) +str(num3)
    return reverse_num
myNum = input("Enter a 3-digit integer: ")
print(reverse_int(myNum))