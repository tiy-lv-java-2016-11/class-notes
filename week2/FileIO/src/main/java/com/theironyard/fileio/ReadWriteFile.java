package com.theironyard.fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jeff on 12/7/16.
 */
public class ReadWriteFile {

    public static void main(String[] args) throws IOException {
        File f = new File("names.txt");
        FileWriter fw = new FileWriter(f);
        fw.write("Sally\n");
        fw.append("Fred\n");
        fw.append("Charlie\n");
        fw.close();

        // read line by line
        Scanner scanner = new Scanner(f);
        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }

        //Read entire file
        scanner = new Scanner(f);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();
        System.out.println(contents);

//        File grades = new File("foo.csv");
//        Scanner scanner = new Scanner(grades);
//        scanner.useDelimiter(",");
//        System.out.println(scanner.next());

    }
}


