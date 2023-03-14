#  Write a function quote_maker(quote, name, year) that returns a sentence,
# i.e. a string of the following form: In year, a person called name said: “quote”
# See the next Section 2 below for some examples of how your function must behave.

def quote_maker(quote, name, year):

    print("In year " + year + ", a person called " + name + " said: \" " + quote + "\" ")

quote = input()
name= input()
year= input()
print(quote_maker(quote,name,year))