
def cad_cashier(price,payment):
    payment = 0.5 * round((payment/0.5),1)
    
    #calculating change to be returned to customer
    customer_change = payment - price
    customer_change = 0.5 * round((customer_change/0.5),1)
    return customer_change

print(cad_cashier(8.36,10))








#     price = round(abs(price),2)
#     payment = round(abs(payment),2)
#     price = str(price)
#     print(price[-1])
#     decimal = price[-1]
#     decimal = "0." + decimal
#     decimal = round(float(decimal),0)
#     print(decimal)
#     # change = payment-price
#     # return change
# print(cad_cashier(-23.7948,45.82948))
