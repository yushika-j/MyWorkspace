
def is_eligible(age, citizenship, prison):
     '''(int, str, str)->bool
     Returns true if a person is eligible to vote, and false otherwise
     '''
     citizenship=citizenship.lower()
     citizenship=citizenship.strip()
     prison=prison.lower()
     prison=prison.strip()
     if((citizenship=='canada' or citizenship=='canadian') and (age >=18) and (prison=='no')):
          return True
     else:
          return False
     
name=input("What is your name? ")
age= int(input("How old are you? "))
citizenship=input("What is your citizenship? ")
criminal_record=input("Do you currently live in prison convicted of crime? ")

if is_eligible(age, citizenship, criminal_record):
     print(name, ", you are eligible to vote")
else:
     print(name, ", you are ineligible to vote") 
    



          
