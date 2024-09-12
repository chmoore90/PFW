import pandas as pd

files = []

# reading file and renaming relevant columns
data = pd.read_csv("C:\\Users\\chmoo\\Desktop\\db28seg.dd.wac.202307.202406.asc", sep="|", header=None)
data.rename(columns={6: "origin", 10: "destin", 11: "code"}, inplace=True)


print(data.head)
