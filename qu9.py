

def least_freq_grade(d):
    x = (min(d, key=d.get))
    return(d[x])
    
d = {"Ali":22, "Moh":25, "Yehya":25, "Ahmad":20, "Hiba":20, "Taylor":20, "Donal":25, "Alex":25, "Zainb":22}
print(least_freq_grade(d))