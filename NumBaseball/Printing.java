package NumBaseball;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Printing {
    private Preparing preparing;

    public Printing(Preparing preparing) {
        this.preparing = preparing;
    }

    public ArrayList<Integer> guide() {
        ArrayList<Integer> inputList = new ArrayList<>();
        boolean rInput = false;
        Scanner sc = new Scanner(System.in);

        while (!rInput) {

            try {
                System.out.println("3자리 숫자를 입력해주세요. \n이때 각 숫자는 1~9의 자연수이며, 동일한 숫자는 사용할 수 없습니다.");
                int input = sc.nextInt();

                if (input >= 100 && input < 999) {
                    inputList.add(input / 100);
                    inputList.add((input / 10) % 10);
                    inputList.add(input % 10);

                    preparing.setInputList(inputList);
                    if (inputList.get(0).equals(inputList.get(1)) || inputList.get(1).equals(inputList.get(2)) || inputList.get(2).equals(inputList.get(0))) {
                        System.out.println("올바르지 않은 입력입니다.");
                        inputList.clear();
                    } else {
                        rInput = true;
                    }
                } else if (input < 100 || input > 999) {
                    System.out.println("올바르지 않은 입력입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("올바르지 않은 입력입니다.");
                sc.next();
            }
        }return inputList;
    }


    public void checkSbo() {
        ArrayList<Integer> sboList = preparing.getSboList();
        ArrayList<Integer> originalList = preparing.getOriginalList();
        ArrayList<Integer> inputList = preparing.getInputList();
        preparing.resetSboList();

        for (int i = 0; i < 3; i++) {
            if (originalList.get(i).equals(inputList.get(i))) {
                sboList.set(0, sboList.get(0) + 1);
            } else if (originalList.contains(inputList.get(i))) {
                sboList.set(1, sboList.get(1) + 1);
            } else {
                sboList.set(2, sboList.get(2) + 1);
            }
            System.out.println(sboList.get(0) + " Strike," + sboList.get(1) + " Ball," + sboList.get(2) + " Out.");

        }
    }

    public String if3() {
        ArrayList<Integer> sboList = preparing.getSboList();
        ArrayList<Integer> inputList = preparing.getInputList();
        if (sboList.get(0).equals(3)) {
            System.out.println("정답을 맞추셨습니다! 축하드립니다.");
            return Main.conclusion = "yes";
        } else {
            inputList.clear();
            preparing.resetSboList();
            return Main.conclusion = "no";
        }
    }
}