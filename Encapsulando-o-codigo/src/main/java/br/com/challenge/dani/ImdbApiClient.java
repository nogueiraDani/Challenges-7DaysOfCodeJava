package br.com.challenge.dani;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient {
    private String responseJson = getJsonBody();

    public ImdbApiClient() throws IOException, InterruptedException {
    }

    public String getResponseJson() {
        return responseJson;
    }

    private String getJsonBody() throws IOException, InterruptedException {
        URI uriTop250Movies = URI
                .create("https://imdb-api.com/en/API/Top250Movies/"
                        + new Key().getKey());

        HttpResponse<String> response =
                HttpClient.newHttpClient()
                        .send(HttpRequest
                                        .newBuilder()
                                        .uri(uriTop250Movies)
                                        .build(),
                        HttpResponse.BodyHandlers.ofString());
        return responseJson = response.body();
    }
}
