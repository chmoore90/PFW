library(unvotes)
library(tidyverse)

votes = unvotes::un_votes
colnames(votes)

issues = unvotes::un_roll_call_issues
colnames(issues)

roll_call = unvotes::un_roll_calls
colnames(roll_call)

table(issues$issue)
votes
str(votes)
