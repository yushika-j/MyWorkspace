def pay(rate, hours):
    '''
       (number, number)->number
       returns wage based on rate and hours

       Any hours beyond 40 but less than or equal 60 are paid at
       1.5 times the regular hourly wage. Any hours beyond 60 are
       paid at 2 times the regular hourly wage'''
    if hours <= 40:
        return hours*rate
    elif hours <= 60:
        return 40*rate+(hours-40)*1.5*rate
    else:
        return 40*rate+20*1.5*rate+(hours-60)*2*rate




def rps(play1, play2):
    '''    (str, str)->int

       takes choices ('R', 'P', or 'S') of player 1 and 2,
       and returns -1 if player 1 wins, 1 if player 2 wins,
       or 0 if there is a tie'''
    
    if play1 == play2:
        return 0
    if (play1 == 'P' and play2 == 'R') or (play1 == 'R' and play2 == 'S') or (play1 == 'S' and play2 == 'P'):
        return -1
    else:
        return 1
