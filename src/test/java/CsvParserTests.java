import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CsvParserTests extends Assertions {

   private static final String PATH_TXT = "src/main/resources/Visits.txt";

   @Test
   void testParseTxt() {
      assertFalse(CsvParser.parseCsv(PATH_TXT).isEmpty());
   }

}
