package lambda.ex3;

import lambda.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
        List<Integer> result = new ArrayList<Integer>();
        for (Integer a : list)
            if (predicate.test(a)) result.add(a);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> source = Arrays.asList(-3, -2, -1, 1,2, 3, 5);
        System.out.println("원본 리스트: " + source);

        System.out.println("음수만 = " + filter(source, a -> a < 0));
        System.out.println("짝수만 = " + filter(source, a -> a % 2 == 0));
    }
}
