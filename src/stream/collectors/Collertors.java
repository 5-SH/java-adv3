package stream.collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collertors {

    public static void main(String[] args) {
        basic();
        map();
        group();
        minmax();
        summing();
        reducing();
    }

    private static void reducing() {
        List<String> names = List.of("a", "b", "c", "d");

        String joined1 = names.stream().collect(Collectors.reducing((s1, s2) -> s1 + ", " + s2)).get();
        System.out.println("joined1 = " + joined1);

        String joined2 = names.stream().reduce((s1, s2) -> s1 + ", " + s2).get();
        System.out.println("joined2 = " + joined2);

        String joined3 = names.stream().collect(Collectors.joining(", "));
        System.out.println("joined3 = " + joined3);

        String joined4 = String.join(", ", "a", "b", "c", "d");
        System.out.println("joined4 = " + joined4);
    }

    private static void summing() {
        Long count1 = Stream.of(1, 2, 3).collect(Collectors.counting());
        System.out.println("count1 = " + count1);

        long count2 = Stream.of(1, 2, 3).count();
        System.out.println("count2 = " + count2);

        Double average1 = Stream.of(1, 2, 3).collect(Collectors.averagingInt(i -> i));
        System.out.println("average1 = " + average1);

        double average2 = Stream.of(1, 2, 3).mapToInt(i -> i).average().getAsDouble();
        System.out.println("average2 = " + average2);

        double average3 = IntStream.of(1, 2, 3).average().getAsDouble();
        System.out.println("average3 = " + average3);

        IntSummaryStatistics stats = Stream.of("Apple", "Banana", "Tomato").collect(Collectors.summarizingInt(String::length));
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
    }

    private static void minmax() {
        Integer max1 = Stream.of(1, 2, 3).collect(Collectors.maxBy((i1, i2) -> i1.compareTo(i2))).get();
        System.out.println("max1 = " + max1);

        Integer max2 = Stream.of(1, 2, 3).max((i1, i2) -> i1.compareTo(i2)).get();
        System.out.println("max2 = " + max2);

        Integer max3 = Stream.of(1, 2, 3).max(Integer::compareTo).get();
        System.out.println("max3 = " + max3);

        int max4 = IntStream.of(1, 2, 3).max().getAsInt();
        System.out.println("max4 = " + max4);
    }

    private static void group() {
        List<String> names = List.of("Apple", "Avocado", "Banana", "Blueberry", "Cherry");
        Map<String, List<String>> grouped = names.stream().collect(Collectors.groupingBy(name -> name.substring(0, 1)));
        System.out.println("grouped = " + grouped);
    }

    private static void map() {
        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Tomato")
                .collect(
                        Collectors.toMap(
                                name -> name,
                                name -> name.length()));
        System.out.println("map1 = " + map1);

        // 키 중복 시 런타임 에러 발생
//        Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Tomato")
//                .collect(
//                        Collectors.toMap(
//                                name -> name,
//                                name -> name.length()));
//        System.out.println("map2 = " + map2);

        Map<String, Integer> map3 = Stream.of("Apple", "Apple", "Tomato")
                .collect(
                        Collectors.toMap(
                                name -> name,
                                name -> name.length(),
                                (oldVal, newVal) -> oldVal + newVal));
        System.out.println("map3 = " + map3);

        LinkedHashMap<String, Integer> map4 = Stream.of("Apple", "Apple", "Tomato")
                .collect(
                        Collectors.toMap(
                                name -> name,
                                String::length,
                                (oldVal, newVal) -> oldVal + newVal,
                                LinkedHashMap::new));
        System.out.println("map4 = " + map4);
    }

    private static void basic() {
        List<String> list = Stream.of("Java", "Spring", "JPA").collect(Collectors.toList());
        System.out.println("list = " + list);

        List<Integer> unmodifiableList = Stream.of(1, 2, 3).collect(Collectors.toUnmodifiableList());
        // 리스트 수정 시 런타임 에러 발생
        // unmodifiableList.add(4);
        System.out.println("unmodifiableList = " + unmodifiableList);

        Set<Integer> set = Stream.of(1, 2, 2, 3, 3, 3).collect(Collectors.toSet());
        System.out.println("set = " + set);

        TreeSet<Integer> treeSet = Stream.of(3, 4, 5, 2, 1).collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeSet = " + treeSet);
    }
}
