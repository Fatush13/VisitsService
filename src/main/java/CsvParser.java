import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static java.util.AbstractMap.SimpleEntry;


@Slf4j
public class CsvParser {

   @SneakyThrows
   public static List<Entry<Float, Float>> parseCsv(String path) {
      List<Entry<Float, Float>> visits = new ArrayList<>();

      try {
         BufferedReader reader = new BufferedReader(new FileReader(path));
         String visit;

         while ((visit = reader.readLine()) != null) {
            visits.add(stringToFloatEntry(visit));
         }
         log.error("Result: {}", visits);


         return visits;
      } catch (Exception e) {
         log.error("Das bad");
         throw e;
      }
   }

   private static SimpleEntry<Float, Float> stringToFloatEntry(String input) {
      String[] inputArray = input.split(",");

      Float left = Float.parseFloat(inputArray[0].replace(":", "."));
      Float right = Float.parseFloat(inputArray[1].replace(":", "."));

      return new SimpleEntry<>(left, right);
   }

}
