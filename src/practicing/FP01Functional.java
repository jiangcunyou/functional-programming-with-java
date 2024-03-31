package practicing;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {

//        printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,2,4,1,7));
        printEvenNumbersInListFunctionalSquares(List.of(12,9,13,4,6,2,2,4,1,7));
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        // conver to streams
        numbers.stream()
                .forEach(System.out::println);

    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        // conver to streams
        numbers.stream()
                .filter(FP01Functional::isEven)
                .forEach(System.out::println);

    }

    private static void printEvenNumbersInListFunctionalambda(List<Integer> numbers) {
        // conver to streams
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

    }

    private static void printEvenNumbersInListFunctionalSquares(List<Integer> numbers) {
        // conver to streams
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(x -> x * x)
                .forEach(System.out::println);

    }
}
