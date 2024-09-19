package NumBaseball;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Printing {
    private Preparing preparing;
    boolean rInput;

    public Printing(Preparing preparing) {
        this.preparing = preparing;
    }

    ArrayList<Integer> inputList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ArrayList<Integer> guide() {
        rInput = false;
        try {
            System.out.println("환영합니다. 원하시는 번호를 입력해주세요. 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            int choose123 = sc.nextInt();
            sc.nextLine();
            while (!rInput) {
                try {
                    if (choose123 == 1) {
                        num3();
                    } else if (choose123 == 2) {
                        System.out.println("<게임 기록 보기>");
                        if (Main.gameNums == 1) {
                            System.out.println("시도한 기록이 없습니다.");
                            rInput = true;
                        } else {
                            for (int i = 0; i-1 < Main.gameNums; i++) {
                                System.out.println((i+1) + "번째 게임 : 시도 횟수 - " + Main.tryNum.get(i));
                            }
                            rInput = true;
                        }
                    } else if (choose123 == 3) {
                        System.out.println("게임을 종료합니다.");
                        System.exit(0);
                    } else {
                        System.out.println("올바르지 않은 입력입니다. 다시 입력해주세요.");
                        inputList.clear();
                        rInput = true;

                    }
                } catch (InputMismatchException e) {
                    System.out.println("올바르지 않은 입력입니다. 다시 입력해주세요.");
                    inputList.clear();
                    Main.conclusion = "yes";
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("올바르지 않은 입력입니다.");
            inputList.clear();
            Main.conclusion = "yes";
        }
        return inputList;
    }

    public boolean num3() {
        Main.tryNum.set(Main.gameNums, Main.tryNum.get(Main.gameNums+ 1));

        try {
            System.out.println("3자리 숫자를 입력해주세요. \n이때 각 숫자는 1~9의 자연수이며, 동일한 숫자는 사용할 수 없습니다.");
            int input = sc.nextInt();
            sc.nextLine();

            if (input >= 100 && input < 999) {
                inputList.add(input / 100);
                inputList.add((input / 10) % 10);
                inputList.add(input % 10);

                preparing.setInputList(inputList);
                if (inputList.get(0).equals(inputList.get(1)) || inputList.get(1).equals(inputList.get(2))
                        || inputList.get(2).equals(inputList.get(0)) || inputList.contains(0)) {
                    System.out.println("올바르지 않은 입력입니다.");
                    inputList.clear();
                } else {
                    rInput = true;
                }
            } else {
                System.out.println("올바르지 않은 입력입니다.");
                inputList.clear();

            }
            return false;

        } catch (InputMismatchException e) {
            System.out.println("올바르지 않은 입력입니다.");
            sc.nextLine();
            inputList.clear();
        }
        return false;
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
            inputList.clear();
            preparing.resetSboList();
            System.out.println("정답을 맞추셨습니다! 축하드립니다.");
            return Main.conclusion = "yes";
        } else {
            inputList.clear();
            preparing.resetSboList();
            Main.tryNum.set(Main.gameNums, (Main.tryNum.get(Main.gameNums)) + 1);
            return Main.conclusion = "no";
        }
    }
}