package com.zhaoshg.js;


import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ExecuteScript {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String url =  genUrl("赵曙光", "342224198403131231", "18456539394", Store.GUODA);

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        try {
            String path = Thread.currentThread().getContextClassLoader().getResource("").getPath(); // 获取targe路径
            System.out.println(path);
            // FileReader的参数为所要执行的js文件的路径


            engine.eval(new FileReader(path + "jquery-1.12.4.min.js"));
            engine.eval(new FileReader(path + "common.js"));
            if (engine instanceof Invocable) {
                Invocable invocable = (Invocable) engine;
                JavascriptInterface executeMethod = invocable.getInterface(JavascriptInterface.class);
                System.out.println(executeMethod.ajaxNcms2(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String genUrl(String name, String idcard, String phone, Store store) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder();
        url.append(name).append("-")
                .append(store.getName()).append(" —— ")
                .append("http://kzgm.bbshjz.cn:8000/ncms/mask/book-view?")
                .append("pharmacyCode=").append(store.getId())
                .append("&pharmacyName=").append(URLEncoder.encode(store.getName(), "UTF-8"))
                .append("&name=").append(URLEncoder.encode(name, "UTF-8"))
                .append("&cardNo=").append(idcard)
                .append("&phone=").append(phone)
                .append("&reservationNumber=5&pharmacyPhase=13:00-17:00")
                .append("&refresh=").append("false");
        return url.toString();
    }


    enum Store {
        YANGGUANG("10421", "世纪阳光百姓缘"),
        JIAJIA("1063", "合肥大药房佳佳洁医药专柜"),
        GUODA("1803G", "国大药房金地店"),
        SHUNYUAN("11119", "国胜大药房滨湖顺园店"),
        ZHOUGUDUI("1174", "百姓缘大药房周谷堆店");
        private String id;
        private String name;

        Store(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
