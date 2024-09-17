from bs4 import BeautifulSoup
import requests

# requests to get site
url = "https://www.leonardsguide.com/us-airport-codes.shtml"
site = requests.get(url)

airports = []

# preparing soup
soup = BeautifulSoup(site.text, "lxml")
page = soup.find_all("td")

for i in page:
    text = i.get_text()
    if len(text) == 3:
        airports.append(i.get_text())

print(airports)
