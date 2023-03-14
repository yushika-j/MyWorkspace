def mh2kh(s):
   
    kilometer = float(s)*1.609344
    print(str(s) + " miles is equivalent to " +str(kilometer) +" kilometers per hour")
    return kilometer
s = input("How many miles per hour? ")

mh2kh(s)

