package edu.scdx.Utils;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.jdbc.Null;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

/**
 * Created by zhou on 2017/7/21.
 */
public class NetUtils {
    public JSONObject get(String url, JSONObject param) throws JSONException {
        String result = "";

        String data = "";
        Iterator iterator = param.keys();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            data += key + "=" + param.get(key) + "&";
        }
        data = data.substring(0, data.length() - 1);

        try {

            URL TargeURL = new URL(url+"?"+data);
            URLConnection connection = TargeURL.openConnection();

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }

            br.close();
            isr.close();
            is.close();

            result = builder.toString();
            System.out.println(result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JSONObject(result);

    }

    public JSONObject post(String url,JSONObject param) throws JSONException {
        String Result = "";
        try {
            URL TargeUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) TargeUrl.openConnection();
            connection.addRequestProperty("encoding","UTF-8");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            InputStream is = connection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            OutputStream os = connection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            connection.setRequestMethod("POST");
            bw.write(param.toString());

            String line;
            StringBuilder builder = new StringBuilder();
            while((line=br.readLine())!= null){
                builder.append(line);
            }

            bw.close();
            osw.close();
            os.close();

            br.close();
            isr.close();
            is.close();

            Result = builder.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONObject(Result);
    }
}

