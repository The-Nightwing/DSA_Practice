
from bs4 import BeautifulSoup
import requests

url = r'https://en.wikipedia.org/wiki/Android_version_history'


result = requests.get(url)

print(result.text)
if result.status_code:
    soup=BeautifulSoup(result.text,"html.parser")
    table = soup.find_all("table",{'class':'wikitable'})
    print(len(table))
    table  = table[0]
    columns = table.find_all('th')

    li = list()
    for c in columns:
        li.append(c.text[:-1])
    print(li)

    rows = table.find_all('tr')[1:]

    set2 = []
    for row in rows:
        set1= []
        row1 = row.find_all('td')
        for s in row1:
            set1.append(s.text[:-1])
        set2.append(set1);

    print(set2)


    
