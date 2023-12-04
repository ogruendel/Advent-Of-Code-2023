package day04;

import util.File;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = File.listFromFile("src/main/java/day04/input.txt");
        List<String> test = File.listFromFile("src/main/java/day04/test.txt");

        System.out.println(Game.solvePart1(input));
        System.out.println(Game.solvePart2(test));
    }
}
