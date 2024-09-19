package NumBaseball;


import java.util.ArrayList;

public class Main {
    public static String conclusion = "no";
    public static boolean repeat = true;

    public static Integer gameNums = 0;
    public static ArrayList<Integer> tryNum = new ArrayList<>();
    public static void main(String[] args) {

        Preparing preparing = new Preparing();
        Printing printing = new Printing(preparing);

        while (repeat) {

            tryNum.add(0);

            ArrayList originalList = preparing.getOriginalList();

            if (!originalList.contains(0)) {
                while (conclusion.equals("no")) {
                    printing.guide();

                    if (printing.inputList == null || printing.inputList.isEmpty()) {
                        break;

                    } else {
                        printing.checkSbo();
                        printing.if3();
                    }
            }continue;
            }
            conclusion = "no";
            gameNums += 1;
        }
    }
}