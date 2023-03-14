def pyramid(num,character):
    for i in range(1,num+1):
        print(character*i)
        i = i + 1
print(pyramid(8,"#"))