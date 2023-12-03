package day03;

import util.File;
import util.IntPair;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Character>> input = File.listOfListFromFile("src/main/java/day03/input.txt");
        List<List<Character>> test = File.listOfListFromFile("src/main/java/day03/test.txt");

        System.out.println(Schematic.solvePart1(input));
        System.out.println(Schematic.solvePart1(test));
    }
}
