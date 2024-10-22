## Simple Linear Regression

install.packages("corrplot")
install.packages("car")

## Correlation plot and Companion to Applied Regression packages
library(tidyverse)
library(corrplot)
library(car)

##Concrete Example
concrete <- read.csv(file=file.choose(), header = TRUE)
head(concrete)

## Look at the correlation
cormat<-cor(concrete)
cormat

corrplot(cormat, type = "upper", order = "original", diag = F, tl.srt = 45)

## Visualize the relationship
ggplot(data = concrete, aes(x = cement, y = csMPa)) +
  geom_point()

ggplot(data = concrete, aes(x = cement, y = csMPa)) +
  geom_point() +
  geom_smooth(method = "lm", se=FALSE)


## Fit the model
mod1<-lm(csMPa ~ cement, data=concrete)
summary(mod1)
anova(mod1)

## Predicting the response for a given value of the predictor variable

## Create a data frame with the value(s) of the predictor
## Use the predict() function to find the y-hat value(s)

pred_data <- data.frame(cement = c(200, 300, 400))
predict(mod1, newdata = pred_data)


## Useful Quantities
Fits1 <- fitted.values(mod1)
resid1 <- residuals(mod1)
Sres1 <- rstandard(mod1)
Rstdnt <- rstudent(mod1)

## Check assumptions
summary(Sres1)

hist(Sres1)

qqnorm(Sres1)
qqline(Sres1)

shapiro.test(Sres1)

plot(x = fitted.values(mod1), y = rstandard(mod1))
abline(h=c(-2, 0, 2))

summary(mod1)
confint(mod1, "cement", level = 0.95)
