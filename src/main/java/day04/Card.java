package day04;

import java.util.List;

public class Card {
    private final int id;
    private int matchingNumbers = 0;
    private int owned = 1;
    private final int value;
    private final List<Integer> winningNumbers;
    private final List<Integer> drawnNumbers;

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

    public int getOwned() {
        return owned;
    }

    public void setMatchingNumbers(int matchingNumbers) {
        this.matchingNumbers = matchingNumbers;
    }

    public void setOwned(int owned) {
        this.owned = owned;
    }
}
