package lambda.lambda5.mystream;

import lambda.GenericFilter;
import lambda.GenericMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Ex1_Number {

    public static void main(String[] args) {
        // 짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);
        List<Integer> lambdaResult = lambda(numbers);
        System.out.println("lambdaResult = " + lambdaResult);
    }

    static List<Integer> direct(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : numbers)
            if (num % 2 == 0) result.add(num * 2);

        return result;
    }

    static List<Integer> lambda(List<Integer> numbers) {
        return GenericMapper.map(GenericFilter.filter(numbers, n -> n % 2 == 0), n -> n * 2);
    }
}
