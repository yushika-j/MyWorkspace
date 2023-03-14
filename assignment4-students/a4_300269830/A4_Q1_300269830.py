def number_divisible(lst,n):
    count = 0
    for i in lst:
        i = int(i)
        if i % n == 0:
            count = count + 1
    return print("The number of elements divisible by ", n ,"is", count)
raw_input = input("Please input a list of integers separated by spaces: ").strip().split()
number = int(input("Please input an integer: "))
number_divisible(raw_input,number)