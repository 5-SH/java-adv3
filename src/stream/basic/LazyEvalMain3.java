package stream.basic;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class LazyEvalMain1 {

    public static void main(String[] args) {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    private static void ex2(List<Integer> data) {
        List<Integer> result = data.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 10)
                .toList();

        System.out.println("Stream API result = " + result);
    }

    private static void ex1(List<Integer> data) {
        List<Integer> result = MyStreamV3.of(data)
                .filter(i -> i % 2 == 0)
                .map(i -> i * 10)
                .toList();

        System.out.println("MyStreamV3 result = " + result);
    }
}
