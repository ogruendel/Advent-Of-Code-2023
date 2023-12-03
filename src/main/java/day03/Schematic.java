package day03;

import util.IntPair;

import java.util.ArrayList;
import java.util.List;

public class Schematic {
    public static int solvePart1(List<List<Character>> schematic) {
        return getSumOfPartNumbers(getSymbolIndexes(schematic), schematic);
    }

    public static int solvePart2(List<List<Character>> schematic) {
        return getSumOfGearRatios(getGearPositions(schematic), schematic);
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

    private static List<IntPair> getGearPositions(List<List<Character>> schematic) {
        List<IntPair> gearPositions = new ArrayList<>();

        for (int row = 0; row < schematic.size(); row++) {
            for (int col = 0; col < schematic.get(row).size(); col++) {
                char charAtPos = schematic.get(row).get(col);
                if (charAtPos == '*') {
                    List<List<Character>> block = new ArrayList<>();
                    for (int rowTemp = -1; rowTemp < 2; rowTemp++) {
                        List<Character> line = new ArrayList<>();
                        for (int colTemp = -1; colTemp < 2; colTemp++) {
                            line.add(schematic.get(row + rowTemp).get(col + colTemp));
                        }
                        block.add(line);
                    }

                    int amountOfDigits = 0;
                    for (int i = 0; i < block.size(); i++) {
                        for (int j = 0; j < block.size(); j++) {
                            if (Character.isDigit(block.get(i).get(j))) {
                                if (j == 2) {
                                    amountOfDigits++;
                                } else if (!Character.isDigit(block.get(i).get(j + 1))) {
                                    amountOfDigits++;
                                }
                            }
                        }
                    }
                    if (amountOfDigits == 2) {
                        gearPositions.add(new IntPair(row, col));
                    }
                }
            }
        }
        return gearPositions;
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

    private static int getSumOfGearRatios(List<IntPair> positions, List<List<Character>> schematic) {
        int sum = 0;
        int gearRatio;

        for (IntPair position : positions) {
            gearRatio = 1;
            for (int row = -1; row < 2; row++) {
                for (int col = -1; col < 2; col++) {
                    if (Character.isDigit(schematic.get(row + position.getRow()).get(col + position.getCol()))) {
                        int colTemp = position.getCol() + col;
                        String num = "";
                        while (colTemp > 0 && Character.isDigit(schematic.get(row + position.getRow()).get(colTemp - 1))) {
                            colTemp--;
                        }
                        while (colTemp < schematic.get(row + position.getRow()).size() && Character.isDigit(schematic.get(row + position.getRow()).get(colTemp))) {
                            num += schematic.get(row + position.getRow()).get(colTemp);
                            schematic.get(row + position.getRow()).set(colTemp, '.');
                            colTemp++;
                        }
                        gearRatio *= Integer.parseInt(num);
                    }
                }
            }
            sum += gearRatio;
        }

        return sum;
    }
}
