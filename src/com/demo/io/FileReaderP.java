package com.demo.io;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileReader ↘
 */
public class FileReaderP {




    public FileReader getFileReaderObject(String filename) {

        try {
            return new FileReader(filename);
        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
        return null;
    }
}
