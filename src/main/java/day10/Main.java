package day10;

import util.File;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Character>> input = File.listOfListFromFile("src/main/java/day10/input.txt");

        System.out.println(Loop.solvePart1(input));
    }
}
