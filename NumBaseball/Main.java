package NumBaseball;


public class Main {
    public static String conclusion = "no";
    public static boolean repeat = true;

    public static void main(String[] args) {

        Preparing preparing = new Preparing();
        Printing printing = new Printing(preparing);

        while (repeat) {
            preparing.getOriginalList();

            while (conclusion.equals("no")) {
                printing.guide();
                if (preparing.inputList == null) {
                    break;
                } else {
                    printing.checkSbo();
                    printing.if3();
                }

            }
        }
    }
}