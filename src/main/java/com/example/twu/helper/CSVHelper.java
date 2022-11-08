package com.example.twu.helper;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    /**
     * function to fetch names of csv files present in current working directory
     * @return list of names of csv files present in current working directory
     * @throws FileNotFoundException: if no csv files present in current working directory
     */
    private static List<String> getCSVFileNamesFromDisk() throws FileNotFoundException {
        // list all available files in current working directory
        File[] filesPresentInCWD = new File(
                Paths.get(System.getProperty("user.dir")).toString()).listFiles();
        if (filesPresentInCWD == null) {
            throw new FileNotFoundException("NO FILE FOUND IN THE CURRENT WORKING DIRECTORY");
        }
        else {
            List<String> csvFileList = new ArrayList<>();
            for (File file : filesPresentInCWD) {

                // check if current item is a file and has .csv extension
                if (file.isFile() && file.getName().endsWith(".csv")) {
                    csvFileList.add(Paths.get(System.getProperty("user.dir")).getParent().toString()+"\\"+file.getName());
                }
            }

            // check if any csv file was found
            if (csvFileList.size() == 0) {
                throw new FileNotFoundException("NO CSV FILE FOUND IN THE CURRENT WORKING DIRECTORY");
            }
            else {
                return csvFileList;
            }
        }
    }

    /**
     * function to extract stock symbols present in csv file
     * @return list of stock symbols present in csv file
     * @throws IOException: if there is any error reading the csv file
     */
    public static List<String> getStockSymbolsFromCSVFile() throws IOException {
        // get list of all csv files available in current working directory
        List<String> csvFileNames = getCSVFileNamesFromDisk();

        // check if more than 1 csv file is present in current working directory
        if (csvFileNames.size() > 1) {
            throw new FileNotFoundException("MORE THAN ONE CSV FILE PRESENT IN THE CURRENT WORKING DIRECTORY");
        }
        else {
            List<String> stockSymbols = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(csvFileNames.get(0)));
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
}
