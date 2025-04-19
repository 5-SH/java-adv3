package lambda.lambda5.mystream;

import lambda.GenericFilter;
import lambda.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex2_Student {
    public static void main(String[] args) {
        // 점수가 80점 이상인 학생의 이름을 추출해라.
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );
        List<String> directResult = direct(students);
        System.out.println("directResult = " + directResult);
        List<String> lambdaResult = lambda(students);
        System.out.println("lambdaResult = " + lambdaResult);
    }

    private static List<String> direct(List<Student> students) {
        List<String> result = new ArrayList<>();
        for (Student s : students)
            if (s.getScore() >= 80) result.add(s.getName());

        return result;
    }

    private static List<String> lambda(List<Student> students) {
        return GenericMapper.map(GenericFilter.filter(students, s -> s.getScore() >= 80), s -> s.getName());
    }
}
