package day07;

import util.File;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = File.listFromFile("src/main/java/day07/input.txt");

        System.out.println(Game.solvePart1(input));
    }
}
