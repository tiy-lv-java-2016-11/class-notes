package com.theironyard.fileio;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jeff on 12/7/16.
 */
public class ReadWriteJson {
    public static void main(String[] args) throws IOException {
        Person p = new Person("Sally Struthers", 30);

        File f = new File("person.json");

        //Write json
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(p);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();

        // read the json file
        Scanner scanner = new Scanner(f);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();
        JsonParser parser = new JsonParser();
        Person p2 = parser.parse(contents, Person.class);

        System.out.println(p2);

    }

}
