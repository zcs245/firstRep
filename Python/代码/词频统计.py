import jieba
text = open("C:/Users/user/Desktop/mytxt.txt","r",encoding="gbk").read()
words = jieba.lcut(text)
counts = {}
for word in words:
    if len(word)==1:
        continue
    else:
        counts[word] = counts.get(word,0)+1
items = list(counts.items())
items.sort(key=lambda x:x[1],reverse = True)
for i in range(2):
    word,count = items[i]
    print("{0:<10}{1:>5}".format(word,count))