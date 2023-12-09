package day09;

import java.util.ArrayList;
import java.util.List;

public class Value {
    private List<List<Integer>> measurements;

    public Value() {
        this.measurements = new ArrayList<>();
    }

    public List<List<Integer>> getMeasurements() {
        return measurements;
    }

    public void addMeasurement(List<Integer> measurement) {
        List<List<Integer>> newMeasurements = new ArrayList<>(this.measurements);
        newMeasurements.add(measurement);
        this.measurements = newMeasurements;
    }
}
