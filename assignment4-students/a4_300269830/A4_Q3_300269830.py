def longest_run(lst):
    count = 1
    for i in range(0,len(lst)-1):
            if lst[i] == lst[i + 1] :
                count = count + 1
    return count
raw_input = input("Please input").strip().split()
print(longest_run(raw_input))
