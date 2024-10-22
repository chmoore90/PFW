## Working with factors
## As an example, create a single vector called data1 that contains a variable 
## with values 1, 2 or 3

data1 <- c(1,2,2,3,1,2,3,3,1,2,3,3,1) 
data1

## You can check whether a variable is a factor using is.factor()
is.factor(data1)

## The factor() function encodes a vector (i.e., variable) as a factor
fdata <- factor(data1) 
fdata 
is.factor(fdata)
table(fdata)

## The "label" argument of the factor() function assigns labels to each different
## level of the factor.  This makes interpretation easier.
label_data <- factor(data1, labels=c("A", "B", "C")) 
label_data 

table(label_data)

## Note that the factor() function can be applied to character data.
data2 <- c("Thursday","Tuesday","Thursday","Saturday","Saturday","Thursday","Tuesday","Tuesday","Tuesday",
          "Thursday","Saturday")
data2
is.factor(data2)

fdata2 <- factor(data2)
is.factor(fdata2)
table(fdata2)

# Suppose we wish the levels to be labeled in a different order for tables, graphs
# Apply the factor function with required order of the level.
order_label <- factor(fdata2,levels = c("Tuesday", "Thursday","Saturday"))
order_label
table(order_label)


## Suppose you want the factor to be on an ordinal scale (i.e., ordered) 
## Use the argument ordered = TRUE in the factor function

ord_data1 <- factor(data1, levels = c("1", "2", "3"),labels = c("A", "B", "C"), ordered = TRUE)
ord_data1
ord_data1[1] > ord_data1[2]

ord_data2 <- factor(data1, levels = c("3", "2", "1"),labels = c("C", "B", "A"), ordered = TRUE)
ord_data2
ord_data2[1] > ord_data2[2]

