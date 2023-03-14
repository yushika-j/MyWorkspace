'''quizgame.py a quiz game'''
import random
import time


def raw_read_answer():
    ans = 0
    try:
        ans = int(input("Answer (1,2,3 or 4): "))
    except ValueError:
        print("Answer must be an integer")
    return ans

def read_answer():
    ans = raw_read_answer()
    while ans not in [1, 2, 3, 4]:
        print("Invalid input, try again")
        ans = raw_read_answer()
    return ans

def ask_question(q, p):
    print()
    print("Category:", q[5], "Difficulty:",q[6])
    print(q[0])
    for i in range(1, 5):
        print(i, q[p[i-1]])
   
def play_game():
    lines = open('quiz.csv',encoding="utf-8").read().splitlines()
    questions=[]
    for line in lines:
        questions.append(line.split('\t'))
 
    lives=3
    score=0
    while lives >0:

        # create a random permutation for the order of answers
        p = [1,2,3,4]
        random.shuffle(p)

        # pick a random question for the list of questions
        q=random.choice(questions)
        ask_question(q,p)
        ans = read_answer()
        
        if(p[ans-1]==1): # test if the answer is correct.
            score=score+int(q[-1]) # increase the score by the difficulty level
            print("Correct! Your current score is: ", score)
        else:
            lives = lives - 1
            print("Wrong! The correct answer was: ", q[1] )
            print("You have", lives, "lives remaining!")
        if(lives!=0):
            time.sleep(2)
    print("\nGame Over! Your final score is", score)

play_game()
