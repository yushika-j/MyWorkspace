def create_alctable(file_name):
    '''(str)->list of lists where each "inner" list has 3 elements
    Returns the list as described above
    '''

    # this opens, reads the file and places each line as a string into list called alc
    alc=open(file_name).read().splitlines()
    
    print("\nHere is what is in alc after open(file_name).read().splitlines() is run:\n")
    print(alc)

    # run help(list.pop) in Python shell to see what method .pop() does
    # the next 3 lines remove the first three lines/elements of alc.
    alc.pop(0)
    alc.pop(0)
    alc.pop(0)
    print("\nHere is what is alc after first 3 lines/elements of alc are removed:\n")
    print(alc)

    # make empty table 
    alc_table=[]

    print()
    # this for loop populates the table with lists containing info about each metal in the file
    for metal in alc:
        metal=metal.split(" ")
        print("Here is what the info about each metal looks like after a split:")
        print(metal)
        name=metal[0].strip() #.strip() cleans up extra white space if there is any
        atomic_num_str=metal[1].strip()
        # the next line figures out what the atomic number is (by ignoring star)
        atomic_num=int(atomic_num_str[ : len(atomic_num_str) -1]) 
        atomic_weight=float(metal[2].strip())

        # add the list cointaing info about current metal to the table
        alc_table.append( [ name,atomic_num, atomic_weight  ]  )       
 
    return alc_table

def nice_print(table):
    for metal in table:
        for info in metal:
            print(info, end='  ')
        print()
        
        
# main
file_name=input("Enter the name of the file: ")
file_name=file_name.strip()
alc_table=create_alctable(file_name)
print("\nHere is what the final 2Dlist/table looks like:\n")
print(alc_table)

print("\nHere is what it looks like in humany printable form:\n")
nice_print(alc_table)


