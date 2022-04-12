package io.angel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Apple {
    private String color;
    private double weight;

    Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    static boolean test(Apple item) {
        return item.color.equals("Green");
    }
}

public class App1 {
    private static List<Apple> filterApples(
            List<Apple> inventory,
            Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(
                new Apple("Red", 100),
                new Apple("Green", 120),
                new Apple("Red", 90));
        filterApples(apples, Apple::test);
    }
}