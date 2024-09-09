## Beginning Exploratory Data Analysis
## Using the ggplot() function to create visualizations

## install.packages("ggplot2")
## setwd()

library(ggplot2)

## Read the file weather.csv from your working directory
## Assign it to the data frame called weather

weather <- read.csv("weather.csv", header = TRUE)

## Investigate the basic structure of the weather data set
nrow(weather)

ncol(weather)

colnames(weather)

head(weather)

str(weather)

View(weather)

## Basic Scatterplot Template

ggplot(data =    , mapping = aes(x =     , y =     )) +
  geom_point( )


ggplot(data = , mapping = aes(x = , y = )) +
  geom_point(alpha = , size = , color =  )



## Subsets using facet_wrap and facet_grid

ggplot(data = , mapping = aes(x = , fill = )) +
  geom_histogram(binwidth = , color = ) +
  facet_wrap(~ , ncol = )

ggplot(data = , mapping = aes(x = , fill = )) +
  geom_histogram(binwidth = , color = ) +
  facet_grid(  ~  )




## Histogram and Density Plot

ggplot(data = , mapping = aes(x = )) +
  geom_histogram(color =  , fill =   , binwidth = )

ggplot(data = , mapping = aes(x = , fill = )) +
  geom_histogram(binwidth = , color = )

ggplot(data =   , aes(x =   )) +
  geom_density(bw =    ,color = , fill = )

ggplot(data =    , aes(x =, color = factor( ))) +
  geom_freqpoly(binwidth = )

ggplot(data = , mapping = aes(x = , fill = )) +
  geom_histogram(binwidth = , color = ) +
  facet_wrap(~ , ncol = )


ggplot(data = , mapping = aes(x = , fill = )) +
  geom_histogram(binwidth = , color = ) +
  facet_grid(  ~  , ncol = )
