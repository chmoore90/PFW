from bs4 import BeautifulSoup
import requests
from zipfile import ZipFile
from io import BytesIO
import pandas as pd

# preparing soup
site_url = "https://www.bts.gov/browse-statistical-products-and-data/bts-publications/data-bank-28ds-t-100-domestic-segment-data"
site = requests.get(site_url)
soup = BeautifulSoup(site.text, "lxml")
page = soup.find_all("a", href=True)

# list of files
dfs = []

# creating list of dataframes from website zip files
for i in page:
    date = i.get_text()
    # LIMITING: to dates 2024
    if date[-4:] == "2024":
        link_url = i["href"]
        if link_url.startswith("/sites/bts.dot.gov/files/docs/airline-data/domestic-segments/"):
            parameters = {"downloadformat" : "csv"}
            response = requests.get(f"https://www.bts.gov{link_url}", parameters)

            # unzipping zip file, appending dataframe to dfs list
            z = ZipFile(BytesIO(response.content))
            df = pd.read_csv(z.open(z.namelist()[-1]), sep="|", header=None)
            df.rename(columns={5: "origin", 9: "destin", 10: "code"}, inplace=True)
            dfs.append(df)

# compiling datasets into one
data = pd.concat(dfs)[["origin", "destin", "code"]]

print(data.head(50))
