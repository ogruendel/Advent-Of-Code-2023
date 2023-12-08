package day08;

import java.util.ArrayList;
import java.util.List;

public class Map {
    public static int solvePart1(List<String> input) {
        List<Character> path = getMoves(input.getFirst());
        List<Node> nodes = generateNodes(input);
        int steps = 0;
        int currentPosition = 0;
        Node currentNode = new Node("");

        for (Node node : nodes) {
            if (node.getName().equals("AAA")) {
                currentNode = node;
            }
        }

        while (!currentNode.getName().equals("ZZZ")) {
            switch (path.get(currentPosition)) {
                case 'L' -> currentNode = currentNode.getLeft();
                case 'R' -> currentNode = currentNode.getRight();
            }

            steps++;
            currentPosition = currentPosition >= path.size() - 1 ? 0 : currentPosition + 1;
        }

        return steps;
    }

    public static long solvePart2(List<String> input) {
        List<Character> path = getMoves(input.getFirst());
        List<Node> nodes = generateNodes(input);
        int currentPosition = 0;

        List<Node> currentNodes = new ArrayList<>();
        Node currentNode;
        List<Long> stepsToDestination = new ArrayList<>();

        for (Node node : nodes) {
            if (node.getName().charAt(2) == 'A') {
                currentNodes.add(node);
            }
        }

        for (Node node : currentNodes) {
            long stepsPerNode = 0;
            currentNode = node;
            while (currentNode.getName().charAt(2) != 'Z') {
                switch (path.get(currentPosition)) {
                    case 'L' -> currentNode = currentNode.getLeft();
                    case 'R' -> currentNode = currentNode.getRight();
                }
                stepsPerNode++;
                currentPosition = currentPosition >= path.size() - 1 ? 0 : currentPosition + 1;
            }
            stepsToDestination.add(stepsPerNode);
        }
        return findLCM(stepsToDestination);
    }

    private static long findLCM(List<Long> input) {
        while (input.size() != 1) {
            long first = input.get(0) > input.get(1) ? input.get(1) : input.get(0);
            long second = input.get(0) > input.get(1) ? input.get(0) : input.get(1);
            long initialFirst = first;
            long initialSecond = second;

            while (first != second) {
                first += initialFirst;
                if (first > second) {
                    second += initialSecond;
                }
            }
            input.removeFirst();
            input.set(0, second);
        }

        return input.getFirst();
    }

    private static List<Character> getMoves(String line) {
        List<Character> output = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            output.add(line.charAt(i));
        }
        return output;
    }

    private static List<Node> generateNodes(List<String> input) {
        List<Node> nodes = new ArrayList<>();

        for (int i = 2; i < input.size(); i++) {
            nodes.add(new Node(getNodeName(input.get(i))));
        }

        for (int i = 2; i < input.size(); i++) {
            for (Node node : nodes) {
                if (getLeftName(input.get(i)).equals(node.getName())) {
                    nodes.get(i - 2).setLeft(node);
                    break;
                }
            }
        }

        for (int i = 2; i < input.size(); i++) {
            for (Node node : nodes) {
                if (getRightName(input.get(i)).equals(node.getName())) {
                    nodes.get(i - 2).setRight(node);
                    break;
                }
            }
        }
        return nodes;
    }

    private static String getNodeName(String input) {
        return input.substring(0, 3);
    }

    private static String getLeftName(String input) {
        return input.substring(7, 10);
    }

    private static String getRightName(String input) {
        return input.substring(12, 15);
    }
}
