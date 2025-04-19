package lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class MapExampleEx3 {
    // 고차 함수, 함수를 인자로 받아, 리스트의 각 요소를 변환
    public static List<String> map(List<String> list, UnaryOperator<String> func) {
        List<String> result = new ArrayList<>();
        for (String str : list) {
            result.add(func.apply(str));
        }
        return result;
    }

    // Function, Consumer, Supply, Runnable, Operator, Predicate

    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트: " + words);
        // 1. 대문자 변환
        UnaryOperator<String> toUpperCase = s -> s.toUpperCase();
        List<String> upperList = map(words, toUpperCase);
        System.out.println("대문자 변환 결과: " + upperList);
        // 2. 앞뒤에 *** 붙이기 (람다로 작성)
        UnaryOperator<String> deco = s -> "***" + s + "***";
        List<String> decoratedList = map(words, deco);
        System.out.println("특수문자 데코 결과: " + decoratedList);
    }
}
