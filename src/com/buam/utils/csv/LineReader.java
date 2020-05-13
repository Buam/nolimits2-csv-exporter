package com.buam.utils.csv;

import jdk.nashorn.api.scripting.URLReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LineReader {

    public static List<String> readLines(URL path) {
        try {
            BufferedReader reader = new BufferedReader(new URLReader(path));

            String line;

            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static String read(URL path) {
        final StringBuilder sb = new StringBuilder();

        readLines(path).forEach(sb::append);

        return sb.toString();
    }

}
