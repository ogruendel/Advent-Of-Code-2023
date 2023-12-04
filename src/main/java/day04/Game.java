package day04;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static int solvePart1(List<String> input) {
        List<Card> cards = new ArrayList<>();
        int output = 0;
        for (String game : input) {
            cards.add(new Card(splitNumbers(game).get(0), splitNumbers(game).get(1), getCardValue(splitNumbers(game)), getGameID(game)));
        }

        for (Card card : cards) {
            output += card.getValue();
        }

        return output;
    }

    public static int solvePart2(List<String> input) {
        List<Card> cards = new ArrayList<>();
        List<Card> finalCards = new ArrayList<>();

        for (String game : input) {
            Card card = new Card(splitNumbers(game).get(0), splitNumbers(game).get(1), getCardValue(splitNumbers(game)), getGameID(game));
            card.setMatchingNumbers(getMatchingNumbers(card));
            cards.add(card);
        }

        for (int i = 0; i < cards.size(); i++) {
            finalCards.add(cards.get(i));
            List<Card> cardsToAdd = new ArrayList<>();

            for (int j = 0; j < cards.get(i).getMatchingNumbers(); j++) {
                cardsToAdd.add(cards.get(i + j + 1));
            }

            for (int j = 0; j < amountInList(cards.get(i), finalCards); j++) {
                finalCards.addAll(cardsToAdd);
            }
        }

        return finalCards.size();
    }

    private static int amountInList(Card card, List<Card> cards) {
        int output = 0;
        for (Card cardInList : cards) {
            if (card == cardInList) {
                output++;
            }
        }
        return output;
    }

    private static int getGameID(String input) {
        String firstPart = input.substring(0, input.indexOf(':'));
        return Integer.parseInt(firstPart.substring(firstPart.lastIndexOf(' ') + 1));
    }

    private static int getCardValue(List<List<Integer>> numbers) {
        int value = 0;
        for (int number : numbers.get(1)) {
            if (numbers.get(0).contains(number)) {
                if (value == 0) {
                    value = 1;
                } else {
                    value *= 2;
                }
            }
        }
        return value;
    }

    private static int getMatchingNumbers(Card card) {
        int matchingNumbers = 0;
        for (int drawnNumber : card.getDrawnNumbers()) {
            if (card.getWinningNumbers().contains(drawnNumber)) {
                matchingNumbers++;
            }
        }
        return matchingNumbers;
    }

    private static List<List<Integer>> splitNumbers(String input) {
        List<String> list = List.of(input.substring(input.indexOf(':') + 2).split("\\s\\|\\s"));
        List<List<Integer>> output = new ArrayList<>();

        for (String side : list) {
            List<String> numbers = List.of(side.split("\\s"));
            List<Integer> finalSide = new ArrayList<>();
            for (String number : numbers) {
                if (!number.isEmpty()) {
                    finalSide.add(Integer.parseInt(number));
                }
            }
            output.add(finalSide);
        }
        return output;
    }

}
