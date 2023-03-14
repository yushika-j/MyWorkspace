import random
def craps():
    lst =[2,3,7,12,11]
    dice1=random.randint(1,6)
    dice2=random.randint(1,6)
    total = dice1 + dice2
    if total == 7 or total == 11:
        return 1
    elif total == 2 or total == 3 or total == 12:
        return 0 
        
    while total not in lst:

        dice1=random.randint(1,6)
        dice2=random.randint(1,6)
        total = dice1 + dice2
        if total == 7 or total == 11:
            return 1
        elif total == 2 or total == 3 or total == 12:
            return 0 
#print(craps())


def testcraps(n):
    win = 0
    lose = 0
    for i in range(0,n):
        dice1=random.randint(1,6)
        dice2=random.randint(1,6)
        total = dice1 + dice2
        if total == 7 or total == 11:
            win = win + 1
        elif total == 2 or total == 3 or total == 12:
            lose = lose + 1
    return (win/(n))
#print(testcraps(10000))