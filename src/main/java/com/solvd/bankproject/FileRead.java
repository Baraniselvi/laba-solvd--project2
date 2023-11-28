package com.solvd.bankproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    public static void main(String[] args) {



    String file = "1.txt";
           try(
    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\baran\\IdeaProjects\\laba-solvd-project2\\src\\main\\resources\\1.txt")))

    {
        String line = br.readLine();
        while (line != null) {
            line = br.readLine();
        }


    } catch(
    IOException e)

    {
        throw new RuntimeException(e);
    }

}

}
