package br.com.challenge.dani.Marvel;

import br.com.challenge.dani.APIClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarvelApiClient implements APIClient {

    @Override
    public String getJsonBody() throws IOException, InterruptedException {
        URI uriMarvel = URI
                .create("developer.marvel.com"
                + new KeyMarvel().getKey());

        HttpResponse<String> response =
                HttpClient.newHttpClient()
                        .send(HttpRequest
                                .newBuilder()
                                .uri(uriMarvel)
                                .build(),
                                HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
