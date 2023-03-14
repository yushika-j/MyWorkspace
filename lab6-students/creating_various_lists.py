import random
n=int(input("Enter a positive even integer for the size of the list?: " ))
a = n*[0]
b =[]
for number in range(0,n):
    b.append(random.randint(1,100))
c = b[:]
for i in range (0,(len(c)//2)):
        c[i] = 0
print(b)
print(c)
d = b
e = []
for items in b:
    if b.index(items) % 2 != 0:
        e.append(items)

print(e)
