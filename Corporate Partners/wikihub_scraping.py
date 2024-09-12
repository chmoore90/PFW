from bs4 import BeautifulSoup
import requests
import pandas as pd

# requests to get site
url = "https://en.wikipedia.org/wiki/List_of_hub_airports"
site = requests.get(url)

all_airlines = []

### LI HTML TAGS ###

# preparing soup
soup_li = BeautifulSoup(site.text, "lxml")
page_li = soup_li.find_all("li")

for i in range(len(page_li)):
    # narrow range to just include the listed airlines (eliminate formatting, resources tab, etc)
    if i < 183:
        continue
    elif i > 985:
        continue
    # skip non-airline entries
    elif "\n" in page_li[i].get_text():
        continue
    elif "(focus city)" in page_li[i].get_text():
        continue

    all_airlines.append(page_li[i].get_text())

### TD HTML TAGS ###

# preparing soup
temp_list = []
soup_td = BeautifulSoup(site.text, "lxml")
page_td = soup_li.find_all("td")

for i in page_td:
    if "(focus city)" in i.get_text(): # eliminate focus cities
        continue

    str_len = len(i.get_text()) - 1
    temp_list.append(i.get_text()[:str_len])

print(temp_list)


# convert to pandas dataframe
df = pd.DataFrame(all_airlines, columns=["Airline"]).groupby("Airline").size()

# print(df)
