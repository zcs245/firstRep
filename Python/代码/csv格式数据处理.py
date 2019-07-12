# def GetCSVbyLine():
#     fo = open("C:/Users/user/Desktop/price2016.csv","r", encoding='UTF-8')
#     ls = []
#     for line in fo:
#         line = line.replace("\n","")
#         ls = line.split(",")
#         lns = ""
#         for s in ls:
#             lns += "{}\t".format(s)
#         print(lns)
#     fo.close()
# GetCSVbyLine()

# def WriteD1toCSV():
#     fo = open("C:/Users/user/Desktop/price2016bj.csv","w")
#     ls = ['北京','101.5','120.7','121.4']
#     fo.write(",".join(ls)+"\n")
#     fo.close()
# WriteDltoCSV()

def WriteD2toCSV():
    fr = open("C:/Users/user/Desktop/price2016.csv","r", encoding='UTF-8')
    fw  = open("C:/Users/user/Desktop/price2016out.csv","w", encoding='UTF-8')
    ls = []
    for line in fr:
        line = line.replace("\n","")
        ls.append(line.split(","))
    for i in range(len(ls)):
        for j in range(len(ls[i])):
            if ls[i][j].replace(".","").isnumeric():
                ls[i][j] = "{:.2}%".format(float(ls[i][j])/100)
    for row in ls:
        print(row)
        fw.write(",".join(row)+"\n")
    fr.close()
    fw.close()
WriteD2toCSV()