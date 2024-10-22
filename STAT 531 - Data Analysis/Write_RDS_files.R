## Using the write_rds and read_rds functions allow you to save a version
## of the data frame just as you have it in R.  So if you created factors
## they will still be there the next time you read the .rds file into RStudio

library(tidyverse)

## There are two required arguments for write_rds
## The first is the R object to be saved (i.e., your data frame)
## The second is the name you wish to call the saved file

write_rds(df, "filename.rds")

## The read_rds() function requires the name of the saved file as input
## Make sure to assign it to a new R object (i.e., a data frame)

df_r <- read_rds("filename.rds")
