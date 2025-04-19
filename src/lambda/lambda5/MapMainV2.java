package lambda.lambda5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV2 {
    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");
        // 문자열을 숫자로 변환
        List<Integer> numbers = map(list, s -> Integer.parseInt(s));
        System.out.println("numbers = " + numbers);
        // 문자열의 길이
        List<Integer> lengths = map(list, s -> s.length());
        System.out.println("lengths = " + lengths);
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T a : list)
            result.add(function.apply(a));
        return result;
    }
}
