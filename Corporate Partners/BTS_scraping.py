from bs4 import BeautifulSoup
import requests
from zipfile import ZipFile
from io import BytesIO
import pandas as pd

def get_all_flights():

    # preparing soup
    site_url = "https://www.bts.gov/browse-statistical-products-and-data/bts-publications/data-bank-28ds-t-100-domestic-segment-data"
    site = requests.get(site_url)
    soup = BeautifulSoup(site.text, "lxml")
    page = soup.find_all("a", href=True)

    # list of data frames
    dfs = []

    # creating list of dataframes from website zip files
    for i in page:
        date = i.get_text()
        # LIMITING: to dates 2022-2024
        if date[-4:] == "2024" or date[-4:] == "2023" or date[-4:] == "2022":
            link_url = i["href"]
            if link_url.startswith("/sites/bts.dot.gov/files/docs/airline-data/domestic-segments/"):
                parameters = {"downloadformat" : "csv"}
                response = requests.get(f"https://www.bts.gov{link_url}", parameters)

                # unzipping zip file, appending dataframe to dfs list
                zip = ZipFile(BytesIO(response.content))
                df = pd.read_csv(zip.open(zip.namelist()[-1]), sep="|", header=None)[[2, 6, 10]]
                dfs.append(df)

    # compiling datasets into one
    flights_data = pd.concat(dfs)
    flights_data.rename(columns={2: "origin", 6: "destin", 10: "airline"}, inplace=True)

    return flights_data
