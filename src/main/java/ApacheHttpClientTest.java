import com.fasterxml.jackson.databind.ObjectMapper;
import model.Topic;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;
import java.time.LocalDate;

public class ApacheHttpClientTest {
    //1. krijimi i conection -> url -> me bo thirrjen -> me pranu objektin
    //--> me konvertu edhe me shfaq objektin

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        //shko ne shallter
        CloseableHttpClient client = HttpClients.createDefault();
        //mbushe formularin
        HttpGet request = new HttpGet("http://localhost:8080/topics/1");
        //dhe prite pergjigjen e duhur
        Topic response = client.execute(request,
                httpResponse -> mapper.readValue(httpResponse.getEntity().getContent(), Topic.class));

        //kontrollo a eshte mire
        System.out.println(response);
    }
}
