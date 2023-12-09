package day09;

import util.File;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = File.listFromFile("src/main/java/day09/input.txt");
        List<String> test = File.listFromFile("src/main/java/day09/test.txt");

        System.out.println(Report.solvePart1(input));
        System.out.println(Report.solvePart2(input));
    }
}
