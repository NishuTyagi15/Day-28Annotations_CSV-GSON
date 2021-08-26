package com.JavaAnnotations;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenCsvWriterExample {
    public static void main(String[] args) throws IOException {
        List<String[]> csvData = createCsvDataSpecial();

        // default all fields are enclosed in double quotes
        // default separator is a comma
        try (CSVWriter writer = new CSVWriter(new FileWriter("src\\test\\java\\com\\JavaAnnotations\\csvfile.csv"))) {
            writer.writeAll(csvData);
        }
    }

    private static List<String[]> createCsvDataSpecial() {
        String[] header = {"Name", "Email", "Phone", "Country"};
        String[] record1 = {"Shivam Tyagi", "shivam@gmail.com", "+91-9887468734", "India"};
        // embedded double quotes
        String[] record2 = {"Avneet Singh", "avneet@gmail.com", "+91-9775559881", "India"};
        // embedded double quotes and commas
        String[] record3 = {"Suzi", "S@gmail.com", "+1-3323656712", "Japan"};
        // embedded line break
        String[] record4 = {"Tom", "T@gmail.com", "+1-1335577654", "France"};

        List<String[]> list = new ArrayList<>();
        list.add(header);
        list.add(record1);
        list.add(record2);
        list.add(record3);
        list.add(record4);
        return list;
    }
}