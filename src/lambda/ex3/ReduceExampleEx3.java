package lambda.ex3;

import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceExampleEx3 {
    public static int reduce(List<Integer> list, int initial, BinaryOperator<Integer> reducer) {
        int result = initial;
        for (int val : list) {
            result = reducer.apply(result, val);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("리스트: " + numbers);
        // 1. 합 구하기 (초깃값 0, 덧셈 로직)
        BinaryOperator<Integer> add = (a, b) -> a + b;
        int sum = reduce(numbers, 0, add);
        System.out.println("합(누적 +): " + sum);
        // 2. 곱 구하기 (초깃값 1, 곱셈 로직, 람다로 작성)
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        int product = reduce(numbers, 1, multiply);
        System.out.println("곱(누적 *): " + product);
    }
}
