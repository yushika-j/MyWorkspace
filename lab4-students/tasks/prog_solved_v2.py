def is_eligible(age,citizenship,convicted):
     if age >=18:
          return True
     if convicted.lower() == "yes":
          if citizenship.lower() == "Canada" or citizenship.lower() == "Canadian":
               return True
          else:
               return False
name=input("What is your name? ")
age= int(input("How old are you? "))
citizenship = input("Enter your citizenship: ")
convicted = input("Have you lived in prison convicted for a criminal offence?: ")
if is_eligible(age,citizenship,convicted) == True:
     print(name, ", you are eligible to vote")
else:
     print(name, ", you are ineligible to vote") 
    



          
