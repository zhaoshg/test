package com.zhaoshg.test.loganalyes;

import java.io.*;

/**
 * @className: LargeFileReader
 *
 * @description:
 *
 * @author zhaoshuguang
 *
 * @Date 2019-07-01
 */
public class LargeFileReader {


    public static void largeFileIO(String inputFile, String outputFile) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(inputFile)));
            BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"), 10 * 1024 * 1024);//10M缓存
            FileWriter fw = new FileWriter(outputFile);
            while (in.ready()) {
                String line = in.readLine();
                fw.append(line + " ");
            }
            in.close();
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
