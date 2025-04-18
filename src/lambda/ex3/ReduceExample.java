package lambda.ex3;

import lambda.MyReducer;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {

    public static int reduce(List<Integer> list, int initial, MyReducer reducer) {
        int result = initial;
        for (int a : list)
            result = reducer.reduce(result, a);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> source = Arrays.asList(1, 2, 3, 4);
        System.out.println("리스트: " + source);

        System.out.println("합(누적 +) :" + reduce(source, 0, (a, b) -> a + b));
        System.out.println("곱(누적 *) :" + reduce(source, 1, (a, b) -> a * b));
    }
}
