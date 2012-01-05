public class MeaningOfLife {
    public static String findOutWhatLifeIsAllAboutAltered() {
        int meaning = 0;
        for (int i = 0; i < 10; i++) {
          for (int j = 0; j < 20; j++) {
            for (int k = 0; k < 300; k++) {
              for (int m = 0; m < 7000; m++) {
                double randomResult = Math.random();
                int converted = (int)randomResult;
                
                if (converted > 0) {
                    System.out.println("Misbehaving double = " + randomResult);
                }
              
                meaning += converted + 1;
              }
            }
          }
        }
        return String.valueOf(meaning).replaceAll("0*$", "");
    }

    public static String findOutWhatLifeIsAllAbout() {
        int meaning = 0;
        for (int i = 0; i < 10; i++) {
          for (int j = 0; j < 20; j++) {
            for (int k = 0; k < 300; k++) {
              for (int m = 0; m < 7000; m++) {
                meaning += Math.random() + 1;
              }
            }
          }
        }
        return String.valueOf(meaning).replaceAll("0*$", "");
    }
    
    public static void main(String[] args) {
        System.out.println(findOutWhatLifeIsAllAbout());
        System.out.println(findOutWhatLifeIsAllAboutAltered());
    }
}
