import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import org.example.AnagramCheckerService;
import org.junit.jupiter.api.Test;

public class AnagramCheckerServiceTest {

  @Test
  public void whenAnagramCheckerIsCalledWithAnagram_thenReturnTrue() {

    // act
    boolean isAnagram = AnagramCheckerService.anagramChecker("silent", "listen");

    // assert
    assertTrue(isAnagram);
  }

  @Test
  public void whenAnagramCheckerIsCalledWithoutAnagram_thenReturnFalse() {

    // act
    boolean isAnagram = AnagramCheckerService.anagramChecker("silent", "listener");

    // assert
    assertFalse(isAnagram);
  }

  @Test
  public void whenAnagramCheckerServiceIsCalledWithCorrectFile_thenExecuteAnagramChecker()
      throws IOException {

    // arrange
    String[] args = new String[] {"src/test/resources/SampleTest.in"};

    // act
    AnagramCheckerService.main(args);
  }

  @Test
  public void whenAnagramCheckerServiceIsCalledWithMalformedFile_thenThrowError()
      throws IOException {

    // arrange
    String[] args = new String[] {"src/test/resources/wrongSampleTest.in"};
    RuntimeException exception = null;

    // act
    try {
      AnagramCheckerService.main(args);
    } catch (RuntimeException e) {
      exception = e;
    }

    assertNotNull(exception);
  }
}
