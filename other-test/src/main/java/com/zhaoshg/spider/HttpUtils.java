package com.zhaoshg.spider;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


public class HttpUtils {


    public static void main(String[] args) {
        try {
            System.out.println(getUrl("http://www.biquge.info/3_3649/"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getUrl(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder().url(url).build();
        Response rep = client.newCall(req).execute();
        System.out.println("返回码：" + rep.code());
        //rep.header("这里写头，可以得到相关值")
        //rep.body().string() 只能被调用一次，在要对返回内容做多次操作时用字符串存一下
        return rep.body().string();
    }
}
