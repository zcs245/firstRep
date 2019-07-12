import json
fr = open("C:/Users/user/Desktop/price2016.json","r")
ls = json.load(fr)
data = [ list(ls[0].keys()) ]
for item in ls:
    data.append(list(item.values()))
fr.close()
fw = open("C:/Users/user/Desktop/price2016.csv","w")
for item in data:
    fw.write(",".join(item)+"\n")
fw.close()