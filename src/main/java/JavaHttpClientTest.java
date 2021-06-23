import model.JsonBodyHandler;
import model.Topic;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class JavaHttpClientTest {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        synchronousRequestTest();
        asynchronousRequestTest();
    }

    private static void synchronousRequestTest() throws IOException, InterruptedException {
        System.out.println("Synchronous Request Test");
        //kriju klientin
        HttpClient client = HttpClient.newHttpClient();

        //duhet me kriju kersen
        HttpRequest request = HttpRequest.newBuilder(
                URI.create("http://localhost:8080/topics/1")
        ).build();

        //ben thirrje ne api per me dergu kerkesen tone
        HttpResponse<Supplier<Topic>> response = client.send(request, new JsonBodyHandler<>(Topic.class));

        //kontrolloimin e pergjigjes
        System.out.println(response.body().get());
    }

    private static void asynchronousRequestTest() throws ExecutionException, InterruptedException {
        System.out.println("Asynchronous Request Test");
        //krijo klientin
        var client = HttpClient.newHttpClient();
        //krijo kerkesen
        var request = HttpRequest.newBuilder(
                URI.create("http://localhost:8080/topics/1")
        ).header("accept", "application/json")
                .build();

        //beje thirrjen ne api per me dergu kerkesen atje
        var responseFuture = client.sendAsync(request, new JsonBodyHandler<>(Topic.class));
        System.out.println("Hej a jeni lodh! A po kuptoni najsen!");
        var response = responseFuture.get();

        System.out.println(response.statusCode());
        System.out.println(response.body().get());

    }

}
