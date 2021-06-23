import httpClients.TopicClient;
import model.Topic;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RetrofitTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Retrofit: krijo kerkesen retorift, cakto url vendose konvertuesin
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        TopicClient topicApi = retrofit.create(TopicClient.class);

        var requestPost = topicApi.postNewTopic(
                new Topic(1, "NAIM", "SULEHJMANI", "2021-01-01", true));

        Topic topic = requestPost.get();
        System.out.println(topic);

//        var request1 = topicApi.getTopic(1);
//        var request2 = topicApi.getTopics();
//        var request3 = topicApi.deleteById(2);
//
//        var request4 = topicApi.getTopics();
//
//
//        System.out.println("ketu mundemi me ba kerkesa tjera te cfaredoshme");
//
//        System.out.println(request2.get().size());
//        System.out.println(request4.get().size());
//
//        Topic topic = request1.get();
//        System.out.println(topic);


    }
}
