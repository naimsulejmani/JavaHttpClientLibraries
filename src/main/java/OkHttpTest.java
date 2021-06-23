import com.fasterxml.jackson.databind.ObjectMapper;
import model.Topic;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpTest {
    public static void main(String[] args) throws IOException {
        //krijo klientin i cili ka me pranu kerkesen
        OkHttpClient client = new OkHttpClient();

        //krijo kerkesen
        Request request = new Request.Builder()
                .url("http://localhost:8080/topics/1")
                .build(); // default kjo kerse eshte GET

        Response response = client.newCall(request).execute();


        Topic topic = new ObjectMapper().readValue(response.body().byteStream(),Topic.class);

        System.out.println(topic);
    }
}
