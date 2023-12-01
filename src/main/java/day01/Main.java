package day01;

import util.File;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = File.listFromFile("src/main/java/day01/input.txt");
        List<String> test = File.listFromFile("src/main/java/day01/test.txt");
        List<String> test2 = File.listFromFile("src/main/java/day01/test2.txt");

        System.out.println(Trebuchet.solvePart1(input));
        System.out.println(Trebuchet.solvePart2(input));
    }
}
