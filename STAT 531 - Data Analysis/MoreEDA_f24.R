## Beginning Exploratory Data Analysis
## Using the ggplot() function to create visualizations

install.packages("ggplot2")
install.packages("dplyr")
install.packages("palmerpenguins")

library(ggplot2)
library(palmerpenguins)

data(penguins)
View(penguins)

nrow(penguins)
colnames(penguins)

ggplot(penguins, aes(fill = sex, y = flipper_length_mm)) +
  geom_bar()




## Use the mpg data frame available in the ggplot2 package
data(mpg)
str(mpg)


## Basic Scatterplot

ggplot(data = , mapping = aes(x = , y = )) +
  geom_point(alpha = , size = , color =  )


## Histogram and Density Plot

ggplot(data = , mapping = aes(x = , fill = )) +
  geom_histogram(binwidth = , color = )

ggplot(data = , aes(x = , fill = )) +
  geom_density(bw = , alpha = , color = )

ggplot(data =    , aes(x =, color = factor( ))) +
  geom_freqpoly(binwidth = )



## Subsets using facet-wrap and facet_grid

ggplot(data = , aes(x = , fill = )) +
  geom_histogram(binwidth = , color = ) +
  facet_wrap(~ , ncol = )


ggplot(data = , aes(x = , fill = )) +
  geom_histogram(binwidth = , color = ) +
  facet_grid(  ~  , ncol = )


## Boxplot
ggplot(data= , aes(y = )) +
  geom_boxplot( ) +
  scale_x_continuous(NULL, breaks = NULL) +
  coord_flip( )


ggplot(data= , aes(x = factor(), y = )) +
  geom_boxplot( ) +
  coord_flip( )


## Bar Graphs for Categorical Data

##Stacked Bar Graphs
ggplot(data = , aes(x = , fill = )) +
  geom_bar()

## Stacked Bar Graphs with Normalized Heights
ggplot(  , aes(x = , fill = )) +
  geom_bar(position = "fill")+
  scale_fill_ordinal()


## Side-by-Side Bar Graphs with Width adjusted
ggplot(  , aes(x = class, fill =  ))  +
  geom_bar(position = position_dodge(preserve = "single")) +
  scale_fill_ordinal()



#################################

## Computing Numerical Summary Statistics
mean()
median()
sd()
IQR()
min()
max()


## Computing Summary Statistics for Separate Groups
library(dplyr)

df_name |>
  group_by( ) |>
  summarize(
    avg_x = mean( , na.rm=TRUE),
    med_x = median( , na.rm=TRUE),
    min_x = min( , na.rm=TRUE),
    max_x = max( ,na.rm=TRUE),
    sd_x = sd( , na.rm=TRUE)
  )

## To compute percentage of "yes" response by subgroup
df_name |>
  group_by( ) |>
  summarize(
    pct_x = mean(, na.rm=TRUE),
    n()
  )
