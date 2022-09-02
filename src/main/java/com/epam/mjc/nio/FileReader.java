package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        Path path = Paths.get(file.toURI());
        String[] strings = new String[4];
        int n = 0;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.read() > 0){
                strings[n] = reader.readLine().split(": ")[1];
                n++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        profile.setName(strings[0]);
        profile.setAge(Integer.valueOf(strings[1]));
        profile.setEmail(strings[2]);
        profile.setPhone(Long.valueOf(strings[3]));
        return profile;
    }
}
