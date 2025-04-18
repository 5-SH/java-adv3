package lambda.ex1;

import lambda.Procedure;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class M3MeasureTime {

    public static void measure(Procedure procedure) {
        long startNs = System.nanoTime();

        procedure.run();

        long endNs = System.nanoTime();
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    public static void main(String[] args) {
        measure(() -> {
            int N = 100;
            int sum = 0;
            for (int i = 1; i <= N; i++)
                sum += i;
            System.out.println("[1부터 100까지 합] 결과: " + sum);
        });

        System.out.println();

        measure(() -> {
            int N = 4;
            ArrayList arr = new ArrayList<>();
            for (int i = 1; i <= N; i++)
                arr.add(i);

            System.out.println("원본 배열: " + arr.toString());
            System.out.println("배열 정렬: " + arr.reversed());
        });
    }
}
