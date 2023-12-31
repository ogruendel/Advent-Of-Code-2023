package day03;

import util.File;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Character>> input = File.listOfListFromFile("src/main/java/day03/input.txt");

        System.out.println(Schematic.solvePart1(input));
        System.out.println(Schematic.solvePart2(input));
    }
}
