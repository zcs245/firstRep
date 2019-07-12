import requests
from bs4 import BeautifulSoup
import re
r = requests.get("http://www.baidu.com")
r.encoding = "utf-8"
soup = BeautifulSoup(r.text,features="html.parser")
print(type(soup))
print(soup.head)
title = soup.title
print(title)
print(type(title))
print(soup.p)
print(soup.a)
print(soup.a.name)
print(soup.a.attrs)
print(soup.a.string)
print(title.name)
print(title.string)
print(soup.p.contents)
a = soup.find_all("a")
print(len(a))
print(soup.find_all("script"))
print(soup.find_all("script",{"src":re.compile("jquery")}))
print(soup.find_all(string=re.compile("百度")))