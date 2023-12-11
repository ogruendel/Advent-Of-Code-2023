package day10;

import java.util.ArrayList;
import java.util.List;

public class Pipe {
    private final Character symbol;
    private final int row;
    private final int col;
    private Pipe firstConnected;
    private Pipe secondConnected;
    private int distanceFromStart;

    public Pipe(Character symbol, int row, int col) {
        this.symbol = symbol;
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Character getSymbol() {
        return symbol;
    }

    public Pipe getFirstConnected() {
        return firstConnected;
    }

    public void setFirstConnected(Pipe firstConnected) {
        this.firstConnected = firstConnected;
    }

    public Pipe getSecondConnected() {
        return secondConnected;
    }

    public void setSecondConnected(Pipe secondConnected) {
        this.secondConnected = secondConnected;
    }

    public int getDistanceFromStart() {
        return distanceFromStart;
    }

    public void setDistanceFromStart(int distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }

    public void addConnected(Pipe pipe) {
        if (this.firstConnected == null) {
            this.firstConnected = pipe;
        } else {
            this.secondConnected = pipe;
        }
    }

    public List<Pipe> getConnectedPipes() {
        List<Pipe> connectedPipes = new ArrayList<>();
        connectedPipes.add(firstConnected);
        connectedPipes.add(secondConnected);
        return connectedPipes;
    }
}
