# Write function called pay that takes as input an hourly wage and the 
#question 1
def pay(hourly_wage,number_of_hours):
    '''(number,number)-> number
    Calculates the pay of employee using 2 parameters'''
    if number_of_hours < 40:
        employee_pay = hourly_wage * number_of_hours
    if number_of_hours >= 40 and number_of_hours <=60:
        employee_pay = (hourly_wage * 40)+ ((hourly_wage *1.5) * (number_of_hours - 40 ))
    elif number_of_hours > 60 :
        employee_pay = (hourly_wage * 40)+ (20* hourly_wage * 1.5) + ((hourly_wage * 2) * (number_of_hours - 60 ))
    return employee_pay


#question 2
# Write a function called rps that takes the choice 'R', 'P', or ‘S' of 
# player 1 and the choice of player 2, and returns −1 if player 1 wins, 1 if player 
# 2 wins, or 0 if there is a tie
def rps(player_1,player_2):

    '''(text,text)-> integer
    takes the input of player 1 and player 2 and outputs the answer of the game'''

    if player_1 == player_2:
        return 0
    if player_1 == "R":
        if player_2 == "S":
            return -1
        elif player_2 == "P":
            return 1
    if player_1 == "P":
        if player_2== "R":
            return -1
        elif player_2== "S":
            return 1
    if player_1 == "S":
        if player_2== "P":
            return -1
        elif player_2== "R":
            return 1



#question 3a
# The function is_divisible has two input parameters that are integers 
# n and m and returns True if n is divisible by m and False otherwise. 
# • Outside of that function, your program should interact with the user to get 
# two integers. To determine if the 1st is divisible by the 2nd it should call 
# is_divisible function. It should print a message explaining the result.
def is_divisible(n,m):
    '''(number,number)-> none
    checks if n is divisible by m and outputs a suitable message'''
    
    if n % m == 0:
        print(n ," is divisible by " , m)
    else:
        print(n ," is not divisible by " , m)

n = int(input("Enter 1st integer:"))
m = int(input("Enter 2nd integer:"))
is_divisible(n,m)
