package stream.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DownStreamMain {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );

        downStream1(students);
        downStream2(students);
    }

    private static void downStream2(List<Student> students) {
        // 학년 별로 학생들을 그룹화
        Map<Integer, List<Student>> collect1 = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("collect1 = " + collect1);

        // 학년 별로 가장 점수가 높은 학생(reducing)
        Map<Integer, Optional<Student>> collect2 = students.stream().collect(
                Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.reducing((s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2)));
        System.out.println("collect2 = " + collect2);

        // 학년 별로 가장 점수가 높은 학생(maxBy)
        Map<Integer, Optional<Student>> collect3 = students.stream().collect(
                Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.maxBy(Comparator.comparingInt(Student::getScore))));
        System.out.println("collect3 = " + collect3);

        // 학년 별로 가장 점수가 높은 학생의 이름(collectingAndThen + maxBy)
        Map<Integer, String> collect4 = students.stream().collect(
                Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Student::getScore)),
                                sOpt -> sOpt.get().getName())
                ));
        System.out.println("collect4 = " + collect4);
    }

    private static void downStream1(List<Student> students) {
        // 학년 별로 학생들을 그룹화
        Map<Integer, List<Student>> collect1 = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("collect1 = " + collect1);

        // 학년 별로 학생들의 이름을 출력
        Map<Integer, List<String>> collect2 = students.stream().collect(
                Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.mapping(
                                Student::getName,
                                Collectors.toList())));
        System.out.println("collect2 = " + collect2);

        // 학년 별로 학생들의 수를 출력
        Map<Integer, Long> collect3 = students.stream().collect(
                Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.counting()));
        System.out.println("collect3 = " + collect3);

        // 학년 별로 학생들의 평균 성적 출력
        Map<Integer, Double> collect4 = students.stream().collect(
                Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.averagingInt(Student::getScore)));
        System.out.println("collect4 = " + collect4);
    }
}
