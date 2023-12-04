package day04;

import java.util.List;

public class Card {
    private final List<Integer> winningNumbers;
    private final List<Integer> drawnNumbers;
    private final int value;
    private final int id;
    private int matchingNumbers = 0;

    public Card(List<Integer> winningNumbers, List<Integer> drawnNumbers, int value, int id) {
        this.winningNumbers = winningNumbers;
        this.drawnNumbers = drawnNumbers;
        this.value = value;
        this.id = id;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> getDrawnNumbers() {
        return drawnNumbers;
    }

    public int getValue() {
        return value;
    }
    public int getId() {
        return id;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public void setMatchingNumbers(int matchingNumbers) {
        this.matchingNumbers = matchingNumbers;
    }
}
