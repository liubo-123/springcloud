package com.example.demo.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    public static void get(String url) {
        try {
            //用httpClient模拟http请求,相当于用浏览器发送请求
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            //发送一个get请求,返回的结果是一个HttpResponse响应对象
            HttpResponse response = httpClient.execute(httpGet);
            int resStatus = response.getStatusLine().getStatusCode();
            System.out.println("status=" + resStatus);
            if (resStatus == HttpStatus.SC_OK) {
                //sc_ok=200,说明响应状态码 是200
                //从响应对象中获取响应体内容
                HttpEntity entity = response.getEntity();
                //关闭httpClient的连接
                httpClient.getConnectionManager().shutdown();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void  post(String url, Map<String, String> params) {
        String result = "";
        try {
            //用httpClient模拟http请求,相当于用浏览器发送请求
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
                if (null != params && !params.isEmpty()) {
                    List<NameValuePair> pairs = new ArrayList<NameValuePair>();
                    NameValuePair pair = null;
                    for (String key : params.keySet()) {
                        pair = new BasicNameValuePair(key, params.get(key));
                        pairs.add(pair);
                    }
                    // 模拟表单
                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs);
                    httpPost.setEntity(entity);
                }
                HttpResponse response = httpClient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    result = EntityUtils.toString(response.getEntity(), "utf-8");
                    System.out.println("返回数据：>>>" + result);
                } else {
                    System.out.println("请求失败！，url:" + url);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
