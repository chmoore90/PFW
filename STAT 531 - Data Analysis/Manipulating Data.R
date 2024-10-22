## More on manipulating data

library(tidyverse)

library(palmerpenguins)
data("penguins")

## Impute missing observations
mean(penguins$body_mass_g)

## How many missing observations for body mass?
summary(penguins$body_mass_g)

penguins %>%
  filter(is.na(body_mass_g))

## Replace the missing observations with the mean body mass
## Note: could use the median instead of the mean

## Syntax for replace() function
## replace(variable, condition for needing replaced, replacement value)

dfp <- penguins
dfp$body_mass_g <- replace(dfp$body_mass_g, is.na(dfp$body_mass_g), 
                           mean(dfp$body_mass_g, na.rm=TRUE))

mean(penguins$body_mass_g, na.rm = TRUE)
mean(dfp$body_mass_g)

## How many missing observations for the penguin's sex?
table(penguins$sex, useNA = "always")

penguins %>%
  filter(is.na(sex))

## Replace the missing observations with the mode of the sex variable
## Create a function to compute the Mode

Mode <- function(x) {
  ux <- unique(x[!is.na(x)])
  tab <- tabulate(match(x, ux))
  ux[tab == max(tab)]
}

## Do the replacement
dfp <- penguins
dfp$sex <- replace(dfp$sex, is.na(dfp$sex), Mode(dfp$sex))

table(dfp$sex, useNA = "always")

round(prop.table(table(penguins$sex)), 2)
round(prop.table(table(dfp$sex)), 2)


## Summarizing within Groups

penguins %>% 
  group_by(species) 	%>% 
  summarize(cnt = n_distinct(island))

penguins %>%
  group_by(species) %>%
  summarize(mean_bmg=mean(body_mass_g, na.rm = TRUE), n=n())

penguins %>%
  group_by(species) %>%
  summarize(mean_fl=mean(flipper_length_mm, na.rm = TRUE), 
            stdev_fl=sd(flipper_length_mm, na.rm = TRUE),
            min_fl=min(flipper_length_mm, na.rm = TRUE),
            max_fl=max(flipper_length_mm, na.rm = TRUE))

penguins %>%
  group_by(species, sex) %>%
  summarize(mean_fl=mean(flipper_length_mm, na.rm = TRUE), 
            stdev_fl=sd(flipper_length_mm, na.rm = TRUE),
            N = n())

table(penguins$species, penguins$sex, useNA = "always")
table(penguins$species, useNA = "always")


## Mutating joins in R

ID <- c(1, 2, 3)
X <- c(5, 10, 15)
data1 <- data.frame(ID, X)


ID <- c(1, 2, 4, 5)
Y<- c(100, 200, 400, 500)
data2 <- data.frame(ID, Y)

data1
data2

## Inner Join
## Keeps only observations appearing in both data frames
data1 %>%
  inner_join(data2, join_by(ID))


## Outer Joins
## Keeps observations appearing in at least one data frame

## Left join
## Keep observations in first table

data1 %>%
  left_join(data2, join_by(ID))

## Right join
## Keep observations in second table
data1 %>%
  right_join(data2, join_by(ID))

## Full join
## Keep observations in either table
data1 %>%
  full_join(data2, join_by(ID))

##########################################

## Reshaping Data Sets
##Read the data set for Income Distribution by Religion based on Pew Research Study
##
pew <- read.csv(file.choose(), header = TRUE, check.names = F)
str(pew)


##Convert to Tidy (long) Form

pew_long <- pivot_longer(
  data = pew,
  cols = 2:11,
  names_to = "income",
  values_to = "freq")

head(pew_long)


##Convert to Wide Form
pew_wide <- pivot_wider(
  data = pew_long,
  names_from = "income",
  values_from = "freq")

head(pew_wide)


##Filter
##Just select the observations corresponding to Catholics
##
pew_Cath <- filter(pew_long, religion=="Catholic")
pew_Cath

##Select
##Just include the columns for income and frequency, not religion
##
pew_Cath2 <- select(pew_Cath, income, freq)
pew_Cath2

## Note that the last two commands could have been "chained" together using the
## pipe operator.

pew_Cath_new <- pew_long %>%
  filter(religion=="Catholic") %>%
  select(income, freq)

pew_Cath_new
##Summarize
##Want to get the total number of people responding in each religion
##
##Mutate
##Compute the percentage of the total sample in each religion
##

pew_rel <- pew_long %>% 
  group_by(religion) %>%
  summarize(N = sum(freq)) %>%
  mutate(pct=round(N*100/sum(N), 2))

pew_rel
##Arrange
##Sort the data according to the frequency
##Ascending versus descending order
##
pew_sorta <- arrange(pew_rel, pct)
pew_sortd <- arrange(pew_rel, desc(pct))


## Use the pipe operator %>% or |> to set up a chain of commmands
pew_rel_t <- pew_long %>%
  group_by(religion) %>% 
  summarize(N=sum(freq)) %>%
  mutate(pct=round(N*100/sum(N), 2)) %>%
  arrange(desc(pct))

pew_rel_t




