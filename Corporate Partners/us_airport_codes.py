'''
Simple script to generate a list of airport codes from the web.
To use, run "from us_airport_codes import airport_codes"
'''

from bs4 import BeautifulSoup
import requests

# requests to get site
url = "https://www.leonardsguide.com/us-airport-codes.shtml"
site = requests.get(url)

airport_codes = []

# preparing soup
soup = BeautifulSoup(site.text, "lxml")
page = soup.find_all("td")

for i in page:
    text = i.get_text()
    if len(text) == 3:
        airport_codes.append(i.get_text())
