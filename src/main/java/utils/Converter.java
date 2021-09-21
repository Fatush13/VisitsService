package utils;


public class Converter {

   /* actions */

   /**
    * Invoke this method to convert timestamp string in format of hh:mm to int representing exact minute of the day
    *
    * @param timestamp is a string in format of hh:mm that is to be returned
    *
    * @return int value is returned that represents exact minute of the day, based on timestamp param
    */
   public static int convertToMinutes(String timestamp) {
      String[] timeSplit = timestamp.split(":");

      int hours = Integer.parseInt(timeSplit[0]);
      int minutes = Integer.parseInt(timeSplit[1]);

      return hours * 60 + minutes;
   }

   /**
    * Invoke this method to convert int representing exact minute of the day to timestamp string in format of hh:mm
    *
    * @param timeFrame is an int value that represents exact minute of the day
    *
    * @return timestamp string in format of hh:mm based on int timeFrame
    */
   public static String convertToString(int timeFrame) {
      int hours = timeFrame / 60;
      int minutes = timeFrame - hours * 60;

      String minutesString = minutes < 10 ? "0".concat(Integer.toString(minutes)) : Integer.toString(minutes);

      return hours + ":" + minutesString;
   }

}
