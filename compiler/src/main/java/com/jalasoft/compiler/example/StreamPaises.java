package com.jalasoft.compiler.example;

import java.util.ArrayList;

public class StreamPaises {
    public static void main (String[] args) {
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Bolivia");
        countries.add("Argentina");
        countries.add("Argelia");
        countries.add("Portugal");
        countries.add("Italia");
        countries.add("Australia");
        countries.add("Peru");

        System.out.println("-----------------------");
        countries.stream()
                .filter(value -> value.startsWith("A"))
                .forEach(value -> System.out.println(value));
        System.out.println("-----------------------");
        countries.stream()
                .filter(value -> value.length() > 5)
                .forEach(value -> System.out.println(value));
        System.out.println("-----------------------");
        countries.stream()
                .filter(value -> value.length() % 2 == 0)
                .forEach(value -> System.out.println(value));
    }
}
