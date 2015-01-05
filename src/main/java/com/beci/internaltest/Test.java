package com.beci.internaltest;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Test {
//    static val test = (val) new ArrayList<String>();

//    boolean isUSSD = false;
//    private static final Integer ONE_MILLION = 1_000_000;


    public static void main(String[] args) {
        System.out.println("Test");
    }

    @SuppressFBWarnings({"UPM_UNCALLED_PRIVATE_METHOD"})
    public static List<String> transform(List<String> stringList) {
        return stringList.stream() // Convert collection to Stream
                .map(String::toUpperCase) // Convert each element to upper case
                .collect(Collectors.toList()); // Collect results to a new list

    }

    @SuppressFBWarnings({"UPM_UNCALLED_PRIVATE_METHOD"})
    private static Collector<? super String, Object, Object> toList() {
        return null;
    }



    @SuppressFBWarnings({"DM_CONVERT_CASE"})
    public static List<String> transform7(List<String> collection) {
        List<String> coll = new ArrayList<>();
        for (String element : collection) {
            coll.add(element.toUpperCase());
        }
        return coll;
    }


    //    @FunctionalInterface //FunctionalInterface should have only one abstarct method.
    interface MyNumber {
//        boolean isNumber();
//        MyNumber myNumber;
//
//        myNumber = () -> true;
        public boolean isNumber(final boolean b);
//        myNumber =
//        (n) -> {
//            return n;
//        };

        public int number(final int a, final int b);
//        myNumber = (a, b) -> a+b;




}

    @FunctionalInterface
    interface Action {
        void run(String string);
        default void stop(String param){
            System.out.println(param);
        }

        default void test(){
            System.out.println("test");
        }
    }

    public static void action(Action action){
        action.run("Hello!");

        //action((String s) -> System.out.print("*" + s + "*"));
        //Runnable r = () -> {};

//        Main::measureLambda  Class::method
    }



    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }

    @FunctionalInterface
    public interface BiFunction<T, U, R> {
        R apply(T t, U u);
    }
}
