# "Anagram Checker Challenge"

This project was created to provide a simple way of identifying anagrams. 

## Usage
To run this project, you will need to add sample.in in your CLI argument on your IDE (or pass it when you call the main method).
The file needs to have two words on each line separated by a space.

```bash
marcelo arlecom
listener silent
```

The result of the anagram analysis will be shown in the results.out file. Each line represents one "check" and the result.

```bash
[marcelo, arlecom] - Anagram!
[listener, silent] - Not Anagram
```
The project was implemented with LOG4J2 logging, and the level of logging can be changed on log4j2.xml (WARN, ERROR, TRACE, etc).
It's set to TRACE just to indicate on the console the words being processed.
