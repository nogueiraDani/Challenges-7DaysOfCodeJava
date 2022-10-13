package br.com.challenge.dani;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        //chave de acesso
        Key key = new Key();

        //URI
        URI uriTop250Movies = URI.create("https://imdb-api.com/en/API/Top250Movies/" + key.getKey());

        //HttpClient
        HttpClient client = HttpClient.newHttpClient();

        //HttpRequest
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(uriTop250Movies)
                .build();

        //HttpResponse
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        //exibindo resposta
        System.out.println(json);



    }
}