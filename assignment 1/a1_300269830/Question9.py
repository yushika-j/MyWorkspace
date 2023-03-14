# Write a function ascii_name_plaque(name) that takes as input a string
# representing a person’s name and draws (using print function) a name plaque as shown
# in the examples given in Section 2 below.




def ascii_name_plaque(name):
    print(len(name)*("*")+("******"))
    print("*" , (len(name)*(" ")) , "  *")
    print("*__" + name + "__*")
    print("*" , (len(name)*(" ")) , "  *")
    print((len(name)*("*"))+("******"))
name_1 = input("enter name: ")
ascii_name_plaque(name_1)