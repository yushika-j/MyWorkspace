
############# PART 1 ##############

def info_day(today, weather, temperature):
     '''(string,string,string)-> none
     Prints an output message consisting the 3 parameters'''
     print(today, "is a", weather, "day. The temperature is", temperature, "degrees Celsius.")

     #Create a string s below such that print(s) command below
     #prints the exact same message as the above print statement.
     # Once you are done, uncomment the two lines of code below
     
     s = today + " is a "+ weather + " day. The temperature is "+ str(temperature) + " degrees Celsius."
     print (s)

info_day('Saturday', 'nice', 29)
info_day('Monday', 'so so', 15)

############# PART 2 #############

# Uncomment the 3-4 lines of code starting with def below.
# Run the program. Why does it crash?
# Can you fix it without chaning function call: letter_grade("B")

def letter_grade(grade):
     '''(number)-> none
     Takes a grade as input and outputs it as a message'''
     print("Your grade is", grade)

letter_grade("B")

############# PART 3 #############


def average_of_two(x,y):
     '''(number,number)-> (number)
     Takes 2 numbers as parameter and returns the average of both inputs'''

     average=(x+y)/2
     return print("The average of", x, "and", y,"is", average)
     
x=float(input("Give me 1st number: "))
y=float(input("give me 2nd number: "))
average_of_two(x,y)


