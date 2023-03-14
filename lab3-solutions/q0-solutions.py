
############# PART 1 ##############

def info_day(today, weather, temperature):
     print(today, "is a", weather, "day. The temperature is", temperature, "degrees Celsius.")

     #Create a string s below such that print(s) command below
     #prints the exact same message as the above print statement.
     # Once you are done, uncomment the two lines of code below
     s=today+" is a "+weather+" day. The temperature is "+str(temperature)+" degrees Celsius."
     print(s)

info_day("Saturday", "nice", 29)
info_day("Monday", "so so", 15)

############# PART 2 #############

# Uncomment the 3-4 lines of code starting with def below.
# Run the program. Why does it crash?
# Can you fix it without chaning function call: letter_grade("B")

#def letter_grade("grade"):
#     print("Your grade is", "grade")
#
#letter_grade("B")

# correct: grade is a parameter (i.e. an input variable) of function letter_grade. 
def letter_grade(grade):
     print("Your grade is", grade)

letter_grade("B")


############# PART 3 #############

# Rewrite the following program so that it computes the average
# in a function called average_of_two. 
# Obtaining the input from the user and printing of the result
# must still be outside of the the function.
#
# Make sure to write DOCSTRINGS for your function, including TYPE CONTRACT.
# Test it by running help(average_of_two) in python shell.

#x=float(input("Give me 1st number: "))
#y=float(input("give me 2nd number: "))
#
#=(x+y)/2
#
#print("The average of", x, "and", y,"is", average)

def average_of_two(num1, num2):
     '''(number,number)->number
     Returns the avearge of two numbers num1 and num2
     '''
     return (num1+num2)/2

x=float(input("Give me 1st number: "))
y=float(input("give me 2nd number: "))

average=average_of_two(x,y)
print("The average of", x, "and", y,"is", average)


