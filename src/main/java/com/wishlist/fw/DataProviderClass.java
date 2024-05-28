package com.wishlist.fw;

//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;


import com.wishlist.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderClass {
    @DataProvider(name="LoginInValidData")
    public Iterator<Object[]> LoginInValidData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/csv/LoginInValidData.csv")));

        String line = reader.readLine();
        while (line != null) {
            String[] data = line.split(",");
            list.add(new Object[]{new User(data[0], data[1])});
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
    @DataProvider(name="inValidEmailSignUpData")
    public Iterator<Object[]> inValidEmailSignUpData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/csv/SignUpInvalidEmailData.csv")));

        String line = reader.readLine();
        while (line != null) {
            String[] data = line.split(",");
            list.add(new Object[]{new User(data[0], data[1],data[2], data[3], data[4])});
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
}

//    private Object[][] readDataFromCSV(String fileName) {
//        String filePath = "./src/test/resources/csv/" + fileName;
//        List<Object[]> data = new ArrayList<>();
//        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
//            String[] line;
//            while ((line = reader.readNext()) != null) {
//                data.add(line);
//            }
//        } catch (IOException | CsvValidationException e) {
//            throw new RuntimeException(e);
//        }
//        return data.toArray(new Object[data.size()][]);
//    }
//
//    @DataProvider(name = "validLoginData")
//    public Object[][] getValidLoginData() {
//        return readDataFromCSV("LoginValidData.csv");
//    }
//
//    @DataProvider(name = "iNvalidLoginData")
//    public Object[][] getInValidLoginData() {
//        return readDataFromCSV("LoginValidData.csv");
//    }


