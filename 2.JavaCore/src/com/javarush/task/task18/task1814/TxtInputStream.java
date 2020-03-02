package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private FileInputStream in;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (fileName.length() > 4) {
            String fileExtension = fileName.substring(fileName.length() - 4, fileName.length());
            if (fileName.endsWith(".txt")){
                    //".txt".equals(fileExtension)) {
                //super(fileName);
                this.in = new FileInputStream(fileName);
            } else {
                super.close();
                //in.close();
                throw new UnsupportedFileNameException();
            }

        } else {
            super.close();
            //in.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
        //TxtInputStream t = new TxtInputStream("out.log");
    }
}

