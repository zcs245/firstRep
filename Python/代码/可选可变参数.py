#可选参数
def dup(str,times=2):
    print(str*times)
dup("knock~")
dup("knock~",4)
#可变参数
def vfunc(a,*b):
    print(type(b))
    for n in b:
        a += n
    return a
print(vfunc(1,2,3,4,5,))
