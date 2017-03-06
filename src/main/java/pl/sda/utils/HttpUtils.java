package pl.sda.utils;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpUtils {

    public static String parseResponse(HttpResponse response) throws IOException {
        StringBuffer buffer = new StringBuffer();

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        String line = null;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }

        return buffer.toString();

    }
}
