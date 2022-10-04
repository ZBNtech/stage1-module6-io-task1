package com.epam.mjc.io;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;



public class FileReader {

    public Profile getDataFromFile(File file) {
        ArrayList<String> result = new ArrayList<>();

        try (java.io.FileReader f = new java.io.FileReader(file)) {
            StringBuffer sb = new StringBuffer();
            while (f.ready()) {
                char c = (char) f.read();
                if (c == '\n') {
                    result.add(sb.toString());
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String name = result.get(0).substring(result.get(0).indexOf(":")+2);
        Integer age = Integer.parseInt(result.get(1).substring(result.get(1).indexOf(":")+2).trim());
        String email = result.get(2).substring(result.get(2).indexOf(":")+2);
        Long phone = Long.parseLong(result.get(1).substring(result.get(1).indexOf(":")+2).trim());
        Profile profile = new Profile(name, age, email, phone);


        return profile;
    }
}