package com.zhaoshg.test.file;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Scanner;

public class FileProcess {
    @Test
    public void processWord() throws Exception {
        String filePath = "d:/code.txt";
        FileInputStream inputStream = null;

        Scanner sc = null;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] words = line.split(" ");
                if (words.length > 1) {
                    System.out.println(words[0]);
                }
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }
}
