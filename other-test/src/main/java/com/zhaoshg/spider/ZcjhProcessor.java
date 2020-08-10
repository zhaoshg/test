package com.zhaoshg.spider;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ZcjhProcessor {

    private static final String zcjhUrl = "http://www.biquge.info/3_3649/";
    private static final String file = "D:\\zcjh.txt";

    public static void main(String[] args) throws FileNotFoundException {
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
        try {
            List<String> urls = getContents(zcjhUrl);
            int i = 0;

            for (String url : urls) {
                String[] urlPair = url.split("♡");
                if (urlPair.length < 2) {
                    System.out.println("ERROR!!!!!!!!!!:" + url);
                    continue;
                }
                String title = urlPair[0];
                System.out.println(url);
                System.out.println(urlPair[1]);
                String[] idstr = urlPair[1].split("\\.");
                System.out.println(idstr[0]);
                if (Long.parseLong(idstr[0]) <= 19268207) {
                    System.out.println(urlPair[1] + "Already got !!!!");
                    continue;
                }
                String content = getContent(zcjhUrl + urlPair[1]);
                // 文件长度，字节数
                output.write(title + "\n\n\n");
                output.write(content + "\n\n\n");
                i++;
                Thread.sleep((long) (800+Math.random()*1000));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> getContents(String url) throws IOException {
        List<String> contents = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements list = doc.select("#list").select("dl").select("a");
        for (Element element : list) {
            contents.add(element.text() + "♡" + element.attr("href"));
        }
        return contents;
    }

    private static String getContent(String url) throws InterruptedException, IOException {
        String text = "";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (HttpStatusException e) {
            Thread.sleep(5000);
            doc = Jsoup.connect(url).get();
        }
        assert doc != null;
        Elements content = doc.select("#content");
        return br2nl(content.html());
    }

    public static String br2nl(String html) {
        if (html == null)
            return html;

        html = html.replaceAll("&nbsp;", " ");
        Document document = Jsoup.parse(html);
        document.outputSettings(new Document.OutputSettings().prettyPrint(false));//makes html() preserve linebreaks and spacing
//        document.select("br").append("\\n");
//        document.select("p").prepend("\\n\\n");
        String s = document.html().replaceAll("\\\\n", "\n");
        return Jsoup.clean(s, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
    }

}
