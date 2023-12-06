package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File {
    public static List<String> listFromFile(String path) {
        String line;
        List<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static List<List<Character>> listOfListFromFile(String path) {
        String line;
        List<Character> row = new ArrayList<>();
        List<List<Character>> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i <= line.length() - 1; i++) {
                    row.add(line.charAt(i));
                }
                list.add(row);
                row = new ArrayList<>();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static String stringFromFile(String path) {
        String line;
        StringBuilder output = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    output.append("\n");
                } else {
                    output.append(line).append(" ");
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return output.toString();
    }
}
