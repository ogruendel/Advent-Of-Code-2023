package day06;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public static int solvePart1(List<String> input) {
        List<Integer> raceTimes = getRaceValues(input.get(0));
        List<Integer> raceDistances = getRaceValues(input.get(1));
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

    private static List<Integer> getRaceValues(String input) {
        List<Integer> output = new ArrayList<>();
        for (String element : input.split("\\s")) {
            if (element.matches("\\d+")) {
                output.add(Integer.parseInt(element));
            }
        }
        return output;
    }
}