from turtle import *
Str = [10,15,20,25,30,35,40,45,50]
for i in range(0,9):
    penup()
    goto(0,int(-Str[i]))
    pendown()
    circle(int(Str[i]))
