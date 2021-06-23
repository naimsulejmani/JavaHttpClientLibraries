package httpClients;

import model.Topic;
import retrofit2.http.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

//interace e ka per detyre me komuniku me API
public interface TopicClient {
    @GET("/topics/{id}")
    @Headers("accept:application/json")
    CompletableFuture<Topic> getTopic(@Path("id") int id);

    @GET("/topics")
    @Headers("accept:application/json")
    CompletableFuture<List<Topic>> getTopics();

    @DELETE("/topics/{id}")
    @Headers("accept:application/json")
    CompletableFuture<Topic> deleteById(@Path("id") int id);

    @POST("/topics")

    @Headers( {"Content-Type: application/json","accept:application/json"} )
    CompletableFuture<Topic> postNewTopic(@Body Topic topic);

}
