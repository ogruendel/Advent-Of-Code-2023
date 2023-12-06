package day05;

import util.File;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = List.of(File.stringFromFile("src/main/java/day05/input.txt").split("\\n"));
        List<String> test = List.of(File.stringFromFile("src/main/java/day05/test.txt").split("\\n"));

        System.out.println(Almanac.solvePart1(input));
    }
}
