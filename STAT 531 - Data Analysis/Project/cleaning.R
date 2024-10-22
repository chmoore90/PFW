library(corrplot)
library(ggplot2)

crimedata = read.csv("C:\\Users\\chmoo\\Desktop\\crimedata.csv")
str(crimedata)

crime=crimedata[, c(1,2,5, 11:17, 32:38, 92, 96, 97, 121, 130, 132,134,136,138, 140,142,144,145,146)]
summary(crime)

corrplot(cor(crime[, 3:31], use="complete.obs"))
corrplot(cor(crime[, 3:31], use="pairwise.complete.obs"), type = "upper", diag = FALSE)

cor(crime$population, crime$nonViolPerPop, use="complete.obs")

