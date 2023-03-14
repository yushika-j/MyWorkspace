def two_length_run(lst):
    if len(lst) == 1:
        return False
    else:
        answer = False
        for i in range(0,len(lst)):
            if lst[i] == lst[i + 1] :
                return True
        return answer
raw_input = input("Please input a list of numbers separated by space: ").strip().split()
print(two_length_run(raw_input))