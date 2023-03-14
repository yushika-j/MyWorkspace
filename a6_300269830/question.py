class bankAccount:

    def __init__(self,bal=0):
        'initialises balance to 0'
        self.bal = bal
    
    def withdraw(self,amount):
        self.bal = self.bal - amount
        return self.bal

    def deposit(self,amount):
        self.bal = self.bal + amount
        return self.bal
    
    def balance(self):
        return self.bal