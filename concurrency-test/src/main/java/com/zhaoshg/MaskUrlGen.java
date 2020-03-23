package com.zhaoshg;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MaskUrlGen {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        System.out.println(genUrl("陈伟","341124198911051821", "15255563345", Store.SHUNYUAN));
        String userInfo = "赵曙光,342224198403131231,18456539394,魏敏,342224198206141625,18456539349,赵懿轩,341323200810231254,18456539348,赵逸凡,34132320140910005X,18500402713,魏满意,342224198508101610,18201133799,王凤利,610327198710291225,13641131959,魏马龙,34222419890316163X,17718563189,魏龙义,342224198803021672,15701233159,赵明,342224198805311235,15695626003,赵如山,341323201309091213,18715096656,杜巧娟,360425198903200028,18715110014,魏居望,341323200612121679,18154133799,魏礼亚,342224195702046818,18298087567,王凤翠,342224195502176829,15755704828";
        String sign = "1584954003704,65dda138059e6662459ebea3a91f6213,1584954003804,438daa6efca26997e2125a1d533709ba,1584954003895,e3dd495036ed123e89ca136672b0cc06,1584954004009,feddc395f9535240d414a45c67534ec0,1584954004129,238f6d0d0f7d79d7c398b86c85093221,1584954004208,c8d990c06d3c041f9372936c110f2ab1,1584954004293,25533cd7040a5ce8749b179aa03d3937,1584954004393,9407e3bcb07868e024a9e0ee72bd87b2,1584954004493,ecc251226fed0642e0a721e8706937c9,1584954004592,0afcf792b44e4491e456b658c647dc5f";
        String[] userInfos = userInfo.split(",");
        String[] signs = sign.split(",");
        for (int i = 0; i < 10; i++) {
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
