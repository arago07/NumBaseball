package NumBaseball;


public class Main {
    public static String conclusion  = "no";
    public static void main(String[] args) {

        Preparing preparing = new Preparing();
        Printing printing = new Printing(preparing);

        preparing.getOriginalList();

        while (conclusion.equals("no")) {
            printing.guide();
            printing.checkSbo();
            printing.if3();
        }
    }
}
