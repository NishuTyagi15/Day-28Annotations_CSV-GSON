package com.JavaAnnotations;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReader {
    private static final String SampleCSVFile = "src\\test\\java\\com\\JavaAnnotations\\csvfile.csv";

    public static void main(String[] args) throws IOException, CsvValidationException {
        CSVReader csvReader = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SampleCSVFile));
            csvReader = new CSVReader(reader);
        } finally {
            //Reading all records at once into a List<String[]>
            List<String[]> records = null;
            try {
                records = csvReader.readAll();
            } catch (CsvException e) {
                e.printStackTrace();
            }
            for (String[] record : records) {
                System.out.println("Name:" + record[0]);
                System.out.println("Email:" + record[1]);
                System.out.println("Phone:" + record[2]);
                System.out.println("Country:" + record[3]);
                System.out.println("==============================");
            }
        }
    }
}