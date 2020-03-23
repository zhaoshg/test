package com.zhaoshg.test;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class LogAnalysis {


    public static void main(String[] args) throws IOException {

//        String path = "D:\\日志\\datamodel0816-4";
//        analys(path);
//        path = "D:\\日志\\datamodel0816-5";
//        analys(path);
        analys2("D:\\test");
    }


    public static void analys2(String filePath) {
        File file = new File(filePath);
        BufferedInputStream fis = null;
        BufferedReader reader = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(file));
            reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), 10 * 1024 * 1024);// 用20M的缓冲读取文本文件
            String lineTxt = "";
            while ((lineTxt = reader.readLine()) != null) {
                if (lineTxt.contains("(")) {
                    String emun = lineTxt.substring(lineTxt.indexOf("(") + 1, lineTxt.lastIndexOf(")"));
                    String[] codes = emun.split(",");
                    for (String code : codes) {
                        System.out.print(code.replaceAll("\"", "") + ",");
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void analys(String path) throws IOException {
        {

            var urlMap = new LinkedHashMap<String, String>();
            var costMap = new LinkedHashMap<String, Integer>();
            var threadNum = "";
            var url = "";
            var cost = "";
            var logDir = new File(path);
            System.out.println("start to analys logs in " + path);
            if (logDir.isDirectory()) {
                File[] logs = logDir.listFiles();
                for (File logFile : logs) {
                    System.out.println("start to analys log :" + logFile.getPath());
                    BufferedInputStream fis = null;
                    BufferedReader reader = null;
                    try {
                        fis = new BufferedInputStream(new FileInputStream(logFile));
                        reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), 10 * 1024 * 1024);// 用20M的缓冲读取文本文件
                        String lineTxt = "";
                        while ((lineTxt = reader.readLine()) != null) {
                            if (lineTxt.contains("invokeMethod instanceName")) {
                                threadNum = lineTxt.substring(lineTxt.indexOf("[") + 1, lineTxt.indexOf("-dm]"));
                                url = lineTxt.substring(lineTxt.indexOf("invokeMethod instanceName:") + "invokeMethod instanceName:".length());
                                urlMap.put(threadNum, url);
                            } else if (lineTxt.contains("cost:[")) {
                                threadNum = lineTxt.substring(lineTxt.indexOf("[") + 1, lineTxt.indexOf("-dm]"));
                                cost = lineTxt.substring(lineTxt.indexOf("cost:[") + "cost:[".length(), lineTxt.lastIndexOf("]"));
                                costMap.put(threadNum, Integer.valueOf(cost));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (fis != null) {
                            fis.close();
                        }
                        if (reader != null) {
                            reader.close();
                        }
                    }
                }
            }

            System.out.println("urlMap=" + urlMap.size());
            System.out.println("costMap=" + costMap.size());

            File loadFile = new File(path, "result.txt");

            try {
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(loadFile));// 考虑到编码格式
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                for (Map.Entry<String, String> e : urlMap.entrySet()) {
                    // 按栏位拼接写入
                    bufferedWriter.write("('" + e.getValue() + "'," + costMap.get(e.getKey()) + "),");
                    bufferedWriter.newLine();
                }
                bufferedWriter.flush();
                bufferedWriter.close();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}