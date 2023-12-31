package day02;

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
                if (!isGamePossible(getCubeAmountsPerTurn(turn), this.maxRed, this.maxGreen, this.maxBlue)) {
                    isPossible = false;
                }
            }
            if (isPossible) {
                output += getGameID(game);
            }
        }
        return output;
    }

    public int solvePart2(List<String> games) {
        int sumOfPowers = 0;
        for (String game : games) {
            sumOfPowers += powerOfGame(getCubeAmountsPerGame(game));
        }
        return sumOfPowers;
    }

    private static int getGameID(String input) {
        return Integer.parseInt(input.substring(5, input.indexOf(':')));
    }

    private static List<String> getGameTurns(String input) {
        input = input.substring(input.indexOf(':') + 2);
        return List.of(input.split("; "));
    }

    private static int[] getCubeAmountsPerTurn(String input) {
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

    private static int[] getCubeAmountsPerGame(String input) {
        int[] output = new int[]{0, 0, 0};
        List<String> turns = getGameTurns(input);
        for (String turn : turns) {
            String[] cubes = turn.split(", ");
            for (String cube : cubes) {
                int numOfCubes = Integer.parseInt(cube.substring(0, cube.indexOf(' ')));
                if (cube.contains("red")) {
                    if (output[0] < numOfCubes) {
                        output[0] = numOfCubes;
                    }
                }
                if (cube.contains("green")) {
                    if (output[1] < numOfCubes) {
                        output[1] = numOfCubes;
                    }
                }
                if (cube.contains("blue")) {
                    if (output[2] < numOfCubes) {
                        output[2] = numOfCubes;
                    }
                }
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

    private static int powerOfGame(int[] cubeAmounts) {
        return cubeAmounts[0] * cubeAmounts[1] * cubeAmounts[2];
    }
}
