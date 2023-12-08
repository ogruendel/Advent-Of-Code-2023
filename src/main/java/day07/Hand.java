package day07;

public class Hand {
    private final String cards;
    private final int bid;
    private int rank;

    public Hand(String cards, int bid) {
        this.cards = cards;
        this.bid = bid;
    }

    public String getCards() {
        return cards;
    }

    public int getBid() {
        return bid;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
