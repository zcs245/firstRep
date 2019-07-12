try:
    n = 1 #m是全局变量
    def func(a,b):
        c = a * b #c是局部变量，a和b作为函数参数也是局部变量
        return c
    s = func("knock~",2)
    print(c)
except NameError:
    print("找不到变量名")

m = 1 #m是全局变量
def func1(a,b):
    m = b #这个m是在函数内存中新生成的局部变量，不是全局变量
    return a*b
s1=func1("knock~",2)
print(s1,"\n",m) #测试一下n值是否改变

q = 1 #q是全局变量
def func2(a,b):
    global q
    q = b #将局部变量b赋值给全局变量n
    return a*b
s2=func2("knock~",2)
print(s2,"\n",q) #测试一下n值是否改变

ls = [] #ls是全局变量
def func3(a,b):
    ls.append(b) #将局部变量b增加到全局列表变量ls中
    return a*b
s3 = func3("knock~",2)
print(s3,"\n",ls) #测试一下n值是否改变