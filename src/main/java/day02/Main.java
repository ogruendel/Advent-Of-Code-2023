package day02;

import util.File;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> input = File.listFromFile("src/main/java/day02/input.txt");

        Game game = new Game(12, 13, 14);
        System.out.println(game.solvePart1(input));
        System.out.println(game.solvePart2(input));
    }
}
