package NumBaseball;

import java.util.ArrayList;
import java.util.Random;

public class Preparing {
    private ArrayList<Integer> originalList;
    private ArrayList<Integer> sboList;
    public ArrayList<Integer> inputList;


    public Preparing() {
        sboList = new ArrayList<>();
        sboList.add(0);
        sboList.add(0);
        sboList.add(0);
    }

    private int Making() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(900) + 100;
    }

    public ArrayList<Integer> getOriginalList() {
        if (originalList == null) {
            int number = Making();
            originalList = new ArrayList<>();
            originalList.add(number / 100);
            originalList.add((number / 10) % 10);
            originalList.add(number % 10);
        }
        return originalList;
    }

    public ArrayList<Integer> getSboList() {
        return sboList;
    }

    public ArrayList<Integer> getInputList() {
        return inputList;
    }

    public void setInputList(ArrayList<Integer> inputList) {
        this.inputList = inputList;
    }

    public void resetSboList() {
        sboList.set(0, 0);
        sboList.set(1, 0);
        sboList.set(2, 0);
    }
}