import service.VisitsPeakService;

import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Application {

   /**
    * Initiates scanner that consumes textual path of file to process it or "exit"/"quit to shut down
    */
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      log.info("Welcome!\n");

      while (true) {
         log.info("Please, input path of desired file\n");

         String path = scanner.nextLine().trim();

         if (path.equalsIgnoreCase("exit") || path.equalsIgnoreCase("quit")) {
            log.info("System is shutting down");

            break;
         }
         try {
            VisitsPeakService.calculatePeakActivity(path);
         } catch (Exception e) {
            log.error("Unable to find file by path: {}\n", path);
         }
      }
      scanner.close();
   }
}
