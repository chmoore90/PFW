from wikihub_scraping import all_hubs_raw
import pandas as pd

airport_codes = pd.read_csv("L_AIRPORT.csv")
all_hubs = []

for i in all_hubs_raw:
    text = i.strip()
    if text.endswith(")"):
        all_hubs.append(text[-4:-1])
    else:
        for j in airport_codes["Description"].to_list():
            if text in j:
                all_hubs.append(airport_codes.loc[airport_codes["Description"] == j]["Code"].to_string()[-3:])
                print(f"added: {text}")
                break
        print(f"missing: {text}")


print(all_hubs)
