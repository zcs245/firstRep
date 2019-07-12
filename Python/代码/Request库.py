import requests

#例1
# r = requests.get("http://www.baidu.com")
# print(r.status_code)
# print(r.text)
# print(r.encoding)
# r.encoding = "utf-8"
# print(r.text)

#例2
def getHTMLText(url):
    try:
        r=requests.get(url,timeout=30)
        r.raise_for_status()
        r.encoding = "utf-8"
        return r.text
    except:
        return ""
url = "http://www.baidu.com"
print(getHTMLText(url))
