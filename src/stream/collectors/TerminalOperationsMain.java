package stream.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationsMain {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers1 = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("짝수 리스트1: " + evenNumbers1);
        System.out.println();

        List<Integer> evenNumbers2 = numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("짝수 리스트2: " + evenNumbers2);
        System.out.println();

        Integer[] arr = numbers.stream().filter(n -> n % 2 == 0).toArray(Integer[]::new);
        System.out.println("짝수 배열: " + Arrays.toString(arr));
        System.out.println();

        numbers.stream().limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        long count = numbers.stream().filter(n -> n > 5).count();
        System.out.println("5보다 큰 숫자 개수: " + count);
        System.out.println();

        Optional<Integer> sum1 = numbers.stream().reduce((a, b) -> a + b);
        System.out.println("reduce 합계: " + sum1.get());
        System.out.println();

        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("최소: " + min.get() + ", " + "최대: " + max.get());
        System.out.println();

        Integer first = numbers.stream().filter(n -> n > 5).findFirst().get();
        System.out.println("5보다 큰 첫 번째 요소: " + first);
        System.out.println();

        Integer any = numbers.stream().filter(n -> n > 5).findAny().get();
        System.out.println("5보다 큰 아무 요소: " + any);
        System.out.println();

        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("짝수가 있는지? " + hasEven);
        System.out.println();

        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("모든 숫자가 양수인지? " + allPositive);
        System.out.println();

        boolean noNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("음수가 없는지? " + noNegative);
    }
}
