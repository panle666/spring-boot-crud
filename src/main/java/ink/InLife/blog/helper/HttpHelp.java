package ink.InLife.blog.helper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Dictionary;
import java.util.Map;

public class HttpHelp {

    public static void httpGet(Map<String, String> dicts) {
        // 准备URL
        String urlS = "https://www.360kad.com";


        HttpURLConnection con = null;
        InputStream inputStream = null;

        //
        String key = "Cookie";
        String value = "__ckguid=Qya3l88IeX2l2gK3goE3g; device_id=213070643315754395890296132aa6b522c34276d03b6f764df735fb3b; homepage_sug=i; r_sort_type=score; __jsluid_s=c79b4a50d420966979a59db36914776c; _ga=GA1.2.873151160.1575439650; __jsluid_h=487df19e7cd92f6dbb14eca45a6ceb42; smzdm_user_source=D99EFDDAE830413D108CA99493ED156B; shequ_pc_sug=a; _gid=GA1.2.1121704404.1591577679; ss_ab=ss98; wt3_sid=%3B999768690672041; wt3_eid=%3B999768690672041%7C2157543960600815544%232159168338900982664; s_his=%E8%B6%85%E6%9E%81%E6%9C%AC%2Camd%2CGTX%201660%20Super%2C%E4%BA%AC%E4%B8%9C%2C%E4%BA%AC%E4%B8%9C%E4%BC%98%E6%83%A0%E5%88%B8%2C%E6%96%B0%E5%85%BB%E9%81%93%2Cu2719%2CAOC%20Q2790PQ%2Cr5%203600%2CAMD%20R5%203600; sess=ZjM1N2F8MTU5NTU4MjA4NXwxOTY2NjIwNTcyfGU3Y2Q3MjA5YThmOGNiZDVkZGQ3ZTViYzVlMTY0NGI5; user=user%3A1966620572%7C1966620572; _zdmA.uid=ZDMA.VP8oQnf4h.1591694086.2419200; smzdm_id=1966620572";

        try {
            URL url = new URL(urlS);
            // 获取 HTTP 连接对象
            con = (HttpURLConnection) url.openConnection();
            // 设置请求头信息
            con.setRequestProperty(key, value);
            // 建立连接
            con.connect();

            // 接收服务器相应内容
            inputStream = con.getInputStream();
            // 长度
            int len = -1;
            // 容器
            byte[] response = new byte[1024];

            while ((len = inputStream.read(response)) != -1) {
                System.out.println(new String(response, 0, len, "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            con.disconnect();
        }
    }
}
