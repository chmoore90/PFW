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
    text = page_li[i].get_text()
    # narrow range to just include the listed airlines (eliminate formatting, resources tab, etc)
    if i < 183:
        continue
    elif i > 985:
        continue
    elif "\n" in text:             # skip non-airline entries
        continue
    elif "(focus city)" in text:   # skip focus cities
        continue

    # removing parentheses from ends
    if "[" in text:
        text = text.split("[", 1)[0]
    if "(primary hub)" in text:
        text = text.split("(", 1)[0]
    if "(base)" in text:
        text = text.split("(", 1)[0]

    all_airlines.append(text.strip())


### TD HTML TAGS ###

# preparing new page to search
page_td = soup.find_all("td")

for i in page_td:
    text: str = i.get_text()
    if "(focus city)" in text:              # skip focus cities
        continue
    # STILL INCLUDES AIRPORTS, SOME CITY NAMES (but I don't think that matters)

    # remove "[X]" from entries
    if "[" in text:
        text = text.split("[", 1)[0]

    # SPECIAL CASE: two entries got consolidated, separated with "\n". This only occurred once (that I could tell)
    if text == "Eurowings\nCondor Airlines":
        pair = text.split("\n")
        for each in pair:
            all_airlines.append(each)
        continue

    all_airlines.append(text.strip())


## COMBINING INTO ONE DATAFRAME ###

df = pd.DataFrame(all_airlines, columns=["Airline"])
df_trim = df[df["Airline"].str[0].isin(letters)]

df_counts = df_trim.groupby("Airline").size()
print(df_counts)
