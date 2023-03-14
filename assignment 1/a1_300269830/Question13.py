
from Question12 import cad_cashier

from math import *
def min_CAD_coins(price,payment):
    customer_change = cad_cashier(price,payment)
   
    change_in_cents = int((customer_change) * 100)
    
    t = floor((change_in_cents) / 200)
    
    l = ((change_in_cents % 200) // 100)
    print(l)
    q = (((change_in_cents % 200) % 100) // 25)
    print(q)
    d = (((( change_in_cents % 200)% 100) % 25) // 10)
    n = (((((change_in_cents % 200)% 100) % 25) % 10) // 5)
    return print((t,l,q,d,n))

print(min_CAD_coins(3,20))

