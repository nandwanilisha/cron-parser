# cron-parser

## Description
Cron Parser is an application that helps users parse and understand cron expressions via shell command "cron-parser".

## Usage
Cron Parser can be used after running the spring boot application as follows:

For running the application:
mvn clean install spring-boot:run

## Pass the command as follows:
shell:>cron-parser "[CRON_EXPRESSION]"

### For example: 
shell:>cron-parser "*/15 0 1,15 * 1-5 /usr/bin/find"

This will give the result:

```
minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
```
