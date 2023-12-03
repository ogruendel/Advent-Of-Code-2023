package day03;

import util.IntPair;

import java.util.ArrayList;
import java.util.List;

public class Schematic {
    public static int solvePart1(List<List<Character>> schematic) {
        return getSumOfPartNumbers(getSymbolIndexes(schematic), schematic);
    }
    private static List<IntPair> getSymbolIndexes(List<List<Character>> schematic) {
        List<IntPair> symbolIndexes = new ArrayList<>();
        for (int row = 0; row < schematic.size() - 1; row++) {
            for (int col = 0; col < schematic.get(row).size(); col++) {
                if (!schematic.get(row).get(col).equals('.') && !Character.isDigit(schematic.get(row).get(col))) {
                    symbolIndexes.add(new IntPair(row, col));
                }
            }
        }
        return symbolIndexes;
    }

    private static int getPartNumbers(IntPair pos, List<List<Character>> schematic) {
        int sumOfPartNums = 0;
        for (int row = pos.getRow() - 1; row < pos.getRow() + 2; row++) {
            for (int col = pos.getCol() - 1; col < pos.getCol() + 2; col++) {
                if (Character.isDigit(schematic.get(row).get(col))) {
                    int colTemp = col;
                    while (colTemp > 0 && Character.isDigit(schematic.get(row).get(colTemp - 1))) {
                        colTemp--;
                    }
                    String partNum = "";
                    for (int i = colTemp; i < schematic.get(row).size() && Character.isDigit(schematic.get(row).get(i)); i++) {
                        partNum += schematic.get(row).get(i).toString();
                        schematic.get(row).set(i, '.');
                    }
                    sumOfPartNums += Integer.parseInt(partNum);
                }
            }
        }
        return sumOfPartNums;
    }

    private static int getSumOfPartNumbers(List<IntPair> indexes, List<List<Character>> schematic) {
        int sumOfPartNums = 0;
        for (IntPair pos : indexes) {
            sumOfPartNums += getPartNumbers(pos, schematic);
        }
        return sumOfPartNums;
    }
}
