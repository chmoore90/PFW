from bs4 import BeautifulSoup
import requests
import pandas as pd

# requests to get site
url = "https://en.wikipedia.org/wiki/List_of_hub_airports"
site = requests.get(url)

all_airlines = []

### LI HTML TAGS ###

# preparing soup
soup = BeautifulSoup(site.text, "lxml")
page_li = soup.find_all("li")

# add each occurance of airline name to all_airlines list
for i in range(len(page_li)):
    # narrow range to just include the website list (eliminate headers, banners, resources tab, etc)
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

# convert to pandas dataframe
df = pd.DataFrame(all_airlines, columns=["Airline"])


### TD HTML TAGS ###

# read Europe and US airlines directly from website tables
tables = pd.read_html("https://en.wikipedia.org/wiki/List_of_hub_airports", flavor="lxml")

tables[0] = tables[0].dropna() # remove extra blank columns from Europe table
tables[0].rename(columns={"Airlines": "Airline"}, inplace=True)

df_master = pd.concat([df, tables[0], tables[1]], ignore_index=True, sort=False).drop(columns=["Country", "Airport", "State"])

print(df_master)

# Grouping by Airline to get counts
df_counts = df_master.groupby("Airline").size()
print(df_counts)
