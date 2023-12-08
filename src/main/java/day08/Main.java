package day08;


import util.File;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = File.listFromFile("src/main/java/day08/input.txt");

        System.out.println(Map.solvePart1(input));
        System.out.println(Map.solvePart2(input));
    }
}
