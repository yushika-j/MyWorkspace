'''
I understand the importance of professional integrity in my education and future career
in engineering or computer science. I hereby certify that I have done and will do all work
on this examination entirely by myself, without outside assistance or the use of unauthorized
information sources. Furthermore, I will not provide assistance to others.
'''

# READ THE ABOVE STATEMENT
#
# Yushika Parvisha Jhundoo
# 300269830
# By putting your name here you are signing the statement above and
# agreeing to the TEST 1 (integrity rules) listed on the first page of the test

def danube(s): # 10 points
    '''(str)-> none
    Precondition: s contains only letters A,B,C,F
     '''
     
     # YOUR CODE GOES HERE
    A = s.count("A")
    B = s.count("B")
    C = s.count("C")
    F = s.count("F")
    count = 0
    total = A + B + C + F
    resultA = round(A / total,2)*100
    resultB = round(B / total,2)*100
    resultC = round(C / total,2)*100
    resultF = round(F / total,2)*100
    
    highest = (max(A,B,C,F))
    if highest == A:
        median = "A"
    elif highest == B:
        median = "B"
    elif highest == C:
        median = "C"
    elif highest == F:
        median = "F"
    print(resultA,"%, ",resultB,"%, ",resultC,"%, ",resultF,"% " , "of the students got A, B, C and F respectively.")
    print("Median is", median) 

      
def irtysh(n): # 10 points
     '''(number)-> bool
     Preconditions: n=1 or n a positive 5 digit integer'''
     count = 0
     if n == 1:
    
        n = input("Enter a positive integer")
    
        for i in range(1,n):
            if n % i == 0:
                    count = count + 1
        if count == 3:
          return True
        else:
          return False
     else:
         result = (n % 1000)//100
         return result 



def helper(s1,s2): #4 points
     '''(str,str)-> number
     Preconditions: s1 and s2 are strings containg digits only'''
     s1 = int(s1)
     s2 = int(s2)
     if ((s1 % 2 == 0) and (s2 % 2 == 0 )) or ((s1 % 2 != 0) and (s2 % 2 != 0 )):
          sum_1 = int(s1) + int(s2)
          return sum_1
     else:
          product_1 = int(s1) * int(s2)
          return product_1
     

def yangtze(s): # 6 points
     '''(str)-> None
     Preconditions: len(s) is not zero & len(s)%3==0
     and s contains digits only'''
     
     # YOUR CODE GOES HERE
     length_1 = ""
     length_2 = ""
     for i in range(0,len(s)-1):
          length_1 = length_1 + s[i]
          length_2 = length_2 + s[i+1:i+3:2]
     result = helper(length_1,length_2)

     print("the string made of substrings of length one is: " + length_1)
     print("the string made of substrings of length two is: " + length_2)
     print("Thus the required result is" , result)

 
