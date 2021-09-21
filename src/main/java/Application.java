import service.VisitsPeakService;


public class Application {

   /**
    * The one and only PSVM
    */
   public static void main(String[] args) {
     VisitsPeakService.calculatePeakActivity("src/main/resources/Visits.txt");
   }
}
