seg1 = '''
<!DOCTYPE HTML>\n<html>\n<body>\n<meta charset=utf-8>
<h2 align=center>2016年7月部分大城市新建住宅价格指数</h2>
<table border="1" align="center" wideth=70%>
<tr bgcolor='orange'>\n'''
seg2 = "</tr>\n"
seg3 = "</table>\n</body>\n</html>"
def fill_data(locls):
    seg = '<tr><td align="center">{}</td><td align="center">' \
          '{}</td><td align="center">{}</td><td align="center">' \
          '{}</td></tr>\n'.format(*locls)
    return seg
fr = open("C:/Users/user/Desktop/price2016.csv","r", encoding='UTF-8')
ls = []
for line in fr:
    line = line.replace("\n","")
    ls.append(line.split(","))
fr.close()
fw = open("C:/Users/user/Desktop/price2016.html","w", encoding='UTF-8')
fw.write(seg1)
fw.write('<th width=25%>{}</th>\n<th width=25%>{}</th>\n'
         '<th width=25%>{}</th>\n<th width=25%>{}</th>\n'.format(*ls[0]))
fw.write(seg2)
for i in range(len(ls)-1):
    fw.write(fill_data(ls[i+1]))
fw.write(seg3)
fw.close()