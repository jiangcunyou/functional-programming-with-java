package practicing;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Exercise {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,2,4,1,7);
        List<Integer> doubleNumbers = doubleList(numbers);
        List<Integer> evenNumbersOnly = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

//        int sum = numbers.stream().reduce(0, (x, y) -> x + y * y);
//        int sum = numbers.stream()
//                                .map(x -> x * x)
//                                .reduce(0, Integer::sum);

//        int sum = numbers.stream().filter(x -> x % 2 == 1)
//                .map(x -> x * x)
//                .reduce(0, Integer::sum);

//        numbers.stream().distinct().forEach(System.out::println);
//        numbers.stream().distinct().sorted().forEach(System.out::println);

        List<String> courses = List.of("Spring", "Spring Bott", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker", "Kubernates");

        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    private static int sum(int aggregate, int nextNumber) {
        System.out.println(aggregate + " " + nextNumber);
        return aggregate + nextNumber;
    }

    private static int addListStructured(List<Integer> numbers) {

        return numbers.stream()
                .reduce(0, (x,y) -> x + y);

    }


}
