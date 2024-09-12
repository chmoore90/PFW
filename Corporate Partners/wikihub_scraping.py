from bs4 import BeautifulSoup
import requests
import pandas as pd

# list of cities/countries to be removed
removed_names = ["Seattle"]

# requests to pull site
url = "https://en.wikipedia.org/wiki/List_of_hub_airports"
site = requests.get(url)

# preparing soup
soup = BeautifulSoup(site.text, "html")
page = soup.find_all("a")

# generating list of all airlines listed
all_hubs = []
for i in range(len(page)):
    # narrow range to just include the listed airlines (eliminate formatting, resources tab, etc)
    if i < 191:
        continue
    elif i > 1583:
        continue
    # skip non-airline entries
    elif page[i].get_text() == "edit":
        continue
    elif page[i].get_text().startswith("["):
        continue
    elif page[i].get_text() in removed_names:
        continue
    # add to list if all checks passed
    else:
        all_hubs.append(page[i].get_text())

print(all_hubs)
print(len(all_hubs))

# convert to pandas dataframe
df = pd.DataFrame(all_hubs, columns=["Airline"]).groupby("Airline").size()

print(df.head())
