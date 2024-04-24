sum_while = 0
num_while = 524
while num_while <= 10508:
    if num_while % 2 == 0:
        sum_while += num_while
    num_while += 1
print("Sum using while loop:", sum_while)