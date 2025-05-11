package optional;

import java.util.Optional;

public class OptionalProcessingMain {

    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        // 값이 존재하면 Consumer 실행, 없으면 아무 일도 하지 않음
        optValue.ifPresent(v -> System.out.println("optValue 값: " + v));
        optEmpty.ifPresent(v -> System.out.println("optEmpty 값: " + v));

        // 값이 있으면 Consumer 실행, 없으면 Runnable 실행
        optValue.ifPresentOrElse(
                v -> System.out.println("optValue 값: " + v),
                () -> System.out.println("optValue는 비어있음")
        );
        optEmpty.ifPresentOrElse(
                v -> System.out.println("optEmpty 값: " + v),
                () -> System.out.println("optEmpty 비어있음")
        );

        // 값이 있으면 Function 적용 후 Optional로 반환, 없으면 Optional.empty()
        Optional<Integer> lengthOpt1 = optValue.map(String::length);
        System.out.println("optValue.map(String::length) = " + lengthOpt1);
        Optional<Integer> lengthOpt2 = optEmpty.map(String::length);
        System.out.println("optEmpty.map(String::length) = " + lengthOpt2);
        
        // map()과 비슷하지만 Optional을 반환하는 경우 중첩을 제거
        Optional<Optional<String>> nestedOpt = optValue.map(v -> Optional.of(v));
        System.out.println("optValue = " + optValue);
        System.out.println("nestedOpt = " + nestedOpt);
        Optional<String> flattenedOpt = optValue.flatMap(s -> Optional.of(s));
        System.out.println("optValue = " + optValue);
        System.out.println("flattenedOpt = " + flattenedOpt);

        // 값이 있고 조건을 만족하면 그 값을 그대로, 불만족 시 Optional.empty()
        Optional<String> filtered1 = optValue.filter(s -> s.startsWith("H"));
        Optional<String> filtered2 = optValue.filter(s -> s.startsWith("X"));
        System.out.println("filter(H) = " + filtered1);
        System.out.println("filter(X) = " + filtered2);

        // 값이 있으면 단일 요소 스트림, 없으면 빈 스트림
        optValue.stream().forEach(s -> System.out.println("optValue.stream() = " + s));
        optEmpty.stream().forEach(s -> System.out.println("optEmpty.stream() = " + s));
    }
}
