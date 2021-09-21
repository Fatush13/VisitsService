package utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CsvParser {


   /** Invoke this method to return a list of strings that are parsed from csv format file content
    *
    *
    * @param path is a path to input file that is to be parsed
    * @return list of strings as a result of parsing the file content
    *
    * @throws java.io.IOException in case of parsing errors
    */
   @SneakyThrows
   public static List<String> parseCsv(String path) {
         BufferedReader reader = new BufferedReader(new FileReader(path));

         List<String> visits = new ArrayList<>();
         String visit;

         while ((visit = reader.readLine()) != null) {
               visits.add(visit);
         }
         return visits;
   }
}
