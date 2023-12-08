package day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private static int startingRank;

    public static int solvePart1(List<String> input) {
        startingRank = 1;
        List<Hand> fiveOfAKind = new ArrayList<>();
        List<Hand> fourOfAKind = new ArrayList<>();
        List<Hand> fullHouse = new ArrayList<>();
        List<Hand> threeOfAKind = new ArrayList<>();
        List<Hand> twoPair = new ArrayList<>();
        List<Hand> onePair = new ArrayList<>();
        List<Hand> highCard = new ArrayList<>();

        int totalWinnings = 0;

        for (String s : input) {
            Hand hand = new Hand(getCards(s), getBid(s));
            if (isFiveOfAKind(hand)) {
                fiveOfAKind.add(hand);
            } else if (isFourOfAKind(hand)) {
                fourOfAKind.add(hand);
            } else if (isFullHouse(hand)) {
                fullHouse.add(hand);
            } else if (isThreeOfAKind(hand)) {
                threeOfAKind.add(hand);
            } else if (isTwoPair(hand)) {
                twoPair.add(hand);
            } else if (isOnePair(hand)) {
                onePair.add(hand);
            } else if (isHighCard(hand)) {
                highCard.add(hand);
            }
        }

        highCard = rankHandsPart1(highCard);
        onePair = rankHandsPart1(onePair);
        twoPair = rankHandsPart1(twoPair);
        threeOfAKind = rankHandsPart1(threeOfAKind);
        fullHouse = rankHandsPart1(fullHouse);
        fourOfAKind = rankHandsPart1(fourOfAKind);
        fiveOfAKind = rankHandsPart1(fiveOfAKind);

        List<Hand> allHands = new ArrayList<>();
        allHands.addAll(highCard);
        allHands.addAll(onePair);
        allHands.addAll(twoPair);
        allHands.addAll(threeOfAKind);
        allHands.addAll(fullHouse);
        allHands.addAll(fourOfAKind);
        allHands.addAll(fiveOfAKind);

        for (Hand hand : allHands) {
            totalWinnings += hand.getBid() * hand.getRank();
        }

        return totalWinnings;
    }


    public static int solvePart2(List<String> input) {
        startingRank = 1;
        List<Hand> fiveOfAKind = new ArrayList<>();
        List<Hand> fourOfAKind = new ArrayList<>();
        List<Hand> fullHouse = new ArrayList<>();
        List<Hand> threeOfAKind = new ArrayList<>();
        List<Hand> twoPair = new ArrayList<>();
        List<Hand> onePair = new ArrayList<>();
        List<Hand> highCard = new ArrayList<>();

        int totalWinnings = 0;

        for (String s : input) {
            Hand hand = new Hand(getCards(s), getBid(s));
            if (isFiveOfAKind(getBestHandWithJoker(hand))) {
                fiveOfAKind.add(hand);
            } else if (isFourOfAKind(getBestHandWithJoker(hand))) {
                fourOfAKind.add(hand);
            } else if (isFullHouse(getBestHandWithJoker(hand))) {
                fullHouse.add(hand);
            } else if (isThreeOfAKind(getBestHandWithJoker(hand))) {
                threeOfAKind.add(hand);
            } else if (isTwoPair(getBestHandWithJoker(hand))) {
                twoPair.add(hand);
            } else if (isOnePair(getBestHandWithJoker(hand))) {
                onePair.add(hand);
            } else if (isHighCard(getBestHandWithJoker(hand))) {
                highCard.add(hand);
            }
        }

        highCard = rankHandsPart2(highCard);
        onePair = rankHandsPart2(onePair);
        twoPair = rankHandsPart2(twoPair);
        threeOfAKind = rankHandsPart2(threeOfAKind);
        fullHouse = rankHandsPart2(fullHouse);
        fourOfAKind = rankHandsPart2(fourOfAKind);
        fiveOfAKind = rankHandsPart2(fiveOfAKind);

        List<Hand> allHands = new ArrayList<>();
        allHands.addAll(highCard);
        allHands.addAll(onePair);
        allHands.addAll(twoPair);
        allHands.addAll(threeOfAKind);
        allHands.addAll(fullHouse);
        allHands.addAll(fourOfAKind);
        allHands.addAll(fiveOfAKind);

        for (Hand hand : allHands) {
            totalWinnings += hand.getBid() * hand.getRank();
        }

        return totalWinnings;
    }

    private static int getCardValuePart1(Character card) {
        int value = 0;
        switch (card) {
            case '2' -> value = 1;
            case '3' -> value = 2;
            case '4' -> value = 3;
            case '5' -> value = 4;
            case '6' -> value = 5;
            case '7' -> value = 6;
            case '8' -> value = 7;
            case '9' -> value = 8;
            case 'T' -> value = 9;
            case 'J' -> value = 10;
            case 'Q' -> value = 11;
            case 'K' -> value = 12;
            case 'A' -> value = 13;
        }
        return value;
    }

    private static int getCardValuePart2(Character card) {
        int value = 0;
        switch (card) {
            case 'J' -> value = 1;
            case '2' -> value = 2;
            case '3' -> value = 3;
            case '4' -> value = 4;
            case '5' -> value = 5;
            case '6' -> value = 6;
            case '7' -> value = 7;
            case '8' -> value = 8;
            case '9' -> value = 9;
            case 'T' -> value = 10;
            case 'Q' -> value = 11;
            case 'K' -> value = 12;
            case 'A' -> value = 13;
        }
        return value;
    }

    private static Hand getBestHandWithJoker(Hand hand) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < hand.getCards().length(); i++) {
            char key = hand.getCards().charAt(i);
            if (map.containsKey(key)) {
                int occurrences = map.get(key);
                map.remove(key);
                map.put(key, occurrences + 1);
            } else {
                map.put(key, 1);
            }
        }
        char mostCard = 0;
        for (char key : map.keySet()) {
            if (mostCard == 0) {
                mostCard = key;
            } else {
                if (map.get(key) > map.get(mostCard) && key != 'J') {
                    mostCard = key;
                }
            }
        }

        return new Hand(hand.getCards().replace('J', mostCard), hand.getBid());
    }

    private static List<Hand> rankHandsPart1(List<Hand> hands) {
        List<Hand> rankedHands = new ArrayList<>();
        while (!hands.isEmpty()) {
            Hand worstHand = hands.getFirst();
            for (Hand hand : hands) {
                for (int i = 0; i < 5; i++) {
                    if (getCardValuePart1(hand.getCards().charAt(i)) > getCardValuePart1(worstHand.getCards().charAt(i))) {
                        break;
                    } else if (getCardValuePart1(hand.getCards().charAt(i)) < getCardValuePart1(worstHand.getCards().charAt(i))) {
                        worstHand = hand;
                        break;
                    }
                }
            }

            worstHand.setRank(startingRank);
            startingRank++;
            rankedHands.add(worstHand);
            hands.remove(worstHand);
        }
        return rankedHands;
    }

    private static List<Hand> rankHandsPart2(List<Hand> hands) {
        List<Hand> rankedHands = new ArrayList<>();
        while (!hands.isEmpty()) {
            Hand worstHand = hands.getFirst();
            for (Hand hand : hands) {
                for (int i = 0; i < 5; i++) {
                    if (getCardValuePart2(hand.getCards().charAt(i)) > getCardValuePart2(worstHand.getCards().charAt(i))) {
                        break;
                    } else if (getCardValuePart2(hand.getCards().charAt(i)) < getCardValuePart2(worstHand.getCards().charAt(i))) {
                        worstHand = hand;
                        break;
                    }
                }
            }

            worstHand.setRank(startingRank);
            startingRank++;
            rankedHands.add(worstHand);
            hands.remove(worstHand);
        }
        return rankedHands;
    }

    private static boolean isFiveOfAKind(Hand hand) {
        return hand.getCards().matches("([2-9TJQKA])\\1{4}");
    }

    private static boolean isFourOfAKind(Hand hand) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < hand.getCards().length(); i++) {
            if (map.containsKey(hand.getCards().charAt(i))) {
                int val = map.get(hand.getCards().charAt(i));
                map.remove(hand.getCards().charAt(i));
                map.put(hand.getCards().charAt(i), val + 1);
            } else {
                map.put(hand.getCards().charAt(i), 1);
            }
        }

        if (map.size() == 2) {
            for (Character key : map.keySet()) {
                if (map.get(key) != 4) {
                    if (map.get(key) != 1) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isFullHouse(Hand hand) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < hand.getCards().length(); i++) {
            if (map.containsKey(hand.getCards().charAt(i))) {
                int val = map.get(hand.getCards().charAt(i));
                map.remove(hand.getCards().charAt(i));
                map.put(hand.getCards().charAt(i), val + 1);
            } else {
                map.put(hand.getCards().charAt(i), 1);
            }
        }

        if (map.size() == 2) {
            for (Character key : map.keySet()) {
                if (map.get(key) > 3 || map.get(key) == 1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isThreeOfAKind(Hand hand) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < hand.getCards().length(); i++) {
            if (map.containsKey(hand.getCards().charAt(i))) {
                int val = map.get(hand.getCards().charAt(i));
                map.remove(hand.getCards().charAt(i));
                map.put(hand.getCards().charAt(i), val + 1);
            } else {
                map.put(hand.getCards().charAt(i), 1);
            }
        }

        if (map.size() == 3) {
            for (Character key : map.keySet()) {
                if (map.get(key) == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isTwoPair(Hand hand) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < hand.getCards().length(); i++) {
            if (map.containsKey(hand.getCards().charAt(i))) {
                int val = map.get(hand.getCards().charAt(i));
                map.remove(hand.getCards().charAt(i));
                map.put(hand.getCards().charAt(i), val + 1);
            } else {
                map.put(hand.getCards().charAt(i), 1);
            }
        }
        if (map.size() == 3) {
            for (Character key : map.keySet()) {
                if (map.get(key) > 2) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isOnePair(Hand hand) {
        List<Character> uniqueChars = new ArrayList<>();
        for (int i = 0; i < hand.getCards().length(); i++) {
            if (!uniqueChars.contains(hand.getCards().charAt(i))) {
                uniqueChars.add(hand.getCards().charAt(i));
            }
        }
        return uniqueChars.size() == 4;
    }

    private static boolean isHighCard(Hand hand) {
        List<Character> uniqueChars = new ArrayList<>();
        for (int i = 0; i < hand.getCards().length(); i++) {
            if (!uniqueChars.contains(hand.getCards().charAt(i))) {
                uniqueChars.add(hand.getCards().charAt(i));
            }
        }
        return uniqueChars.size() == 5;
    }

    private static String getCards(String input) {
        return input.substring(0, 5);
    }

    private static int getBid(String input) {
        return Integer.parseInt(input.substring(6));
    }
}
