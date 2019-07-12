import requests
from bs4 import BeautifulSoup
import re
import json
def getKeywordResult(keyword):
    url = "http://www.baidu.com/s?wd="+keyword
    try:
        r = requests.get(url,timeout=30)
        r.raise_for_status()
        r.encoding = "utf-8"
        return r.text
    except:
        return ""
def parseLinks(html):
    soup = BeautifulSoup(html,"html.parser")
    links = []
    for div in soup.find_all("div",{"data-tools":re.compile("title")}):
        data = div.attrs["data-tools"]
        d = json.loads(data)
        links.append(d['title'])
    return links
def main():
    html = getKeywordResult("python语言程序设计基础（第2版）")
    ls = parseLinks(html)
    count = 1
    for i in ls:
        print("[{:^3}]{}".format(count,i))
        count += 1
main()