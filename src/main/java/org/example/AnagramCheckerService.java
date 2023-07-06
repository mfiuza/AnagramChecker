package org.example;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AnagramCheckerService {
  public static void main(String[] args) throws IOException {
    log.traceEntry("Starting execution of AnagramChecker");

    // reading the file passed from CLI arguments
    BufferedReader reader = new BufferedReader(new FileReader(args[0]));

    // creating the results file
    File outputFile = new File("results.out");

    String line;

    // calling the anagram checker and storing results into the results file
    try (PrintWriter pw = new PrintWriter(outputFile)) {
      while ((line = reader.readLine()) != null) {
        // words in the input file must be separated by single spaces
        String[] words = line.split(" ");
        if (words.length > 2) {
          String errorMessage =
              "sample.in file is malformed. Please check spaces between the words";
          log.error(errorMessage);
          throw new RuntimeException();
        }
        pw.println(
            Arrays.toString(words)
                + " - "
                + (anagramChecker(words[0], words[1]) ? "Anagram!" : "Not Anagram"));
      }
    }

    log.traceExit();
  }

  /**
   * Method to check if a candidate word is an anagram of another. This method uses the Multiset
   * library (com.google.guava) that verifies easily if two sets are equal. Example: {m,a,r,c,e,l,o}
   * will be equal to {a,r,l,e,c,o,m} This solution is O(n) without using a lot of memory as well.
   *
   * @param string the original string.
   * @param candidate the candidate anagram.
   * @return boolean true if the candidate is an anagram of another
   */
  public static boolean anagramChecker(String string, String candidate) {
    log.traceEntry("words to check: {} and {}", string, candidate);

    // if the size of both strings are not equal, then it's not an anagram
    if (string.length() != candidate.length()) {
      return log.traceExit("with not an anagram!", false);
    }

    // creating multiset for each strings
    Multiset<Character> stringMultiset = HashMultiset.create();
    Multiset<Character> candidateMultiset = HashMultiset.create();

    for (int i = 0; i < string.length(); i++) {
      stringMultiset.add(string.charAt(i));
      candidateMultiset.add(candidate.charAt(i));
    }

    // if multisets are equal, then we found an anagram
    return log.traceExit("with anagram found!", stringMultiset.equals(candidateMultiset));
  }
}
