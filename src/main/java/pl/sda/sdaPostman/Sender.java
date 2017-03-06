package pl.sda.sdaPostman;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import pl.sda.utils.HttpUtils;

import java.io.IOException;

/**
 * wysylka zapytania i odebranie danych
 */
public class Sender { //fasada http klienta

    public static String createUser(String url, String request) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url); //nowy obiekt HttpPost

        post.setEntity(new StringEntity(request)); //opakowanie Stringa do wysyłki

        HttpResponse response = httpClient.execute(post);
        return HttpUtils.parseResponse(response); //po wywolaniu idzie przez Util i wychodzi String
    }

    public static String getUser(String url, String id) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url+"?id="+id);

        HttpResponse response = httpClient.execute(get);
        return HttpUtils.parseResponse(response);
    }
}
