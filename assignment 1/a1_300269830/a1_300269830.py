#Name : Parvisha Jhundoo
#ITI 1120
#Assignment 1
#Student number : 300269830

###################################################################
 # Question 1
 ###################################################################
def mh2kh(s):
   '''(number)->number
   Returns kilometer per hour, given miles per hour'''
    kilometer = float(s)*1.609344
    return kilometer



###################################################################
 # Question 2
 ###################################################################
from math import *
def pythagorean_pair(a,b) :
    '''(number,number)-> boolean
    Returns a boolean stating if the 2 parameters are a pythagorean pair'''
    #temp = pow(float(a),2) + pow(float(b),2)
    a= float(a)
    b=float(b)
    
    temp= sqrt((a*a) + (b*b))

    return temp.is_integer()

       


 ###################################################################
 # Question 3
 ###################################################################
def in_out(xs,ys,side):
    '''(number,number,number)-> boolean
    Returns a boolean stating if the given coordinates lie inside the square or not
    Pre-condition: xs,ys and side are positive numbers.'''
    my_x = input("Enter a number for the x coordinate of a query point: ")
    my_y = input("Enter a number for the y coordinate of a query point: ")
    x_1 = (float(my_x) >= float(xs)) and (float(my_x)<= (float(xs)+ float(side))) 
    y_1 = (float(my_y) >= float(ys)) and (float(my_y) <= (float(ys)+ float(side)))
    return x_1 and y_1


 ###################################################################
 # Question 4
 ###################################################################
from math import *
def safe(n) :
    '''(number)-> boolean
    Returns a boolean stating if the parameter passed is safe or not'''
    result = (float(n) > 0) and (float(n) < 100) 
    x = not("9" in str(n))
    is_safe = (result and not((float(n) % 9)== 0) and x)
    return is_safe

 ###################################################################
 # Question 5
 ###################################################################
def quote_maker(quote, name, year):
    '''(string,string,string)-> None
    Returns a string which concatenates a text'''
    print("In year " + year + ", a person called " + name + " said: \" " + quote + "\" ")


 ###################################################################
 # Question 6
 ###################################################################
def quote_displayer():
    '''(None)-> none
    Displays a text using user's inputs'''
    quote = input("Give me a quote: ")
    name = input("Who said that?: ")
    year = input("In what year did he/she say that?: ")
    print("In year " + year + ", a person called " + name + " said: \"" + quote + "\" ")


 ###################################################################
 # Question 7
 ###################################################################

def rps_winner():
    '''(none)->none
    Returns a text showing if it is a tie or who is the winner.'''
    winner_1 = False
    tie = False
    player_1 = input("What choice did player 1 make?  \n Type one of the following options: rock, paper, scissors: ")
    player_2 = input("What choice did player 2 make? \n Type one of the following options: rock, paper, scissors: ") 
    winner_1 = "rock" in player_1 and "scissors" in player_2
    if player_1==player_2:
        winner_1 = False

    if player_1 == "rock" :
        if player_2== "paper":
            #player2 wins
            winner_1== False
        elif player_2 == "scissors":
            #player1 wins
            winner_1 == True

    
    if player_1 == "paper" :
        if player_2== "scissors":
            #player2 wins
            winner_1== False
        elif player_2 == "rock":
            #player1 wins
            winner_1 == True


        if player_1 == "scissors" :
            if player_2== "rock":
            #player2 wins
             winner_1== False
        elif player_2 == "paper":
            #player1 wins
            winner_1 == True     

    print("Player 1 wins. That is " , winner_1 )
    print("It is a tie. That is not " , (winner_1) )


 ###################################################################
 # Question 8
 ###################################################################
from math import *
def fun(x):
    '''(number)->number
    Solves a logarithmic equation for the term y'''
    y = (log((float(x) + 3), 10) / 4)
    return(y)

 ###################################################################
 # Question 9
 ###################################################################
def ascii_name_plaque(name):
    '''(none)-> none
    Prints a string(parameter) in a box'''
    print(len(name)*("*")+("******"))
    print("*" , (len(name)*(" ")) , "  *")
    print("*__" + name + "__*")
    print("*" , (len(name)*(" ")) , "  *")
    print((len(name)*("*"))+("******"))


 ###################################################################
 # Question 10
 ###################################################################
def reverse_int(myNum):
    '''(number)-> number
    Reverses an integer and outputs it
    Pre-condition: myNum is an integer value'''
    myNum= int(myNum)
    num1 = ((myNum%10)) 
    num2 = ((myNum//10)%10) 
    num3 = (myNum//100)
    reverse_num = str(num1) +str(num2) +str(num3)
    return reverse_num

 ###################################################################
 # Question 11
 ###################################################################
def alogical(n):
    '''(number)->number
    Returns the number of times n can be divided by 2'''
    #use of recursion
    def recursive_alogical(n, i=1):
        return (i and n <= 1) or recursive_alogical(n // 2, i + 1)
    #print(i and n<=1)
    #print(recursive_alogical(n//2, i+1))
    return alogical(n)

###################################################################
 # Question 12
 ###################################################################
def cad_cashier(price,payment):
    '''(number,number)->number
    Returns the amount of change due to customer.
    Pre-condition: payment should be 2 decimal places'''
    #rounding off payment to 2 decimal places
    payment = 0.5 * round((payment/0.5),1)
    
    #calculating change to be returned to customer
    customer_change = payment - price
    customer_change = 0.5 * round((customer_change/0.5),1)
    return customer_change



 ###################################################################
 # Question 13
 ###################################################################
from math import *
def min_CAD_coins(price,payment):
    '''(number,number) -> number,number,number,number,number
    Returns the number of times each coin has to be given to customer so that it equals the customer change in less coins possible.
    Pre-condition: must call function min_CAD_coins to obtain customer change'''
    customer_change = cad_cashier(price,payment)
    #converting change into cents
    change_in_cents = int((customer_change) * 100)
    #toonies
    t = floor((change_in_cents) / 200)
    #loonies
    l = ((change_in_cents % 200) // 100)
    #quarter
    q = (((change_in_cents % 200) % 100) // 25)
    #dimes
    d = (((( change_in_cents % 200)% 100) % 25) // 10)
    #nickels
    n = (((((change_in_cents % 200)% 100) % 25) % 10) // 5)
    return print((t,l,q,d,n))

