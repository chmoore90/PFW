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
    airports.append(i.get_text())