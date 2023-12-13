import turtle
s=turtle.Screen()
t=turtle.Turtle()
##Name: Parvisha Jhundoo
##Student number: 300269830
##Module: ITI1120 B
# Place your code after this line
#1
t.circle(30)
t.penup()
t.goto(0,-30)
t.pendown()
#2
t.circle(60)
t.penup()
t.goto(0,-60)
t.pendown()
#3
t.circle(90)
t.penup()
t.goto(0,-90)
t.pendown()
#4
t.circle(120)

t.penup()
t.goto(0,30)
t.pendown()
t.forward(200)
t.back(400)
t.penup()
t.goto(0,220)
t.pendown()
t.goto(0,-150)

#diagonals
t.penup()
t.goto(125,200)
t.setheading(250)
t.pendown()
t.goto(-125,-150)

t.penup()
t.goto(-125,200)
t.setheading(250)
t.pendown()
t.goto(125,-150)

