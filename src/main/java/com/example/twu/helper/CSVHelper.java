package com.example.twu.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    /**
     * function to get the path value to the required csv file
     * @return path value to the required csv file
     */
    private static String getVerifiedCSVFilePath(Path csvFilePath) {
        if (csvFilePath == null) {
            csvFilePath = UserInputHelper.getCSVFilePathInput();
        }
        //
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath.toString()));
            if (reader.readLine().trim().substring(2).equals("SYMBOL")) {
                return csvFilePath.toString();
            }
            else {
                return getVerifiedCSVFilePath(UserInputHelper.getCSVFilePathInput());
            }
        }
        catch (IOException e) {
            return getVerifiedCSVFilePath(UserInputHelper.getCSVFilePathInput());
        }
    }

    /**
     * function to extract stock symbols present in csv file
     * @return list of stock symbols present in csv file
     * @throws IOException: if there is any error reading the csv file
     */
    public static List<String> getStockSymbolsFromCSVFile() throws IOException {
        List<String> stockSymbols = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(
                getVerifiedCSVFilePath(UserInputHelper.getCSVFilePathInput())));
        String line = reader.readLine();
        while (line != null) {
            String[] columnValues = line.split(",");
            if (columnValues.length > 5) {
                if (!columnValues[0].contains(" ")) {
                    stockSymbols.add(columnValues[0]
                            .substring(1, columnValues[0].length() - 1)
                            .replace('&', '_')
                            .replace('-', '_'));
                }
            }
            line = reader.readLine();
        }
        return stockSymbols;
    }
}
