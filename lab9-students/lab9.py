#prog ex dic 1
def letter2number1(lgrade):
    #VERSION 1 ( WITH IF STATEMENTS )
    if lgrade == "A+":
        return 10
    elif lgrade == "A":
        return 9
    elif lgrade == "A-":
        return 8
    elif lgrade == "B+":
        return 7
    elif lgrade == "B":
        return 6
    elif lgrade == "C+":
        return 5
    elif lgrade == "C":
        return 4
    elif lgrade == "D+":
        return 3
    elif lgrade == "D":
        return 2
    elif lgrade == "E":
        return 1
    elif lgrade == "F":
        return 0

def letter2number2(lgrade):
    # VERSION 2 USING DICTIONARY
    studentgrade = {'A+' : 10,'A':9,'A-':8,'B+':7,'B':6,'C+':5,'C':4,'D+':3,'D':2,'E':1,'F':0}
    return studentgrade[lgrade]

#prog ex dic 2
def agency():
    agencies = {"CCC": "Civilian Conservation Corps","FCC":"Federal Communications Commission",
    "FDIC":"Federal deposit insurance corporation","SSB":"Social Security Board","WPA":"Works Progress Administration"}
    #add item
    agencies["SEC"]= "Securities and Exchange Commission"
    print(agencies)
    #change value
    agencies["SSB"]= "Social Security Administration"
    print(agencies)
    #remove item
    agencies.pop("CCC")
    print("AFTER REMOVING CCC FROM DICTIONARY")
    print(agencies)
    agencies.pop("WPA")
    print("AFTER REMOVING WPA FROM DICTIONARY")
    return agencies

#print(agency())


#Prog ex Dic 3 (from the textbook):
def lookup(phonebook):

    first = input("Enter the first name: ")
    last = input("Enter the last name: ")
    person = (first,last)
    for i in phonebook:
        if person in phonebook:
            print(phonebook[person])
    

#Prog ex Dic 4 (from the textbook):
def reverse(phonebook):
    '''(dictionary)->(dictionary)'''
    #phone_number = input("Enter the phone number: ")
    #book = phonebook
    
    for person in phonebook.copy():
        temp = person
        
        person = phonebook[person]
        
        phonebook[person] = temp
        phonebook.pop(temp)

        
    return phonebook
phonebook = {'Smith,Jane':'123-45-67','Baker,David':'567-54-87'}
#print(reverse(phonebook))

###############################################
#programming ex 0
###############################################
def getyear():
    '''(none)-> number'''
    try:
        year = input("Enter a 4-digit number: ")
        if len(year) != 4:
            while (len(year)!=4 ) :
                year = input("Number must contain 4 digits. Enter again: ")
        year = int(year)
        
    
    
        #year = input("Enter a 4-digit number: ")
    except ValueError:
        print("Value cannot be converted to an integer!")
    except:
        print("Error")
    return (year)
    
#print(getyear())

############################################################
# PROGRAMMING EXERCISE 2    
############################################################
def min_or_max_index(lst,bool):
    '''(lst,boolean)->(number, number)'''
    min = 10000
    max = -10000
    for i in range(0,len(lst)):
        if lst[i]>max:
            max = lst[i]
        if lst[i]< min:
            min = lst[i]
    
    if bool == True:
        return (min,lst.index(min))
    else:
        return (max,lst.index(max))
#print(min_or_max_index([1,3,5,6,90,7,5,34,2,7],False))
#print(min_or_max_index([1,3,5,6,90,7,5,34,2,7],True))

########################################################
#Programming exercise 3
########################################################
def first_one(L):
    for i in range(0,len(L)):
        if L[i] == 1:
            return i
#print(first_one([0,0,0,0,0,0,1,1,1,1,1]))
