import java.util.List;
import java.util.Map;


public class Application {

   public static void main(String[] args) {
     List<Map.Entry<Float, Float>> visits = CsvParser.parseCsv("src/main/resources/Visits.txt");
   }
}
