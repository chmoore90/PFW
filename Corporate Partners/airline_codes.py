'''
Simple script to generate a pandas dataframe of airline codes from the web.
To use, run "from airline_codes import df_airline_codes"
'''

import pandas as pd

url = "https://airlinecodes.info/iata/"
suffixes = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X", "Y", "Z", "0"]
codes = []

for letter in suffixes:
    data = pd.read_html(url + letter)
    for i in data:
        codes.append(i)

df_airline_codes = pd.concat(codes)
print(df_airline_codes.head(10))
