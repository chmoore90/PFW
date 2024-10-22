library(tidyverse)

crimedata = read.csv("C:\\Users\\chmoo\\Desktop\\crimedata.csv")
str(crimedata)
crime=crimedata[, c(1,2,5, 11:17, 32:38, 92, 96, 97, 121, 130, 132,134,136,138,
                    140,142,144,145,146)]

##Intro Stuff and NA calculations
summary(crime)
nrow(crime)
313/2215
97/2215
221/2215

unique(crime$state)
sort(table(crime$state))

##Creating new variables region and Total crimes
crime$TotalCrimePerPop=crime$ViolentCrimesPerPop + crime$nonViolPerPop

crime$region=fct_collapse(crime$state, West=c("WA", "OR", "MT", "ID", "WY", "CA", "NV", "UT", "CO", "NM", "AZ", "AK"),
                          Midwest=c("ND", "SD", "NE", "KS", "MN", "IA", "MO", "WI", "IL", "MI", "IN", "OH"),
                          South=c("TX", "OK", "AR", "LA", "MS", "AL", "TN", "KY", "FL", "GA","SC", "NC", "VA", "WV", "DC", "MD", "DE"),
                          Northeast=c("PA", "NY", "NJ", "CT", "RI", "MA", "VT", "NH", "ME"))
crime$region=factor(crime$region)
levels(crime$region)

crime$state=factor(crime$state)

table(crime$region)

summary(lm(ViolentCrimesPerPop ~ region, data=crime))
corrplot(cor(crime[, c(3:31, 33)], use="pairwise.complete.obs"))
corrplot(cor(crime[, 3:32], use="pairwise.complete.obs"), type = "upper", diag = FALSE)

cor(crime$ViolentCrimesPerPop, crime$PctNotHSGrad, use="complete.obs")
#.46 for violent crimes, moderate positive

cor(crime$ViolentCrimesPerPop, crime$nonViolPerPop, use="complete.obs")
#.67 moderately strong relationship

cor(crime$PctPopUnderPov, crime$TotalCrimePerPop, use="complete.obs")
#.53 moderate relationshp

cor(crime$medIncome, crime$nonViolPerPop, use="complete.obs")
# -0.47 moderate negative relationship

cor(crime$medIncome, crime$TotalCrimePerPop, use="complete.obs")
# -0.48 moderate negative relationship


##Correlations
# install.packages("corrplot")
library(corrplot)
library(tidyverse)
library(ggplot2)
corrplot(cor(crime[, 3:31], use="complete.obs"))
corrplot(cor(crime[, 3:31], use="pairwise.complete.obs"), type = "upper", diag = FALSE)


cor(crime$population, crime$nonViolPerPop, use="complete.obs")
cor(crime$PctUnemployed, crime$ViolentCrimesPerPop, use="complete.obs")

cor(crime$medIncome, crime$ViolentCrimesPerPop, use="complete.obs")
cor(crime$medIncome, crime$nonViolPerPop, use="complete.obs")
cor(crime$PctPopUnderPov, crime$nonViolPerPop, use="complete.obs")
cor(crime$PctPopUnderPov, crime$ViolentCrimesPerPop, use="complete.obs")


##Histograms of the individual variariables and transformations of dist.
library(ggplot2)
hist(crime$medIncome, main = paste("Histogram of Median Income"), xlab = "Median Income")
hist(log(crime$medIncome), main = paste("Histogram of Log of Median Income"), xlab = "Log Median Income")


hist(crime$PctPopUnderPov, main = paste("Histogram of Percent of People Under Poverty"), xlab = "Percent of People Under Poverty")
hist((crime$PctPopUnderPov)**(1/4), main = paste("Histogram of Fourth Root of Percent of People Under Poverty"), xlab = "Fourth Root of % People Under Poverty")


ggplot(crime, aes(x=region)) +
  geom_bar() +
  labs(title=" Region Frequency Barplot", x="Region", y="Frequency")
table(crime$region)

hist(crime$ViolentCrimesPerPop, main = paste("Histogram of Violent Crimes"), xlab = "Violent Crimes")
hist((crime$ViolentCrimesPerPop)**(1/4), main = paste("Histogram of Fourth Root of Violent Crimes"), xlab = "Fourth Root of Violent Crimes")
mean((crime$ViolentCrimesPerPop)**(1/4), na.rm=TRUE)
median((crime$ViolentCrimesPerPop)**(1/4), na.rm=TRUE)

hist(crime$nonViolPerPop, main = paste("Histogram of Nonviolent Crimes"), xlab = "Nonviolent Crimes")
hist(sqrt(crime$nonViolPerPop), main = paste("Histogram of Square Root of Nonviolent Crimes"), xlab = "Square Root of Nonviolent Crimes")
mean(sqrt(crime$nonViolPerPop), na.rm=TRUE)
median(sqrt(crime$nonViolPerPop), na.rm=TRUE)

hist(crime$TotalCrimePerPop, main = paste("Histogram of Total Crime"), xlab = "Total Crime")
hist(crime$TotalCrimePerPop**(1/4), main = paste("Histogram of Fourth Root of Total Crime"), xlab = "Fourth Root of Total Crime")
mean(crime$TotalCrimePerPop**(1/4), na.rm=TRUE)
median(crime$TotalCrimePerPop**(1/4), na.rm=TRUE)
sd(crime$TotalCrimePerPop**(1/4), na.rm=TRUE)

##Graph (boxplot) of region and total crime
ggplot(data = crime, mapping = aes(x = TotalCrimePerPop, y=factor(region))) +
  geom_boxplot()

##Linear Model of nonviolent crimes and median income
plot(x=crime$nonViolPerPop, y=log(crime$medIncome))
m1=lm(nonViolPerPop ~ log(medIncome), data=crime)
summary(m1)
resids=rstandard(m1)
hist(rstandard(m1))
qqnorm(resids)
qqline(resids)
plot(resids)
abline(h=0, col="red")
abline(h=3, lty=2, col="red")
abline(h=-3, lty=2, col="red")


##Linear Model of total crimes and median income
plot(x=crime$TotalCrimePerPop, y=log(crime$medIncome))
m1=lm(TotalCrimePerPop ~ log(medIncome), data=crime)
summary(m1)
resids=rstandard(m1)
hist(rstandard(m1))
qqnorm(resids)
qqline(resids, col="blue")
plot(resids, main = "Median Income and Total Crime")
abline(h=0, col="red")
abline(h=3, lty=2, col="red")
abline(h=-3, lty=2, col="red")

ggplot(crime, aes(x=log(medIncome), y=TotalCrimePerPop)) +
  geom_point() +
  geom_smooth(method="lm") +
  facet_grid(~ region)

##Linear Model of total crimes and population under poverty
plot(x=crime$TotalCrimePerPop, y=crime$PctPopUnderPov)
m1=lm(TotalCrimePerPop ~ crime$PctPopUnderPov, data=crime)
summary(m1)
resids=rstandard(m1)
hist(rstandard(m1))
qqnorm(resids)
qqline(resids, col="blue")
plot(resids)
abline(h=0, col="red")
abline(h=3, lty=2, col="red")
abline(h=-3, lty=2, col="red")

ggplot(crime, aes(x=PctPopUnderPov, y=TotalCrimePerPop)) +
  geom_point() +
  geom_smooth(method = "lm") +
  facet_grid(~ region)



##Linear model of total crimes and region
m1=lm(TotalCrimePerPop ~ region-1, data=crime)
summary(m1)
resids=rstandard(m1)
hist(rstandard(m1))
qqnorm(resids)
qqline(resids)
plot(resids)
abline(h=0)
abline(h=3, lty=2)


