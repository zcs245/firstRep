textFile = open("C:/Users/user/Desktop/mytxt.txt","rt") #t表示文本文件方式
print(textFile.readline())
textFile.close()
binFile = open("C:/Users/user/Desktop/mytxt.txt","rb") #b表示二进制文件方式
print(binFile.readline())
binFile.close()
fo = open("C:/Users/user/Desktop/mytxt.txt","r")
for line in fo.readline():
    print(line)
fo.close()

fo = open("C:/Users/user/Desktop/mytxt.txt","r")
for line in fo:
    print(line)
fo.close()
