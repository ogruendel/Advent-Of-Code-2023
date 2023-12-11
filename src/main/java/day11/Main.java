package day11;

import util.File;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Character>> input = File.listOfListFromFile("src/main/java/day11/input.txt");

        System.out.println(Universe.solvePart1(input));
        System.out.println(Universe.solvePart2(input));
    }
}
