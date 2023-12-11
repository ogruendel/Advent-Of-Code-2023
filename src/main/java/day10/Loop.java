package day10;

import java.util.ArrayList;
import java.util.List;

public class Loop {
    private static List<Pipe> pipes = new ArrayList<>();

    public static int solvePart1(List<List<Character>> input) {
        generatePipeLoop(input);
        return pipes.size() / 2;
    }

    private static Pipe getFirstPipe(List<List<Character>> input) {
        Pipe starter = null;
        for (int row = 0; row < input.size(); row++) {
            for (int col = 0; col < input.get(row).size(); col++) {
                if (input.get(row).get(col) == 'S') {
                    starter = new Pipe('S', row, col);
                }
            }
        }

        Pipe newPipe;

        if (starter.getRow() > 0) {
            switch (input.get(starter.getRow() - 1).get(starter.getCol())) {
                case '|' -> {
                    newPipe = new Pipe('|', starter.getRow() - 1, starter.getCol());
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
                case '7' -> {
                    newPipe = new Pipe('7', starter.getRow() - 1, starter.getCol());
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
                case 'J' -> {
                    newPipe = new Pipe('J', starter.getRow() - 1, starter.getCol());
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
            }
        }

        if (starter.getRow() < input.size()) {
            switch (input.get(starter.getRow() + 1).get(starter.getCol())) {
                case '|' -> {
                    newPipe = new Pipe('|', starter.getRow() + 1, starter.getCol());
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
                case 'L' -> {
                    newPipe = new Pipe('L', starter.getRow() + 1, starter.getCol());
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
                case 'J' -> {
                    newPipe = new Pipe('J', starter.getRow() + 1, starter.getCol());
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
            }
        }

        if (starter.getCol() > 0) {
            switch (input.get(starter.getRow()).get(starter.getCol() - 1)) {
                case '-' -> {
                    newPipe = new Pipe('-', starter.getRow(), starter.getCol() - 1);
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
                case 'F' -> {
                    newPipe = new Pipe('F', starter.getRow(), starter.getCol() - 1);
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
                case 'L' -> {
                    newPipe = new Pipe('L', starter.getRow(), starter.getCol() - 1);
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
            }
        }

        if (starter.getCol() < input.get(starter.getRow()).size()) {
            switch (input.get(starter.getRow()).get(starter.getCol() + 1)) {
                case '-' -> {
                    newPipe = new Pipe('-', starter.getRow(), starter.getCol() + 1);
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
                case 'J' -> {
                    newPipe = new Pipe('J', starter.getRow(), starter.getCol() + 1);
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
                case '7' -> {
                    newPipe = new Pipe('7', starter.getRow(), starter.getCol() + 1);
                    newPipe.setFirstConnected(starter);
                    starter.setFirstConnected(newPipe);
                    return starter;
                }
            }
        }

        return starter;
    }

    private static void generatePipeLoop(List<List<Character>> input) {
        pipes.add(getFirstPipe(input));
        Pipe nextPipe = getNextConnected(input, pipes.getLast());

        while (nextPipe != null) {
            pipes.add(nextPipe);
            nextPipe = getNextConnected(input, pipes.getLast());
        }
        System.out.println("Done");
    }

    private static Pipe getNextConnected(List<List<Character>> input, Pipe pipe) {
        int row = pipe.getRow();
        int col = pipe.getCol();
        int prevRow = pipe.getFirstConnected().getRow();
        int prevCol = pipe.getFirstConnected().getCol();
        Pipe newPipe = null;

        if (row + 1 != prevRow && row + 1 < input.size() && pipe.getSymbol() != '-' && pipe.getSymbol() != 'L' && pipe.getSymbol() != 'J') {
            switch (input.get(row + 1).get(col)) {
                case '|' -> {
                    newPipe = new Pipe('|', row + 1, col);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case 'L' -> {
                    newPipe = new Pipe('L', row + 1, col);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case 'J' -> {
                    newPipe = new Pipe('J', row + 1, col);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case 'S' -> {
                    pipe.setSecondConnected(pipes.getFirst());
                    pipes.getFirst().setSecondConnected(pipe);
                    return newPipe;
                }
            }
        }

        if (row - 1 != prevRow && row > 0 && pipe.getSymbol() != '-' && pipe.getSymbol() != '7' && pipe.getSymbol() != 'F') {
            switch (input.get(row - 1).get(col)) {
                case '|' -> {
                    newPipe = new Pipe('|', row - 1, col);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case '7' -> {
                    newPipe = new Pipe('7', row - 1, col);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case 'F' -> {
                    newPipe = new Pipe('F', row - 1, col);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case 'S' -> {
                    pipe.setSecondConnected(pipes.getFirst());
                    pipes.getFirst().setSecondConnected(pipe);
                    return newPipe;
                }
            }
        }

        if (col + 1 != prevCol && col + 1 < input.get(row).size() && pipe.getSymbol() != '|' && pipe.getSymbol() != 'J' && pipe.getSymbol() != '7') {
            switch (input.get(row).get(col + 1)) {
                case '-' -> {
                    newPipe = new Pipe('-', row, col + 1);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case '7' -> {
                    newPipe = new Pipe('7', row, col + 1);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case 'J' -> {
                    newPipe = new Pipe('J', row, col + 1);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case 'S' -> {
                    pipe.setSecondConnected(pipes.getFirst());
                    pipes.getFirst().setSecondConnected(pipe);
                    return newPipe;
                }
            }
        }

        if (col - 1 != prevCol && col > 0 && pipe.getSymbol() != '|' && pipe.getSymbol() != 'L' && pipe.getSymbol() != 'F') {
            switch (input.get(row).get(col - 1)) {
                case '-' -> {
                    newPipe = new Pipe('-', row, col - 1);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case 'F' -> {
                    newPipe = new Pipe('F', row, col - 1);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case 'L' -> {
                    newPipe = new Pipe('L', row, col - 1);
                    newPipe.setFirstConnected(pipe);
                    pipe.setSecondConnected(newPipe);
                    return newPipe;
                }
                case 'S' -> {
                    pipe.setSecondConnected(pipes.getFirst());
                    pipes.getFirst().setSecondConnected(pipe);
                    return newPipe;
                }
            }
        }

        return newPipe;
    }
}