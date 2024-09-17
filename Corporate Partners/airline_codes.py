'''
Simple script to generate a list of airline codes from the web.
To use, run "from airline_codes import airline_codes"
'''

from bs4 import BeautifulSoup
import requests

# requests to get site
url = "https://airlinecodes.info/iata"
site = requests.get(url)

airline_codes = []

# preparing soup
soup = BeautifulSoup(site.text, "lxml")
page = soup.find_all("td")
