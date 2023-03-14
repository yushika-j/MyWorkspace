###############################################################
# Question 1 ###################################################
from math import *
'''(string,number,string)-> string
It outputs the string n times with a deliminator character in between'''
def repeat(string,n,delim):
    text_1 = (string + delim) * (n-1)
    text_1= text_1+string
    return text_1

###############################################################
# Question 2 ###################################################
def points(x1,y1,x2,y2):
    if x1-x2 == 0:
        slope = "infinity"
    else:
        slope = (y2-y1)/(x2-x1)
    distance = sqrt(((x2-x1)**2) + ((y2-y1)**2))
    return print("The slope is " , slope , " and the distance is " , distance)


###############################################################
# Question 3 ###################################################
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

###############################################################
# Question 4 ###################################################
def leap(year):
    '''(number)-> boolean
    Takes a year as a parameter and returns true if it is a leap year'''
    if (year % 100) == 0 and (year % 400) != 0:
        return False
    if (year % 4) != 0 :
        return False
        
    else:
        return True


###############################################################
# Question 5 ###################################################
def month_apart(month_1, date_1 ,month_2, date_2 ):
    '''(number,number,number,number)-> None
    Checks if 2 given months are more than a month apart'''
    dates_list = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    month_list = ["January","February","March", "April","May","June","July","August","September","October","November","December"]
    print(month_list[(month_1 - 1)])
    if month_1 == month_2:
        answer = False
    elif (abs(month_1 - month_2) >= 2) :
        answer = True
    elif month_1-month_2 == 1:
        if date_1 >= date_2:
            answer = True
        else:
            answer = False
    elif month_2 - month_1 == 1:
        if date_2 >= date_1:
            answer = True
        else:
            answer = False
    if answer == True:
        print("month_apart(",month_1,",",date_1,",",month_2,",",date_2 ,") should return " , answer , ",     because " , month_list[(month_1 - 1)] , date_1 , "is at least a month before" , month_list[(month_2 - 1)] , date_2)

    else:
        print("month_apart(",month_1,",",date_1,",",month_2,",",date_2 ,") should return " ,answer , ",     because " , month_list[(month_1 - 1)] , date_1 , "isn't at least a month before" , month_list[(month_2 - 1)] , date_2)


###############################################################
# Question 6(a) ###################################################
def allTheSame(x,y,z):
    '''(number,number,number)-> boolean
    Takes 3 numbers x,y,z and returns true if they are all the same'''
    if x == y and y == z and x == z:
        return True
    else:
        return False


##############################################################
# Question 6(b) ###################################################
def allDifferent(x,y,z):
    '''(number,number,number)-> boolean
    Takes 3 numbers x,y,z and returns true if they are all different'''
    if x != y and y != z and x != z:
        return True
    else:
        return False


##############################################################
# Question 6(c) ###################################################
def allSorted(x,y,z):
    '''(number,number,number)-> boolean
    Takes 3 numbers x,y,z and returns true if they are all the sorted'''
    if x < y and x < z:
        if y > x and y < z:
            return True
        else: 
            return False
    else: 
        return False


##############################################################
# Question 7 ###################################################
def letter2number(grade):
    '''(string)-> integer
    Takes a grade and returns the corresponding numeric value of the grade'''
    if grade[0] == "A":
        num_value = 4
    elif grade[0] == "B":
        num_value = 3
    elif grade[0] == "C":
        num_value = 2
    elif grade[0] == "D":
        num_value = 1
    elif grade[0] == "F":
        num_value = 0
    if grade[1] == "+":
        num_value = num_value + 0.3
    if grade[1] == "-":
        num_value = num_value - 0.3
    
    return num_value

    ##############################################################
# Question 8 ###################################################

def is_nneg_f(s):
    '''(string)-> boolean
    Takes a string s as parameter and returns True if it contains at most 1 decimal and only digits'''
    count_1 = s.count(".")
    if count_1 <= 1 and s.replace('.', '', 1).isdigit() == True:
        return True
    else:
        return False



 ##############################################################
# Question 9 ###################################################
#from latex2sympy import symbols, solve
def min_enclosing_circle(r,center_x,center_y):
    '''(number,number,number)-> number,number
    Returns the smallest rectangle that fits in the circle whose radius and center coordinates is given'''
    if r < 0 :
        return None
    x = center_x - r
    y = center_y - r

    return (x,y)

##############################################################
# Question 10 ###################################################
def l2lo(w):
    '''(number)-> number,number
    Returns lbs and oz, given a weight'''
    l = int(w)
    o = float((w%1)) * 16
    return (l,o)


##############################################################
# Question 11 ###################################################
def vote_percentage(string):
    '''(string)-> number
    Calculates the percentage yes votes from a string'''
    yes = string.count("yes")
    no = string.count("no")
    abstained = string.count("abstained")
    if yes > no :
        result = (yes / (yes + no))
    elif no > yes:
        result = (yes / (yes + no))
    else:
        result = 0.5

    return result

##############################################################
# Question 12 ###################################################
def vote():
    '''Calculates the percentage yes votes from a string'''
    string = input("Enter the yes, no, abstained votes one by one and then press enter :")
    yes = string.count("yes")
    no = string.count("no")
    abstained = string.count("abstained")
    if yes > no :
        result = (yes / (yes + no))
    elif no > yes:
        result = (yes / (yes + no))
    else:
        result = 0.5
    if result == 1.0:
       return "proposal passes unanimously"
    elif result >= 2/3 :
        return "super majority"
    elif result >= 0.5:
        return "simple majority"
    else:
        return "proposal fails"

##############################################################
# Question 13 ###################################################
def count_even_digits(number,digit_count):
    '''(number,number)-> number
    Returns how many even numbers the string has'''
    string = str(number)
    num_0 = string.count("0")
    num_2 = string.count("2")
    num_4 = string.count("4")
    num_6 = string.count("6")
    num_8 = string.count("8")
    even_number = num_0 + num_2 + num_4 + num_6 + num_8
    return even_number


