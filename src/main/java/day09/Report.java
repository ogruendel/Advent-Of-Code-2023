package day09;

import java.util.ArrayList;
import java.util.List;

public class Report {
    public static int solvePart1(List<String> input) {
        int historySum = 0;
        List<Value> values = new ArrayList<>();

        for (String line : input) {
            values.add(splitValues(line));
        }

        for (Value value : values) {
            while (!isZeroSequence(value.getMeasurements().getLast())) {
                value.addMeasurement(getDifference(value.getMeasurements().getLast()));
            }
            historySum += getPrediction(value);
        }

        return historySum;
    }

    private static Value splitValues(String input) {
        String[] strings = input.split(" ");
        List<Integer> line = new ArrayList<>();

        for (String valueString : strings) {
            line.add(Integer.parseInt(valueString));
        }

        Value value = new Value();
        value.addMeasurement(line);
        return value;
    }

    private static List<Integer> getDifference(List<Integer> input) {
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < input.size() - 1; i++) {
            output.add(input.get(i + 1) - input.get(i));
        }

        return output;
    }

    private static boolean isZeroSequence(List<Integer> input) {
        for (Integer i : input) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private static int getPrediction(Value value) {
        int prediction = value.getMeasurements().getLast().getLast();
        for (int i = value.getMeasurements().size() - 1; i > 0; i--) {
            prediction = value.getMeasurements().get(i - 1).getLast() + prediction;
        }

        return prediction;
    }

}
