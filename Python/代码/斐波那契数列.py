a,b =0,1
while a<100:  #输出不大于1000的序列
    print(a,end=',')
    a,b = b,+a+b
