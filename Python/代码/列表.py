ls_1 = [425,"BIT",[10,"CS"],425]
li_1=((425,"BIT",[10,"CS"],425))
li_2=("中国是一个伟大的国家")

ls_2 = [425,"BIT",1024] #用数据赋值产生列表ls_2
lt = ls_2
ls_2[0] = 0
print(ls_1,"\n",ls_1[2][-1][0],"\n",li_1,"\n",li_2,"\n",lt)
vlist = list(range(5))
print(vlist,"\n",len(vlist[2:]),"\n",2 in vlist)
vlist[3] = "python"
print(vlist)
vlist[1:3] = ["bit","computer"]
print(vlist)