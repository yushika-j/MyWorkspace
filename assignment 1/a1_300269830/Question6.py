
#     Write a function quote_displayer() that prompts the user for a quote, name,
# and year. The function should then print a sentence using the same format as
# specified in the previous question. (To do that, your solution must make a call
# to quote_maker function from the previous question to obtain a string that you then
# print).
def quote_displayer():
    quote = input("Give me a quote: ")
    name = input("Who said that?: ")
    year = input("In what year did he/she say that?: ")
    print("In year " + year + ", a person called " + name + " said: \"" + quote + "\" ")

quote_displayer()