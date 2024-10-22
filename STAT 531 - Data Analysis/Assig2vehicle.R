library(forcats)
library(lubridate)

vstops = read.csv("vehicle_stops_2016_sd.csv")
str(vstops)
unique(vstops$stop_cause)

# QUESTION 1

# stop_cause
stop_cause_fact = factor(vstops$stop_cause)
vstops$stop_cause = fct_collapse(stop_cause_fact,
                     "Muni, Countym H&S Code" = c("Muni, County, H&S Code", "MUNI, County, H&S Code"), 
                     "Suspect Info" = c("Suspect Info (I.S., Bulletin, Log)", "Suspect Info"),
                     "Bicycle" = c("Bicycle", "BICYCLE", "Bicycle Bicycle"),
                     "NA" = c("No Cause Specified on a Card", "")
                     )

# subject_sex
unique(vstops$subject_sex)
sex_fact = factor(vstops$subject_sex)
vstops$subject_sex = fct_collapse(sex_fact, "Other" = "X", "NA" = "")

# sd_resident
unique(vstops$sd_resident)
sd_res_fact = factor(vstops$sd_resident)
vstops$sd_resident = fct_collapse(sd_res_fact, "NA" = c(" ", ""))

# arrested
unique(vstops$arrested)
vstops$arrested = fct_collapse(factor(vstops$arrested), "Y" = c("Y", "y"), "N" = c("N", "n"), "NA" = c("", " "))

# searched
unique(vstops$searched)
vstops$searched = fct_collapse(factor(vstops$searched), "N" = c("N", "n"), "NA" = c("", " ", "\\"))


# QUESTION 2

unique(vstops$subject_race)
vstops$subject_race = fct_collapse(factor(vstops$subject_race),
                                   "Asian" = c("A", "K", "C", "V", "J", "Z", "L", "D", "F"),
                                   "Hispanic" = c("H"),
                                   "White" = c("W"),
                                   "Black" = c("B"),
                                   "Other" = c("O", "P", "S", "U", "I", "G"),
                                   "NA" = c("", "X")
                                   )

# QUESTION 3

vstops$month = factor(month(mdy(vstops$stop_date)))

# QUESTION 4

vstops$stop_time = hm(vstops$stop_time)
vstops$business_hr_stop = ifelse(hour(vstops$stop_time)>= 8 & hour(vstops$stop_time)<=17,
                                 "Y", "N")
vstops$business_hr_stop = factor(vstops$business_hr_stop)
unique(vstops$business_hr_stop)

# QUESTION 5

vstops_trim = subset(vstops, select = -c(stop_date, stop_time, service_area))

# QUESTION 6

sum(vstops_trim$stop_cause=="NA")
vstops_trim[vstops_trim=="NA"] = NA

str(vstops_trim)

vstops_trim$subject_age = as.numeric(vstops_trim$subject_age)
vstops_trim$subject_age = sort(vstops_trim$subject_age)
plot(table(vstops_trim$subject_age))
table(vstops_trim$subject_age)

vstops_trim = subset(vstops_trim,
                     !is.na(subject_age) &
                       subject_age != 99 &
                       subject_age >= 15 &
                       subject_age < 110
                     )


vstops_trim$subject_age = sort(vstops_trim$subject_age)
