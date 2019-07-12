S = {425,"BTT",(10,"CS"),424}
T = {425,"BIT",(10,"CS"),424,425,"BIT"}
W = set("apple")
V = set(("cat","dog","tiger","hunam"))
tup = ("PYTHON","BIT",123,"GOOD",123) #元素去重
newtup = tuple(set(tup)-{"PYTHON"}) #去重同时删除数据项

print(S,"\n",T,"\n",W)
print(set(tup),"\n",newtup)