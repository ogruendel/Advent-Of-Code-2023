package day02;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int maxRed;
    private int maxGreen;
    private int maxBlue;

    public Game(int maxRed, int maxGreen, int maxBlue) {
        this.maxRed = maxRed;
        this.maxGreen = maxGreen;
        this.maxBlue = maxBlue;
    }

    public int solvePart1(List<String> games) {
        int output = 0;
        boolean isPossible;
        for (String game : games) {
            isPossible = true;
            List<String> turns = getGameTurns(game);
            for (String turn : turns) {
                if (!isGamePossible(getCubeAmounts(turn), this.maxRed, this.maxGreen, this.maxBlue)) {
                    isPossible = false;
                }
            }
            if (isPossible) {
                output += getGameID(game);
            }
        }
        return output;
    }

    private static int getGameID(String input) {
        return Integer.parseInt(input.substring(5, input.indexOf(':')));
    }

    private static List<String> getGameTurns(String input) {
        input = input.substring(input.indexOf(':') + 2);
        return List.of(input.split("; "));
    }

    private static int[] getCubeAmounts(String input) {
        int[] output = new int[]{0, 0, 0};
        String[] cubes = input.split(", ");
        for (String cube : cubes) {
            int numOfCubes = Integer.parseInt(cube.substring(0, cube.indexOf(' ')));
            if (cube.contains("red")) {
                output[0] = numOfCubes;
            }
            if (cube.contains("green")) {
                output[1] = numOfCubes;
            }
            if (cube.contains("blue")) {
                output[2] = numOfCubes;
            }
        }
        return output;
    }

    private static boolean isGamePossible(int[] cubeAmounts, int maxRed, int maxGreen, int maxBlue) {
        boolean isPossible = true;
        if (cubeAmounts[0] > maxRed) {
            isPossible = false;
        } else if (cubeAmounts[1] > maxGreen) {
            isPossible = false;
        } else if (cubeAmounts[2] > maxBlue) {
            isPossible = false;
        }
        return isPossible;
    }


    public void setMaxRed(int maxRed) {
        this.maxRed = maxRed;
    }

    public void setMaxGreen(int maxGreen) {
        this.maxGreen = maxGreen;
    }

    public void setMaxBlue(int maxBlue) {
        this.maxBlue = maxBlue;
    }
}
