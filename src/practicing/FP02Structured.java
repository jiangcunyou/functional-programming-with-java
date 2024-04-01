package practicing;

import java.util.List;

public class FP02Structured {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12,9,13,4,6,2,2,4,1,7);

        int sum = addListStructured(numbers);

        System.out.println(sum);
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
