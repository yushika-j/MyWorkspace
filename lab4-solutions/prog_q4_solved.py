number=int(input("Enter a positive integer: "))
char=input("Enter a character ")

# half piramid
for i in range(number+1):
     print (i*char)


# challenge: full piramid
for i in range(number+1):
     print((number-i)*' ', end='')
     print ((i-1)*char+i*char, end='')
     print((number-i)*' ')

     
