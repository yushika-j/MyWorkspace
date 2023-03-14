
        
## exectuting Point(2,3)
## 1. creates an object of type point
## 2. calls an objects __init__ method
## 3. produces an object's memory address

## Assigning to a new variable using dot operator
## CREATES THAT VARIABLE INSIDE OF THE OBJECT

## Variables INSIDE of an object are called INSTANCE variables

## __init__ is method that is called to initialize the object (create it and initialize its variables)
## the first parameter of method is usually called self
## self refers to the object that is being initialized



#    constructor
#    notice two underscores
from math import *
class Point:
    'class that represents a point in the plane'

    def __init__(self, xcoord=0, ycoord=0):
        ''' (Point, float, float) -> None
        >>> p=Point(2,3)
        >>> p.x
        >>> 2
        >>> p.y
        >>> 3
        
        
        initialize point coordinates to (xcoord, ycoord)'''
        self.x = xcoord
        self.y = ycoord
    

    def move(self, dx, dy):
        '''(Point,float,float)->None
        change the x and y coordinates by dx and dy'''
        self.x += dx
        self.y += dy

    def up(self):
        self.move(0,1)
        return (self.x,self.y)

    def down(self):
        self.move(0,-1)
        return (self.x,self.y)

    def left(self):
        self.move(-1,0)
        return (self.x,self.y)

    def right(self):
        self.move(1,0)
        return (self.x,self.y)


    def setx(self, xcoord):
        ''' (Point,float)->None
        set x coordinate of point to xcoord'''
        self.x = xcoord

    def sety(self, ycoord):
        ''' (Point,float)->None
        set y coordinate of point to ycoord'''
        self.y = ycoord

    def get(self):
        '''(Point)->tuple
        return a tuple with x and y coordinates of the point'''
        return (self.x, self.y)

    

    def __eq__(self, other):
        'self == other if they have the same coordinates'
        return self.x == other.x and self.y == other.y
    def __repr__(self):
        'return canonical string representation Point(x, y)'
        return 'Point('+str(self.x)+','+str(self.y)+')'

    def distance(self,coord):
        
        
        dist = sqrt(((coord.x-self.x)**2)+ ((coord.y-self.y)**2))
        return dist

         
class Animal:
    'represents an animal'

    def __init__(self, species='animal', language='make sounds',Age = 'years of existence'):
        self.spec = species
        self.lang = language
        self.age = Age
    def setSpecies(self, species):
        'sets the animal species'
        self.spec = species

    def setLanguage(self, language):
        'sets the animal language'
        self.lang = language

    def speak(self):
        'prints a sentence by the animal'
        print('I am a', self.spec,'and I', self.lang)
    
    def setAge(self,age):
        'sets the animal age'
        self.age= age

    def getAge(self):
        'return age'
        return self.age

class Bird(Animal): # class Bird inherits all atributes (data and method) from class Animal 
    'represents a bird'

    def speak(self):
        'prints bird sounds'
        print(self.language * 3)



class Card:
    'represents a playing card'

    def __init__(self, rank, suit):
        'initialize rank and suit of card'
        self.rank = rank
        self.suit = suit

    def getRank(self):
        'return rank'
        return self.rank

    def getSuit(self):
        'return suit'
        return self.suit    

    def __repr__(self):
        'return formal representation'
        return 'Card('+self.rank+','+self.suit+')'

    def __eq__(self, other):
        'self == other if rank and suit are the same'
        return self.rank == other.rank and self.suit == other.suit


    def __gt__(self,other):
        return (self.rank > other.rank and self.suit > other.suit)

    def __ge__(self,other):
        return (self.rank >= other.rank and self.suit >= other.suit)

    def __le__(self,other):
        return (self.rank <= other.rank and self.suit <= other.suit)

    def __lt__(self,other):
        return (self.rank < other.rank and self.suit < other.suit)
import random
class Deck:
    'represents a deck of 52 cards'

    # ranks and suits are Deck class variables
    ranks = {'2','3','4','5','6','7','8','9','10','J','Q','K','A'}

    # suits is a set of 4 Unicode symbols representing the 4 suits 
    suits = {'\u2660', '\u2661', '\u2662', '\u2663'}

    def __init__(self):
        'initialize deck of 52 cards'
        self.deck = []          # deck is initially empty

        for suit in Deck.suits: # suits and ranks are Deck
            for rank in Deck.ranks: # class variables
                # add Card with given rank and suit to deck
                self.deck.append(Card(rank,suit))

    def dealCard(self):
        'deal (pop and return) card from the top of the deck'
        return self.deck.pop()

    def shuffle(self):
        'shuffle the deck'
        random.shuffle(self.deck)


    def __len__(self):
        'returns size of deck'
        return len(self.deck)

    def __repr__(self):
        'returns canonical string representation'
        return 'Deck('+str(self.deck)+')'

    def __eq__(self, other):
        '''returns True if decks have the same cards
           in the same order'''
        return self.deck == other.deck

#####################################################
#Programming ex 3
#####################################################
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

######################################################
#Programming ex 4
######################################################
class PingPong:
    def __init__(self):
        self.turn = "PING"

    def next(self):
        if self.turn == "PING":
            self.turn = "PONG"
        else:
            self.turn = "PONG"
        return self.turn
        
######################################################
#Programming ex 5 a
######################################################
class Queue:
    Queue = []

    def enqueue(self,item):
        self.Queue.append(item)

    def dequeue(self):
        print(self.Queue[0])
        self.Queue.pop(0)

    def IsEmpty(self):
        if self.Queue == []:
            return True
        else:
            return False

######################################################
#Programming ex 5 b
######################################################
    def __eq__(self,item):
        if self == item:
            return True
        else:
            return False
    
    def __len__(self):
        return len(self)
    




######################################################
#Programming ex 6
######################################################
class Vector(Point):

    def __add__(self,coord):
        self.x = self.x + coord.x
        self.y = self.y + coord.y
        return Vector(self.x,self.y)

    def product(self,coord):
        product = (self.x * coord.x) + (self.y * coord.y)
        return product

######################################################
#Programming ex 7
######################################################
class marsupial:
    
    def __init__(self,colour):
        self.colour = colour
        self.pouch = []
        print("I am a ", self.colour , "marsupial.")
    def put_in_pouch(self,item):
        self.pouch.append(item)
        return self.pouch

    def pouch_contents(self):
        return repr(self.pouch)

class Kangaroo(marsupial):

    def __init__(self, colour,xcoord = 0, ycoord= 0):
        self.colour = colour
        self.x = xcoord
        self.y = ycoord
        

    def jump(self,dx,dy):
        return(self.x+dx,self.y+dy)

    def __str__(self):
        print("I am a ", self.colour, "kangaroo located at coordinates (" + str(self.x)+","+str(self.y)+")")
class Points:
    def __init__(self,lst = []):
        self.lst = lst

    def __str__(self):
        return(repr(self.lst))
        

    def add(self,x,y):
        self.lst.append(Point(x,y))

    # def left_most_point(self):
        

print("Programming exercise 1")      
c = Point(0,1) 
d = Point(1,0)
print(c.distance(d))
print()

print("Programming exercise 2")  
a = Point(3, 4) 
a.left() 
print(a.get())
print()

print("Programming exercise 3")  
x = bankAccount(700) 
x.balance()
x.withdraw(70)
print(x.balance())
print()

print("Programming exercise 4")  
ball = PingPong()
print(ball.next())
print()

print("Programming exercise 5a")  
appts = Queue()
appts.enqueue('John')
appts.enqueue('Annie')
appts.dequeue()
print(appts.IsEmpty())
appts.dequeue()
print()

print("Programming exercise 6")  
v1 = Vector(1, 3) 
v2 = Vector(-2, 4)
print(v1.__add__(v2))
print()

print("Programming exercise 7")  
m=marsupial("red")
m.put_in_pouch('doll')
m.put_in_pouch('firetruck')
m.put_in_pouch('kitten')
print(m.pouch_contents())


k = Kangaroo("blue", 0, 0 )
print(k.__str__())

print()

a=[Point(1,1), Point(1,2), Point(2,20), Point(1.5, -20)]
mypoints=Points(a)
mypoints.add(1,-1)
print(mypoints.__str__())