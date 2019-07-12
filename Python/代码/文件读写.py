fname = input("请输入要写入的文件")
fo = open("C:/Users/user/Desktop/"+fname,"w+")
ls = ["我爱你","中国"]
fo.writelines(ls)
fo.seek(0)
for line in fo:
    print(line)
fo.close()
