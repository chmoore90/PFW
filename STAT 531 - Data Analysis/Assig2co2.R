library(ggplot2)
emissions = read.csv("co2_emissions.csv")
str(emissions)

em_long = pivot_longer(emissions, cols = !country, names_to = "year", values_to = "co2", values_drop_na = TRUE)
em_long$year = parse_number(em_long$year)
str(em_long)

emissions_na = subset(em_long, country %in% c("United States", "Canada", "Mexico"))


ggplot(emissions_na, aes(x=year, y=co2, color=country)) +
  geom_line(stat="identity")

write_rds(emissions_na, "co2_emissions_na.rds")
