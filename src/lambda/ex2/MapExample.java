package lambda.ex2;

import lambda.StringFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapExample {
    public static List<String> map(List<String> list, StringFunction stringFunction) {
        List<String> result = new ArrayList<String>();
        for (String s : list)
            result.add(stringFunction.apply(s));

        return result;
    }

    public static void main(String[] args) {
        List<String> source = Arrays.asList("hello", "java", "lambda");
        System.out.println("원본 리스트: " + source);

        System.out.println("대문자 변환 결과: " + map(source, s -> s.toUpperCase()));
        System.out.println("특수문자 데코 결과: " + map(source, s -> "***" + s + "***"));
    }
}
