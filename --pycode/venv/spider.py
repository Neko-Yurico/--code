from bs4 import BeautifulSoup
import requests
import re

if __name__ == '__main__':
    target = 'https://ygocdb.com/?search=灰流丽'
    req = requests.get(url=target)
    html = req.text
    get = BeautifulSoup(html,'lxml')
    texts = get.find_all('div', class_ = 'col-md-6 col-xs-8 names')
    texts = texts[0].text.replace('\n', '')
    number = "".join(re.findall("\d+",texts))
    print(number)