package day06;

import util.File;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = File.listFromFile("src/main/java/day06/input.txt");
        List<String> test = File.listFromFile("src/main/java/day06/test.txt");

        System.out.println(Race.solvePart1(input));
        System.out.println(Race.solvePart2(input));
    }
}
