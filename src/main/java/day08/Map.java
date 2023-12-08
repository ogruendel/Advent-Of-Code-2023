package day08;

import java.util.ArrayList;
import java.util.List;

public class Map {
    public static int solvePart1(List<String> input) {
        List<Character> path = getMoves(input.getFirst());
        List<Node> nodes = generateNodes(input);
        int steps = 0;
        int currentPosition = 0;
        Node currentNode = new Node("", "", "");
        for (Node node : nodes) {
            if (node.getName().equals("AAA")) {
                currentNode = node;
            }
        }

        while (!currentNode.getName().equals("ZZZ")){
            switch (path.get(currentPosition)) {
                case 'L' -> {
                    for (Node node : nodes) {
                        if (node.getName().equals(currentNode.getLeft())) {
                            currentNode = node;
                            break;
                        }
                    }
                }

                case 'R' -> {
                    for (Node node : nodes) {
                        if (node.getName().equals(currentNode.getRight())) {
                            currentNode = node;
                            break;
                        }
                    }
                }
            }
            steps++;
            currentPosition = currentPosition >= path.size() - 1 ? 0 : currentPosition + 1;
        }

        return steps;
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
            Node newNode = new Node(getNodeName(input.get(i)), getLeftName(input.get(i)), getRightName(input.get(i)));
            nodes.add(newNode);
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
