package com.zhaoshg;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MaskUrlGen {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        System.out.println(genUrl("陈伟","341124198911051821", "15255563345", Store.SHUNYUAN));
        String userInfo = "王凤利,610327198710291225,13641131959,魏龙义,342224198803021672,15701233159,赵明,342224198805311235,15695626003,赵如山,341323201309091213,18715096656,杜巧娟,360425198903200028,18715110014,魏居望,341323200612121679,18154133799,魏礼亚,342224195702046818,18298087567,王凤翠,342224195502176829,15755704828,赵曙光,342224198403131231,18456539394,魏敏,342224198206141625,18456539349,赵懿轩,341323200810231254,18456539348,赵逸凡,34132320140910005X,18500402713,魏马龙,34222419890316163X,17718563189,魏满意,342224198508101610,18201133799";
        String sign = "1585126802115,f1ddcad1dcd10e5d76ce9f715e1d7a40,1585126802603,43bf4a1c831d9e47a7136938d4bb0045,1585126803099,9d8b2e5e2c7b749d7767c62054a63d42,1585126803599,2d66f4d53988bcc83b60f8f13a3accfc,1585126804099,9df055d86b7744e05d922283004cf151,1585126804603,4f3c309d128f2085393b679d41c2340a,1585126805099,0e350906c1b3727d7646cf47af4d6e4e,1585126805596,d86e8ff10c185497c817b1ddaca6f7e0,1585126806097,e90f1b632a9322105f5d71b24abda23c,1585126806596,5d280d0871e15f7f06b63a96fbe52842,1585126807097,be04f7993a9555b442d3a0963e5fe1be,1585126807598,6d0a14184f5a357561b485f154df7ef9,1585126808098,4cd9e5e194c4c4a595f3848a56c40b24,1585126808596,78883ff861a80a7dbb235b80e3c77c7c,1585126809097,8635b0e95891f7688ec24a3472ede5ea,1585126809596,dae06a63bfd91dd93f6b9848d0daaa48,1585126810097,b80d6b8d8386f711765c8a618b46a5a9,1585126810599,df5a170353593dcab1e045968db81811,1585126811097,a2b32ddef4df07e779fdbd8182d18308,1585126811597,2f2ce6d20e7c41f87e7349af9da7d75d";
        String[] userInfos = userInfo.split(",");
        String[] signs = sign.split(",");
        int cnt = Math.min(userInfos.length/3,signs.length/2);
        for (int i = 0; i < cnt; i++) {
            System.out.println(genUrl(userInfos[i*3],userInfos[i*3+1],userInfos[i*3+2],Store.GUODA,signs[i*2],signs[i*2+1]));
        }
    }

    public static String genUrl(String name, String idcard, String phone, Store store,String timestr,String hash) throws UnsupportedEncodingException {
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
                .append("&refresh=false&timestamp=").append(timestr)
                .append("&refresh=false&timestamp=").append(timestr)
                .append("&hash=").append(hash);
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
