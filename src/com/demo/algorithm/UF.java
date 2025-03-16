package com.demo.algorithm;

import java.io.File;
import java.util.Map;

public interface UF {
    /**
     * This method will GET the file data
     * @param file
     * @return Map<String,Integer>
     */
    Map<String,Integer> GetFileData(File file);

    /**
     * This method will CREATE the text file
     * @param name
     * @return File
     */
    File createFileIfNotExist(String name);

    Map<Integer,Object> GetFileData2(File file);
}
