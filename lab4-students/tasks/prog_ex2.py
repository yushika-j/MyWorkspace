def mess(s):
    
    for i in s:
        letter = s[i]
        i=i+1
        
        if letter in 'rstuvwxyz' :
            if int(ascii(i)) >= 114 and int(ascii(i))<= 122:
                s.replace(letter, letter.upper())

    
        #         i = i + 1
        # letter_1 = s[i].upper()
        # if (s[i] == 'r' or s[i] =='s' or s[i] == 't' 
        # or s[i] == 'v' or s[i] == "w" or s[i] ==  'x' or s[i] == 'y' or s[i] == 'z'):
        #     s.replace(letter,letter_1 )
        #     return s
        #     s.replace(s[i],s[i].upper())
        #     i = i + 1
    # s.replace(" ", "-")
    
print(mess('Random access memory'))