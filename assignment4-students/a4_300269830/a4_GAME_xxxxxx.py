# In this implementation a card (that is not a 10) is represented
# by a 2 character string, where the 1st character represents a rank and the 2nd a suit.
# Each card of rank 10 is represented as a 3 character string, first two are the rank and the 3rd is a suit.

import random

def wait_for_player():
    '''()->None
    Pauses the program until the user presses enter
    '''
    try:
         input("\nPress enter to continue. ")
         print()
    except SyntaxError:
         pass


def make_deck():
    '''()->list of str
        Returns a list of strings representing the playing deck,
        with one queen missing.
    '''
    deck=[]
    suits = ['\u2660', '\u2661', '\u2662', '\u2663']
    ranks = ['2','3','4','5','6','7','8','9','10','J','Q','K','A']
    for suit in suits:
        for rank in ranks:
            deck.append(rank+suit)
    deck.remove('Q\u2663') # remove a queen as the game requires
    return deck

def shuffle_deck(deck):
    '''(list of str)->None
       Shuffles the given list of strings representing the playing deck    
    '''
    random.shuffle(deck)
    return deck
#####################################

def deal_cards(deck):
    '''(list of str)-> tuple of (list of str,list of str)

    Returns two lists representing two decks that are obtained
    after the dealer deals the cards from the given deck.
    The first list represents dealer's i.e. computer's deck
    and the second represents the other player's i.e user's list.
    '''
    dealer=[]
    other=[]

     # COMPLETE THE BODY OF THIS FUNCTION ACCORDING TO THE DESCRIPTION ABOVE
     # YOUR CODE GOES HERE
    for cards in range(0,50):
        dealer.append(deck[cards])
        cards = cards + 1
        other.append(deck[cards])

    #print(other)
    # i = 0
    # while i != 51:
    #     card = deck[i]
    #     dealer.append(card)
    #     i = i + 1
    #     card = deck[i]
    #     other.append(card)
    
    return (dealer, other)



def remove_pairs(l):
    '''
    (list of str)->list of str
    Returns a copy of list l where all the pairs from l are removed AND
    the elements of the new list shuffled.

    Precondition: elements of l are cards represented as strings described above.
    Testing:
    Note that for the individual calls below, the function should
    return the displayed list but not necessarily in the order given in the examples.

    remove_pairs(['9♠', '5♠', 'K♢', 'A♣', 'K♣', 'K♡', '2♠', 'Q♠', 'K♠', 'Q♢', 'J♠', 'A♡', '4♣', '5♣', '7♡', 'A♠', '10♣', 'Q♡', '8♡', '9♢', '10♢', 'J♡', '10♡', 'J♣', '3♡'])
    ['10♣', '2♠', '3♡', '4♣', '7♡', '8♡', 'A♣', 'J♣', 'Q♢']
    remove_pairs(['10♣', '2♣', '5♢', '6♣', '9♣', 'A♢', '10♢'])
    ['2♣', '5♢', '6♣', '9♣', 'A♢']
    '''
    no_pairs = []
    pairs=[]
    
    # COMPLETE THE BODY OF THIS FUNCTION ACCORDING TO THE DESCRIPTION ABOVE
    # YOUR CODE GOES HERE
    
    l = l.sort()
    for i in range(0,len(l)):
        if l[i][0:-1] == l[i+1][0:-1]:
            pairs.append(l[i])
            pairs.append(l[i+1])
    

    for pair in pairs:
        if (pairs.count(pair) == 2) :
            if pair in l:
                l.remove(pair)
            if pair in l:    
                l.remove(pair)
    
    no_pairs = l
    
    # for i in l:
    #     cards.append(i[0:-1])
    #     print(cards)
    # l.sort()
    # print(l.)
    # for i in cards:
    #     if cards.count(i) > 1:
    #         cards.remove(i)
    #         cards.remove(i)

    # for i in range(0,len(l)):
    #     digit = l[i][0:-1]
    #     if digit in cards:
    #         no_pairs.append(l[i])
        
    # print(cards)
    # print(no_pairs)

    random.shuffle(no_pairs)
    return no_pairs
#print(remove_pairs(['A♡', '4♣', '5♣', '7♡', 'A♠', '10♣', 'Q♡', '8♡', '9♢', '10♢', 'J♡', '10♡', 'J♣', '3♡']))
    
def print_deck(deck):
    '''
    (list)-None
    Prints elements of a given list deck separated by a space
    '''

    # COMPLETE THE BODY OF THIS FUNCTION ACCORDING TO THE DESCRIPTION ABOVE
    # YOUR CODE GOES HERE
    for card in deck:
        print(card,end=" ")

    
def get_valid_input(n):
    '''
    (int)->int
    Returns an integer given by the user that is at least 1 and at most n.
    Keeps on asking for valid input as long as the user gives integer outside of the range [1,n]
     
    Precondition: n>=1
    '''
     # COMPLETE THE BODY OF THIS FUNCTION ACCORDING TO THE DESCRIPTION ABOVE
     # YOUR CODE GOES HERE

    num = (input("Enter a number between 1 and n: "))
    while num < 1 or num > n:
            num = int(input("Enter a number between 1 and n: "))

    return num

def play_game():
     '''()->None
     This function plays the game'''
    
     deck=make_deck()
     shuffle_deck(deck)
     tmp=deal_cards(deck)

     dealer=tmp[0]
     human=tmp[1]

     print("Hello. My name is Robot and I am the dealer.")
     print("Welcome to my card game!")
     print("Your current deck of cards is:")
     print_deck(human)
     print("Do not worry. I cannot see the order of your cards")

     print("Now discard all the pairs from your deck. I will do the same.")
     wait_for_player()
     
     dealer=remove_pairs(dealer)
     human=remove_pairs(human)
    
    
     # COMPLETE THE play_game function HERE
     # YOUR CODE GOES HERE
     while human != [] or dealer != [] :
        print("Your turn.")
        print("Your current deck of cards is:",end="")
        print(human)
        x = len(dealer)
        print("I have ", len(dealer), "cards. If 1 stands for my first card and \n 7 for my last card, which of my cards would you like?")
        ans = get_valid_input(x)
        new_card = dealer[ans]
        print("You asked for my ", ans ," card. \n Here it is. It is ", new_card)
        ##
        human.append(new_card)
        dealer.remove(new_card)
        print("With ", new_card ," added, your current deck of cards is:  \n")

        print(human)

        human = remove_pairs(human)
        # #print(human)
        # shuffle_deck(human)
        print("And after discarding pairs and shuffling, your deck is:")
        print(human)

        wait_for_player()
        print("My turn.")
       
        card_taken = random.randint(1,len(human)+1)
        print("I took your ", card_taken, " card.")
        new_card_taken = human[card_taken]
        dealer.append(new_card_taken)
        human.remove(new_card_taken)
        wait_for_player()

     if human == [] :
         print("Ups. You do not have any more cards \nCongratulations! You, Human, win")
     elif dealer == []:
         print("Ups. I do not have any more cards \nYou lost! I, Robot, win")


# main
play_game()
