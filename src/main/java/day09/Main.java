package day09;

import util.File;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = File.listFromFile("src/main/java/day09/input.txt");

        System.out.println(Report.solvePart1(input));
    }
}
