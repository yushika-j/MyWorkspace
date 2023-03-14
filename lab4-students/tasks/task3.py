s = '''It was the best of times, it was the worst of times; 
it was the age of wisdom, it was the age of foolishness; 
it was the epoch of belief, it was the epoch of incredulity; 
it was ...'''
#(a) Write a sequence of statements that produce a copy of s, named newS, 
# in which characters ., ,, ;, and \n have been replaced by blank spaces.
s1 = s.replace(","," ")
s2 = s1.replace(";"," ")
s3 = s2.replace("."," ")
newS = s3.replace("\n"," ")
print(newS)

#(b) Remove leading and trailing blank spaces in newS (and name the new 
# string newS). 
newS = newS.strip()

# (c) Make all the characters in newS lowercase (and name the new string 
# newS). 
newS = newS.lower()

# (d) Compute the number of occurrences in newS of string 'it was'.
#print(newS.count("It was"))

# (e) Change every occurrence of was to is (and name the new string newS).
newS = newS.replace("was", "is")
print(newS)