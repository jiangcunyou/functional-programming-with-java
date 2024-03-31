package practicing;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {

        printAllNumbersInListStructured(List.of(12,9,13,4,6,2,2,4,1,7));
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        for(int number : numbers) {
            System.out.println(number);
        }
    }
}
