from bs4 import BeautifulSoup
import requests
import pandas as pd

# preparing soup
url = "https://en.wikipedia.org/wiki/List_of_hub_airports"
site = requests.get(url)
soup = BeautifulSoup(site.text, "lxml")

all_airlines = []
letters = ["G", "H", "I", "J", "K", "L", "M"]


### LI HTML TAGS ###

# page to search
page_li = soup.find_all("li")

for i in range(len(page_li)):
    # narrow range to just include the listed airlines (eliminate formatting, resources tab, etc)
    if i < 183:
        continue
    elif i > 985:
        continue
    elif "\n" in page_li[i].get_text():             # skip non-airline entries
        continue
    elif "(focus city)" in page_li[i].get_text():   # skip focus cities
        continue

    all_airlines.append(page_li[i].get_text())

### TD HTML TAGS ###

# preparing new page to search
page_td = soup.find_all("td")

for i in page_td:
    if "(focus city)" in i.get_text():              # skip focus cities
        continue
    # STILL INCLUDES AIRPORTS

    # remove extra characters from end of names (airlines ended with '\n')
    str_len = len(i.get_text()) - 1
    all_airlines.append(i.get_text()[:str_len])


## COMBINING INTO ONE DATAFRAME ###

df = pd.DataFrame(all_airlines, columns=["Airline"]).groupby("Airline").size()

print(df)
