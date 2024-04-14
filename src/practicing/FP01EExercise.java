package practicing;

import java.util.List;

public class FP01EExercise {
    public static void main(String[] args) {

//        printOddNumbersInListFunctional(List.of(12,9,13,4,6,2,2,4,1,7));

        List<String> courses = List.of("Spring", "Spring Bott", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernates");
        List<Integer> numbers = List.of(1,2,3,4);

//        courses.stream()
//                .filter(course -> course.contains("Spring"))
//                .forEach(System.out::println);
//
//        courses.stream()
//                .filter(course -> course.length() >= 4)
//                .forEach(System.out::println);

        int sum = numbers.stream()
                .reduce(0, (x, y) -> x + y);

        System.out.println(sum);
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(n -> n % 2 != 0)
                .forEach(System.out::println);
    }

}
