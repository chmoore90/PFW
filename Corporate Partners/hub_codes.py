from wikihub_scraping import get_hub_names
import pandas as pd

def get_hub_codes():

    airport_codes = pd.read_csv("L_AIRPORT.csv")

    hub_names = get_hub_names()
    hub_codes = ["NSI", "SID", "VXO", "NDJ", "SSH", "NBO", "WIL", "MRU", "JNB", "HLA", "LFW", "TSA", "MLE", "HRI", "CGK", "DPS", "IKA",
                "THR", "GIG", "CDG", "TLS", "CGN", "DUS", "KEF", "MXP", "FCO", "BOO", "WAW", "WRO", "GDN", "OTP", "TSR", "DME", "SVX",
                "LED", "SVO", "VKO", "BEG", "POW", "ARN", "MLH", "BSL", "EAP", "SAW", "IZM", "KBP"] # missing values added manually
    # missing_names = []

    for i in hub_names:
        text = i.strip()
        if text.endswith(")"):
            hub_codes.append(text[-4:-1])
        elif text[-1].isupper() and text[-2].isupper() and text[-3].isupper():
            hub_codes.append(text[-3:])
        else:
            found = False
            for j in airport_codes["Description"].to_list():
                if text.lower() in j.lower():
                    hub_codes.append(airport_codes.loc[airport_codes["Description"] == j]["Code"].to_string()[-3:])
                    found = True
                    break
            if found:
                continue
            # else:
            #     missing_names.append(text)

    return hub_codes
