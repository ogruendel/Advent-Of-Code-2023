package day11;

import java.util.ArrayList;
import java.util.List;

public class Universe {
    private static final List<Galaxy> galaxies = new ArrayList<>();
    private static final List<Integer> expandedRows = new ArrayList<>();
    private static final List<Integer> expandedCols = new ArrayList<>();

    public static int solvePart1(List<List<Character>> input) {
        galaxies.clear();
        expandedRows.clear();
        expandedCols.clear();

        int sumOfDistances = 0;
        int expansionFactor = 2 - 1;
        expandUniverse(input);
        populateGalaxies(input);

        while (galaxies.size() != 1) {
            for (int i = 0; i < galaxies.size(); i++) {
                int rowMultiplierFirst = 0;
                int colMultiplierFirst = 0;
                int rowMultiplierSecond = 0;
                int colMultiplierSecond = 0;

                for (Integer row : expandedRows) {
                    if (galaxies.getFirst().x() < row) {
                        break;
                    } else {
                        rowMultiplierFirst++;
                    }
                }
                for (Integer row : expandedRows) {
                    if (galaxies.get(i).x() < row) {
                        break;
                    } else {
                        rowMultiplierSecond++;
                    }
                }
                for (Integer col : expandedCols) {
                    if (galaxies.getFirst().y() < col) {
                        break;
                    } else {
                        colMultiplierFirst++;
                    }
                }
                for (Integer col : expandedCols) {
                    if (galaxies.get(i).y() < col) {
                        break;
                    } else {
                        colMultiplierSecond++;
                    }
                }

                sumOfDistances += Math.abs((rowMultiplierFirst * expansionFactor + galaxies.getFirst().x()) - (rowMultiplierSecond * expansionFactor + galaxies.get(i).x())) + Math.abs((colMultiplierFirst * expansionFactor + galaxies.getFirst().y()) - (colMultiplierSecond * expansionFactor + galaxies.get(i).y()));
            }
            galaxies.removeFirst();
        }

        return sumOfDistances;
    }

    public static long solvePart2(List<List<Character>> input) {
        galaxies.clear();
        expandedRows.clear();
        expandedCols.clear();

        long sumOfDistances = 0;
        int expansionFactor = 1000000 - 1;
        expandUniverse(input);
        populateGalaxies(input);

        while (galaxies.size() != 1) {
            for (int i = 0; i < galaxies.size(); i++) {
                int rowMultiplierFirst = 0;
                int colMultiplierFirst = 0;
                int rowMultiplierSecond = 0;
                int colMultiplierSecond = 0;

                for (Integer row : expandedRows) {
                    if (galaxies.getFirst().x() > row) {
                        rowMultiplierFirst++;
                    }
                    if (galaxies.get(i).x() > row) {
                        rowMultiplierSecond++;
                    }
                }
                for (Integer col : expandedCols) {
                    if (galaxies.getFirst().y() < col) {
                        break;
                    } else {
                        colMultiplierFirst++;
                    }
                }
                for (Integer col : expandedCols) {
                    if (galaxies.get(i).y() < col) {
                        break;
                    } else {
                        colMultiplierSecond++;
                    }
                }

                sumOfDistances += Math.abs((rowMultiplierFirst * expansionFactor + galaxies.getFirst().x()) - (rowMultiplierSecond * expansionFactor + galaxies.get(i).x())) + Math.abs((colMultiplierFirst * expansionFactor + galaxies.getFirst().y()) - (colMultiplierSecond * expansionFactor + galaxies.get(i).y()));
            }
            galaxies.removeFirst();
        }

        return sumOfDistances;
    }

    private static void expandUniverse(List<List<Character>> input) {
        for (int row = 0; row < input.size(); row++) {
            boolean emptyRow = true;
            for (Character c : input.get(row)) {
                if (c != '.') {
                    emptyRow = false;
                    break;
                }
            }
            if (emptyRow) {
                expandedRows.add(row);
            }
        }

        for (int col = 0; col < input.getFirst().size(); col++) {
            boolean emptyCol = true;
            for (List<Character> row : input) {
                if (row.get(col) != '.') {
                    emptyCol = false;
                    break;
                }
            }

            if (emptyCol) {
                expandedCols.add(col);
            }
        }
    }

    private static void populateGalaxies(List<List<Character>> universe) {
        for (int row = 0; row < universe.size(); row++) {
            for (int col = 0; col < universe.get(row).size(); col++) {
                if (universe.get(row).get(col) == '#') {
                    galaxies.add(new Galaxy(row, col));
                }
            }
        }
    }

    private static void printUniverse(List<List<Character>> input) {
        for (List<Character> line : input) {
            System.out.println(line);
        }
    }
}
