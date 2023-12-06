package day06;

import java.util.ArrayList;
import java.util.List;

public class Race {

    public static int solvePart1(List<String> input) {
        return solve(getRaceValues(input.get(0)), getRaceValues(input.get(1)));
    }
    public static int solvePart2(List<String> input) {
        return solve(List.of(concatenateRaceValues(getRaceValues(input.get(0)))), List.of(concatenateRaceValues(getRaceValues(input.get(1)))));
    }
    private static int solve(List<Long> raceTimes, List<Long> raceDistances) {
        int raceValue = 1;

        for (int i = 0; i < raceTimes.size(); i++) {
            int margin = 0;
            int speed = 1;
            for (int elapsedTime = 1; elapsedTime < raceTimes.get(i); elapsedTime++) {
                if (speed * (raceTimes.get(i) - elapsedTime) > raceDistances.get(i)) {
                    margin++;
                }
                speed++;
            }
            raceValue *= margin;
        }
        return raceValue;
    }

    private static List<Long> getRaceValues(String input) {
        List<Long> output = new ArrayList<>();
        for (String element : input.split("\\s")) {
            if (element.matches("\\d+")) {
                output.add(Long.parseLong(element));
            }
        }
        return output;
    }

    private static long concatenateRaceValues(List<Long> input) {
        StringBuilder output = new StringBuilder();
        for (long value : input) {
            output.append(value);
        }
        return Long.parseLong(output.toString());
    }
}