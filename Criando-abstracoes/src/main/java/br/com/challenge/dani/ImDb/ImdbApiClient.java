package br.com.challenge.dani.ImDb;

import br.com.challenge.dani.APIClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient implements APIClient {
        public ImdbApiClient() throws IOException, InterruptedException {
    }

    public String getJsonBody() throws IOException, InterruptedException {
        URI uriTop250Movies = URI
                .create("https://imdb-api.com/en/API/Top250Movies/"
                        + new KeyImDb().getKey());

        HttpResponse<String> response =
                HttpClient.newHttpClient()
                        .send(HttpRequest
                                        .newBuilder()
                                        .uri(uriTop250Movies)
                                        .build(),
                        HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
