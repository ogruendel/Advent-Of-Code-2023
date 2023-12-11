package day11;

import java.util.ArrayList;
import java.util.List;

public class Universe {
    private static final List<Galaxy> galaxies = new ArrayList<>();

    public static int solvePart1(List<List<Character>> input) {
        int sumOfDistances = 0;
        populateGalaxies(expandUniverse(input));

        while (!galaxies.isEmpty()) {
            for (int i = 0; i < galaxies.size(); i++) {
                sumOfDistances += Math.abs(galaxies.getFirst().x() - galaxies.get(i).x()) + Math.abs(galaxies.getFirst().y() - galaxies.get(i).y());
            }
            galaxies.removeFirst();
        }

        return sumOfDistances;
    }

    private static List<List<Character>> expandUniverse(List<List<Character>> input) {
        List<List<Character>> expandedUniverse = new ArrayList<>();

        for (List<Character> row : input) {
            boolean emptyRow = true;
            for (Character c : row) {
                if (c != '.') {
                    emptyRow = false;
                    break;
                }
            }
            expandedUniverse.add(new ArrayList<>(row));
            if (emptyRow) {
                expandedUniverse.add(new ArrayList<>(row));
            }
        }

        for (int col = 0; col < expandedUniverse.getFirst().size(); col++) {
            boolean emptyCol = true;
            for (List<Character> row : expandedUniverse) {
                if (row.get(col) != '.') {
                    emptyCol = false;
                    break;
                }
            }

            if (emptyCol) {
                for (List<Character> newRow : expandedUniverse) {
                    newRow.add(col, '.');
                }
                col++;
            }
        }

        return expandedUniverse;
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
