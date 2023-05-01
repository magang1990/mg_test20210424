package com.mg.springboot_project.utils;



import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpUtil {

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        return sendGet(url,param,null);
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param,Map<String,String> header) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Charset", "utf-8");
            // 建立实际的连接
            if (header!=null){
                for (String s : header.keySet()) {
                    connection.setRequestProperty(s,
                            header.get(s));
                }
            }
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
    }

    /**
     * 向指定URL发送POST方法的请求
     * @param url 发送请求的URL
     * @param param 请求参数，请求参数应该是name1=value1&name2=value2的形式。
     * @return URL所代表远程资源的响应
     */
        public static String sendPost(String url,String param)
    {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try
        {
            URL realUrl = new URL(url);
            //打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");


            //发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数
            out.print(param);
            //flush输出流的缓冲
            out.flush();
            //定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine())!= null)
            {
                result += line;
            }
        }catch(Exception e){
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if (out != null){
                    out.close();
                }
                if (in != null){
                    in.close();
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * post请求 json
     * @param apiUrl
     * @param json
     * @return
     */
    public static String doPost(String apiUrl, Object json) {
        return doPost(apiUrl,json.toString());
    }

    public static String doPost(String apiUrl, String json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String httpStr = null;
        try {
            HttpPost httpPost = new HttpPost(apiUrl);
            if(StringUtils.isNotBlank(json)){
                StringEntity stringEntity = new StringEntity(json,"UTF-8");
                stringEntity.setContentEncoding("UTF-8");
                stringEntity.setContentType("application/json");
                httpPost.setEntity(stringEntity);
            }

            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            httpStr = EntityUtils.toString(entity, "UTF-8");
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return httpStr;
    }


    /**
     * 发送 http post 请求，支持文件上传
     */
    public static HttpResponse httpPostFormMultipart(String url, Map<String,String> params, List<File> files, Map<String,String> headers, String encode){
        HttpResponse response = new HttpResponse();
        if(encode == null){
            encode = "utf-8";
        }
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpPost httpost = new HttpPost(url);

        //设置header
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpost.setHeader(entry.getKey(),entry.getValue());
            }
        }
        MultipartEntityBuilder mEntityBuilder = MultipartEntityBuilder.create();
        mEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        mEntityBuilder.setCharset(Charset.forName(encode));

        // 普通参数
        //解决中文乱码
        ContentType contentType = ContentType.create("multipart/form-data",Charset.forName(encode));
        setParams(params, encode, mEntityBuilder,contentType);
        //二进制参数
        if (files != null && files.size() > 0) {
            for (File file : files) {
                mEntityBuilder.addBinaryBody("avatar", file);
            }
        }
        httpost.setEntity(mEntityBuilder.build());
        String content = null;
        CloseableHttpResponse  httpResponse = null;
        try {
            httpResponseMethod(encode, response, httpResponse, closeableHttpClient.execute(httpost));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {  //关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }



    /**
     * 发送 http get 请求
     */
    public static HttpResponse httpGet(String url,Map<String,String> headers, String encode){
        HttpResponse response = new HttpResponse();
        if(encode == null){
            encode = "utf-8";
        }
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        //设置header
        setGetHeader(headers, httpGet);
        String content = null;
        CloseableHttpResponse  httpResponse = null;
        try {
            httpResponseMethod(encode, response, httpResponse, closeableHttpClient.execute(httpGet));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {  //关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    /**
     * 发送 http get 请求 带普通参数
     */
    public static HttpResponse httpGet(String url,Map<String,String> headers,Map<String,String> params,String encode){
        HttpResponse response = new HttpResponse();
        if(encode == null){
            encode = "utf-8";
        }
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);


        MultipartEntityBuilder mEntityBuilder = MultipartEntityBuilder.create();
        mEntityBuilder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        mEntityBuilder.setCharset(Charset.forName(encode));
        //设置普通参数
        ContentType contentType = ContentType.create("application/json",Charset.forName(encode));
        setParams(params, encode, mEntityBuilder,contentType);
        //设置header
        setGetHeader(headers, httpGet);
        String content = null;
        CloseableHttpResponse  httpResponse = null;
        try {
            httpResponseMethod(encode, response, httpResponse, closeableHttpClient.execute(httpGet));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {  //关闭连接、释放资源
            closeableHttpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return response;
    }

    private static void setGetHeader(Map<String, String> headers, HttpGet httpGet) {
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpGet.setHeader(entry.getKey(),entry.getValue());
            }
        }
    }

    private static void httpResponseMethod(String encode, HttpResponse response, CloseableHttpResponse httpResponse, CloseableHttpResponse execute) {
        String content;
        try {
            httpResponse = execute;
            HttpEntity entity = httpResponse.getEntity();
            content = EntityUtils.toString(entity, encode);
            response.setBody(content);
            response.setHeaders(httpResponse.getAllHeaders());
            response.setReasonPhrase(httpResponse.getStatusLine().getReasonPhrase());
            response.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void setParams(Map<String, String> params, String encode, MultipartEntityBuilder mEntityBuilder,ContentType contentType) {
        if (params != null && params.size() > 0) {
            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                mEntityBuilder.addTextBody(key, params.get(key),contentType);
            }
        }
    }

    /**
     * 将map 转换成参数
     * @param params
     * @return
     */
    public static String processingParameter(Map<String,String> params){
        StringBuilder paramString = new StringBuilder();
        for (String s : params.keySet()) {
            paramString.append("&");
            paramString.append(s).append("=").append(params.get(s));
        }
        return paramString.toString().replaceFirst("&","");
    }

    public static String httpPost(String url, Map<String,Object> param) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 2.设置请求方式和请求信息
        HttpPost httpPost = new HttpPost(url);

        //2.1 提交header头信息
        httpPost.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
        //2.1 提交请求体
        //提交方式1:一般用在原生ajax请求
        //    httpPost.setEntity(new StringEntity("username=zhangsan&passwd=123"));
        //提交方式2：大多数的情况下用这种方式
        ArrayList<BasicNameValuePair> parameters = new ArrayList<>();
        for (Map.Entry<String,Object> entry:param.entrySet()){
           parameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }

        httpPost.setEntity(new UrlEncodedFormEntity(parameters));

        // 3.执行请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        // 4.获取返回值
        return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
    }

    public static byte[] GetImage(String imageUrl){
        byte[] data = new byte[4096];
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con .setRequestMethod("GET");
            con .setConnectTimeout(4 * 1000);
            InputStream inStream = con .getInputStream();//通过输入流获取图片数据
            data = readInputStream(inStream);
            inStream.read(data);//读取该数据
            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[2048];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        return outStream.toByteArray();
    }
}
