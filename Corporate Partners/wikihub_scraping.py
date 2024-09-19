from bs4 import BeautifulSoup
import requests
import pandas as pd

# preparing soup
url = "https://en.wikipedia.org/wiki/List_of_hub_airports"
site = requests.get(url)
soup = BeautifulSoup(site.text, "lxml")

all_hubs_raw = []

### LI HTML TAGS ###

# page to search
page_li = soup.find_all("li")

for i in range(len(page_li)):
    text = page_li[i].get_text()
    # narrow range to just include the listed hubs (eliminate formatting, resources tab, etc)
    if i < 183:
        continue
    elif i > 985:
        continue

    if "\n" not in text:
        continue

    text = text.split("\n", 1)[0]
    all_hubs_raw.append(text.strip())


### TD HTML TAGS ###

tables = pd.read_html(url)
tables[0] = tables[0].dropna()

table_data = pd.concat(tables)["Airport"].drop_duplicates().to_list()

## COMBINING INTO ONE DATAFRAME ###

for i in table_data:
    all_hubs_raw.append(i)
