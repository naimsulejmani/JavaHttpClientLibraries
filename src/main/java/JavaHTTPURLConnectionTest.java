import com.fasterxml.jackson.databind.ObjectMapper;
import model.Topic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JavaHTTPURLConnectionTest {
    public static void main(String[] args) throws IOException {
        //fillimisht na vyne URL (nderto kerkesen)
        URL url = new URL("http://localhost:8080/topics/1");

        //krijo koneksioonin nepemrjet ketij url
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //vendose headers nese ki nevoje
        connection.setRequestProperty("accept","application/json");

        //beje kerkesen
        var responseStream = connection.getInputStream();

        //krijo mapper objektin
        ObjectMapper mapper = new ObjectMapper();
        //konverto stream ne objekt te Topic -> duke perdore ne parapvioje java reflection
        Topic response = mapper.readValue(responseStream, Topic.class);

        //kontrollo pergjigjen
        System.out.println(response);
    }
}
