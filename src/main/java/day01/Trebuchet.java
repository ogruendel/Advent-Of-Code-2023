package day01;

import java.util.List;

public class Trebuchet {

    public static int solvePart1(List<String> input) {
        return getSumOfCalibrationValues(input);
    }

    public static int solvePart2(List<String> input) {
        return getSumOfCalibrationValuesWithLetters(input);
    }

    private static int getCalibrationValue(String input) {
        int firstDigit = -1;
        int lastDigit = -1;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                int digitAtI = Integer.parseInt(String.valueOf(input.charAt(i)));
                if (firstDigit == -1) {
                    firstDigit = digitAtI;
                    lastDigit = firstDigit;
                } else if (Character.isDigit(input.charAt(i))) {
                    lastDigit = digitAtI;
                }
            }
        }
        return 10 * firstDigit + lastDigit;
    }

    private static int getCalibrationValueWithLetters(String input) {
        int firstDigit = -1;
        int lastDigit = -1;
        int indexOfLastDigit = 0;
        for (int i = 0; i < input.length(); i++) {
            if (firstDigit == -1) {
                if (input.indexOf("one") <= i && input.contains("one")) {
                    firstDigit = 1;
                } else if (input.indexOf("two") <= i && input.contains("two")) {
                    firstDigit = 2;
                } else if (input.indexOf("three") <= i && input.contains("three")) {
                    firstDigit = 3;
                } else if (input.indexOf("four") <= i && input.contains("four")) {
                    firstDigit = 4;
                } else if (input.indexOf("five") <= i && input.contains("five")) {
                    firstDigit = 5;
                } else if (input.indexOf("six") <= i && input.contains("six")) {
                    firstDigit = 6;
                } else if (input.indexOf("seven") <= i && input.contains("seven")) {
                    firstDigit = 7;
                } else if (input.indexOf("eight") <= i && input.contains("eight")) {
                    firstDigit = 8;
                } else if (input.indexOf("nine") <= i && input.contains("nine")) {
                    firstDigit = 9;
                }
                lastDigit = firstDigit;
            }
            if (Character.isDigit(input.charAt(i))) {
                int digitAtI = Integer.parseInt(String.valueOf(input.charAt(i)));
                if (firstDigit == -1) {
                    firstDigit = digitAtI;
                }
                lastDigit = digitAtI;
                indexOfLastDigit = i;
            }
        }

        if (input.lastIndexOf("one") > indexOfLastDigit) {
            lastDigit = 1;
            indexOfLastDigit = input.lastIndexOf("one");
        }
        if (input.lastIndexOf("two") > indexOfLastDigit) {
            lastDigit = 2;
            indexOfLastDigit = input.lastIndexOf("two");
        }
        if (input.lastIndexOf("three") > indexOfLastDigit) {
            lastDigit = 3;
            indexOfLastDigit = input.lastIndexOf("three");
        }
        if (input.lastIndexOf("four") > indexOfLastDigit) {
            lastDigit = 4;
            indexOfLastDigit = input.lastIndexOf("four");
        }
        if (input.lastIndexOf("five") > indexOfLastDigit) {
            lastDigit = 5;
            indexOfLastDigit = input.lastIndexOf("five");
        }
        if (input.lastIndexOf("six") > indexOfLastDigit) {
            lastDigit = 6;
            indexOfLastDigit = input.lastIndexOf("six");
        }
        if (input.lastIndexOf("seven") > indexOfLastDigit) {
            lastDigit = 7;
            indexOfLastDigit = input.lastIndexOf("seven");
        }
        if (input.lastIndexOf("eight") > indexOfLastDigit) {
            lastDigit = 8;
            indexOfLastDigit = input.lastIndexOf("eight");
        }
        if (input.lastIndexOf("nine") > indexOfLastDigit) {
            lastDigit = 9;
        }
        return 10 * firstDigit + lastDigit;
    }

    private static int getSumOfCalibrationValues(List<String> input) {
        int output = 0;
        for (String line : input) {
            output += getCalibrationValue(line);
        }
        return output;
    }

    private static int getSumOfCalibrationValuesWithLetters(List<String> input) {
        int output = 0;
        for (String line : input) {
            output += getCalibrationValueWithLetters(line);
        }
        return output;
    }
}
