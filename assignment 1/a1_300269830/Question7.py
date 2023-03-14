# In this question you will write a function that determines and prints the
# result of a rock, paper, scissors game given choices of player 1 and player 2. In
# particular, write a function rps_winner() that prompts the user for choice of player 1
# and then choice of player 2, and then it displays the result for player 1 as indicated in
# the examples given in Section 2. You may assume that the user will only enter words:
# rock, paper or scissors in lower case. Recall that paper beats rock, that rock beats
# scissors and that scissors beat paper. If both players make the same choice, we have a
# draw.

def rps_winner():
    winner_1 = False
    tie = False
    player_1 = input("What choice did player 1 make?  \n Type one of the following options: rock, paper, scissors: ")
    player_2 = input("What choice did player 2 make? \n Type one of the following options: rock, paper, scissors: ") 
    winner_1 = "rock" in player_1 and "scissors" in player_2
    if player_1==player_2:
        winner_1 = False

    if player_1 == "rock" :
        if player_2== "paper":
            #player2 wins
            winner_1== False
        elif player_2 == "scissors":
            #player1 wins
            winner_1 == True

    
    if player_1 == "paper" :
        if player_2== "scissors":
            #player2 wins
            winner_1== False
        elif player_2 == "rock":
            #player1 wins
            winner_1 == True


        if player_1 == "scissors" :
            if player_2== "rock":
            #player2 wins
             winner_1== False
        elif player_2 == "paper":
            #player1 wins
            winner_1 == True     

    print("Player 1 wins. That is " , winner_1 )
    print("It is a tie. That is not " , (winner_1) )
rps_winner()