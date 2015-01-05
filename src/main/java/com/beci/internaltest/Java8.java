package com.beci.internaltest;


import com.beci.Utils;
import com.beci.model.ProfileModel;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.hibernate.annotations.SourceType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8 {

    @SuppressFBWarnings({"UUF_UNUSED_FIELD"})
    static class  Outer {
        Nested nested;
    }

    @SuppressFBWarnings({"UUF_UNUSED_FIELD"})
    static class Nested {
        Inner inner;
    }

    @SuppressFBWarnings({"UUF_UNUSED_FIELD"})
    static class Inner {
        String foo;
    }

    interface Formula {
        double DOUBLE = 0.0;
        double calculate(int a);

        default double test(int a) {
            return calculate(a);
        }

        default double sqrt(int a) {
            return Math.sqrt(calculate(a));
        }


    }

    interface PersonFactory<T extends ProfileModel> {
        T create(String firstName, String lastName);
    }


    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add(null);
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("2");
        stringList.add("3");
        stringList.add("3");
        System.out.println(stringList);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1000);
        integerList.add(9);
        integerList.add(10);
        integerList.add(10000);
        System.out.println(integerList);



    }



    public static Map<String, List<String>> groupByNationality(List<String> people) {
        return people.stream().collect(Collectors.groupingBy(s -> "key" + s));
    }

    @SuppressFBWarnings({"DLS_DEAD_LOCAL_STORE"})
    public static void test(){
        // http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
        // http://www.javacodegeeks.com/2014/11/java-8-streams-micro-katas.html
        // http://winterbe.com/posts/2014/03/16/java-8-tutorial/
        // http://blog.jooq.org/2014/06/13/java-8-friday-10-subtle-mistakes-when-using-the-streams-api/
        // http://howtodoinjava.com/2014/04/13/java-8-tutorial-streams-by-examples/
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream()
        .filter(s -> s.startsWith("c"))
        .map(String::toUpperCase)
        .sorted().collect(Collectors.toList());
//                .forEach(System.out::println);

        PersonFactory<ProfileModel> personFactory = ProfileModel::new;
//        ProfileModel profileModel = personFactory.create("Peter", "Parker");

        Arrays.asList()
                .stream()
                .findFirst()
                .ifPresent((s) -> System.out.println("ssssss" + s));  // a1

        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));

        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });

//        .filter((s) -> {
////                    System.out.println(s+"");
//            return !Utils.isNull(s);
//        })
//        IntStream.range(1, 4)
//                .forEach(System.out::println);
//        IntStream.rangeClosed(1, 4).forEach(System.out::println);
//        IntStream.iterate(0, i -> i + 1)
//                .limit(10)
//                .forEach(System.out::println);
//        IntStream.iterate(0, i -> i + 1)
//                .limit(10) // LIMIT
//                .skip(5)   // OFFSET
//                .forEach(System.out::println); //56789
//        integerList.stream()
//                .sorted()
////                .peek(integerList::remove)
//                .forEach(System.out::println);
//        List<String> names = stringList.stream()
//                .map(Integer::valueOf)
//                .filter((i) -> i > 1)
//                .map(String::valueOf)
//                .collect(Collectors.toList());
//        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
//        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
//        System.out.println(stats);
//        String name = myList.stream()
//                .filter(s -> s.startsWith("c"))
//                .findFirst()
//                .get();

//        Function<Integer,Integer> add1 = x -> x + 1;
//        Function<String,String> concat1 = x -> x + 1;
//
//        Integer two = add1.apply(1);
//        String answer = concat1.apply("2 + 1 = ");
//        Function<Integer,Integer> add1 = x -> x + 1;
//        Function<Integer,Integer> mul3 = x -> x * 3;
//        BinaryOperator<Function<Integer,Integer>> compose;
//        compose = (f,g) -> x -> g.apply(f.apply(x));
//        Function<Integer,Integer> h = compose.apply(add1, mul3);
//        Integer res = h.apply(10); //yields 33
    }





    public static int countNumber(List<Integer> integerList) {
        return integerList.stream().reduce(500, Integer::sum);
//        return integerList.stream().reduce(500, (x,y) -> x+y);
    }

    public static String namesToString(List<String> people) {
        return people.stream() // Convert collection to Stream
                .collect(Collectors.joining(", ", "Names: ", ".")); // Join names
    }

    public static List<String> transform(List<String> stringList) {
        return stringList.stream() // Convert collection to Stream
//                .map(String::toUpperCase) // Convert each element to upper case
                .map((String string) -> string.toUpperCase())
                .collect(Collectors.toList()); // Collect results to a new list
    }

    public static Integer sum(List<String> stringList) {
        return stringList.stream().collect(Collectors.summingInt(n -> Integer.parseInt(n)));
    }

    public static List<Integer> transformToInt(List<String> stringList) {
        return stringList.stream()
                .map((String string) -> Integer.parseInt(string)+100)
                .collect(Collectors.toList());
    }



    public void date(){
        final Clock clock = Clock.systemDefaultZone();
        System.out.println( clock.instant() );
        System.out.println( clock.millis() );
        final LocalDateTime datetime = LocalDateTime.now();
        final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );
        System.out.println( datetime );
        System.out.println( datetimeFromClock );
        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );

        final Duration duration = Duration.between( from, to );
        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );
    }

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }

    @FunctionalInterface
    public interface BiFunction<T, U, R> {
        R apply(T t, U u);
    }

    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);
    }

    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T t);
    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

//    final int num = 1;
//    Converter<Integer, String> stringConverter =
//            (from) -> String.valueOf(from + num);
//    System.out.println(stringConverter.convert(2));

//    Arrays.stream(new int[] {1, 2, 3})
//            .map(n -> 2 * n + 1)
//            .average()
//    .ifPresent(System.out::println);
}


