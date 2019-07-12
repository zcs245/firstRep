creature = "cat","dog","tiger","human"
color = "red","0x001100","blue",creature
print(creature,"\n",color,"\n",color[2],"\n",color[-1][2])

def func(x): #函数多返回值
    return x,x**3
a,b = 'dog','tiger' #多变量同步赋值
a,b = (b,a) #多变量同步赋值，括号可以省略

import math
for x,y in ((1,0),(2,5),(3,8)): #循环遍历
    print(math.hypot(x,y))  #求多个坐标值到原点的距离

