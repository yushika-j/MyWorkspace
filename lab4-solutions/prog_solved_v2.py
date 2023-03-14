def is_eligible(age):
     if age >=18:
          return True
     else:
          return False
     
name=input("What is your name? ")
age= int(input("How old are you? "))

if is_eligible(age):
     print(name, ", you are eligible to vote")
else:
     print(name, ", you are ineligible to vote") 
    



          
