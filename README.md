# Cron Expression Parser

A basic cron expression parsing script which takes in a cron expression as an input and outputs all possible values
for the respective time fields according to the expression.

### Building the script
#### System Requirements

* JDK 1.8 or above
* Maven 3.x

Run the following command to build the script
```bash
$ mvn clean install
```

### Running the script
Download v1.0 release from here https://github.com/victorbucutea/deliveroo/releases and execute according to specs:

```bash
$ java -jar deliveroo-cron-parser.jar "0 0 1,2,3,15 * 1-5 /usr/bin/find"
  minute        0
  hour          0
  day of month  1 2 3 15
  month         1 2 3 4 5 6 7 8 9 10 11 12
  day of week   1 2 3 4 5
  command       /usr/bin/find
```