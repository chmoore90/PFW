import pandas as pd

vehicles = pd.read_csv("vehicle.csv")

vehicles["Accel"] = pd.to_numeric(vehicles["Accel"].str[:-4])
vehicles["TopSpeed"] = pd.to_numeric(vehicles["TopSpeed"].str[:-5])
vehicles["Range"] = pd.to_numeric(vehicles["Range"].str[:-3])
vehicles["Efficiency"] = pd.to_numeric(vehicles["Efficiency"].str[:-6])
vehicles["FastCharge"] = pd.to_numeric(vehicles["FastCharge"].str[:-5])
vehicles["PriceEuro"] = vehicles["PriceEuro"]*1.11

vehicles.to_csv("vehicle_py.csv")
