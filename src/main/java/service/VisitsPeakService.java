package service;


import utils.CsvParser;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import static utils.Converter.convertToMinutes;
import static utils.Converter.convertToString;


@Slf4j
public class VisitsPeakService {

   /* actions */

   /**
    * Invoke this method to calculate and display time frame or frames of maximum visitors present simultaneously.
    *
    * @param path is a path to input file that is to be processed
    */
   public static void calculatePeakActivity(String path) {
      List<String> visits = CsvParser.parseCsv(path);

      Map<Integer, Integer> minuteFrames = fillInFrames(visits);

      Map<Integer, Integer> peakFrames = maxValueEntries(minuteFrames);

      displayResult(peakFrames);
   }

   /* implementation */

   private static Map<Integer, Integer> fillInFrames(List<String> visits) {
      final int minutesADay = (int) TimeUnit.DAYS.toMinutes(1L);
      Map<Integer, Integer> minuteFrames = new HashMap<>();

      for (int i = 0; i < minutesADay; i++) {
         int count = 0;
         for (String visit : visits) {
            String[] timeRange = visit.split(",");

            int from = convertToMinutes(timeRange[0]);
            int to = convertToMinutes(timeRange[1]);

            if (from <= i && i <= to) {
               count++;
            }
         }
         minuteFrames.put(i, count);
      }
      return minuteFrames;
   }

   private static Map<Integer, Integer> maxValueEntries(Map<Integer, Integer> initialMap) {
      int maxValue = Collections.max(initialMap.values());

      Map<Integer, Integer> peakFrames = initialMap.entrySet().stream()
           .filter(entry -> entry.getValue().equals(maxValue))
           .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

      return new TreeMap<>(peakFrames);
   }

   private static void displayResult(Map<Integer, Integer> peakFrames) {
      int from = 0;
      int to = 0;

      for (Entry<Integer, Integer> frame : peakFrames.entrySet()) {
         if (from == 0) {
            from = frame.getKey();
            to = from;
         }
         if (peakFrames.containsKey(frame.getKey() + 1)) {
            to++;
         } else {
            log.info(convertToString(from) + "-" + convertToString(to) + ";" + frame.getValue());
            from = 0;
         }
      }
   }

}
