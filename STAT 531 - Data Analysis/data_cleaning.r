library("dplyr")

vehicles = read.csv("vehicle_py.csv")

vehicles$FastCharge[vehicles$FastCharge == "-"] = NA

vehicles$RapidCharge = as.factor(vehicles$RapidCharge)
levels(vehicles$RapidCharge) = c("False", "True")
vehicles$PowerTrain = as.factor(vehicles$PowerTrain)
levels(vehicles$PowerTrain) = c("AWD", "FWD", "RWD")
vehicles$BodyStyle = as.factor(vehicles$BodyStyle)
vehicles$Segment = as.factor(vehicles$Segment)

vehicles$Seats = as.factor(vehicles$Seats)

vehicles$PlugType[(vehicles$PlugType != "Type 2 CCS")] = "Other"
vehicles$PlugType = as.factor(vehicles$PlugType)

vehicles = subset(vehicles, select = -c(Model))

vehicles %>% rename(
  Accel_sec = Accel,
  TopSpeed_kmph = TopSpeed,
  Range_km = Range,
  Efficiency_whpkm = Efficiency,
  FastCharge_kmph = FastCharge,
)

names(vehicles) = c("Index", "Brand", "Accel_sec", "TopSpeed_kmph", "Range_km", "Efficiency_whpkm", "FastCharge_kmph", "RapidCharge", "PowerTrain", "PlugType", "BodyStyle", "Segment", "Seats", "PriceUSD")

vehicles

write_rds(vehicles, "vehicles_clean.rds")

