from turtle import *
while True:
    i = 0
    fd(100)
    left(-120)
    if abs(pos())<1:
        i = i+1
        if(i==2):
            break
        else:
            left(60)
            fd(100)
            left(-120)
            fd(200)
            left(-120)
            fd(200)
            left(-120)
            fd(100)
            break
