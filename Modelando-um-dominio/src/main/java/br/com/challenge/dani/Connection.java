package br.com.challenge.dani;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Connection {

    public Connection() throws IOException, InterruptedException {
    }
    private final Key key = new Key();
    private final URI uriTop250Movies = URI.create("https://imdb-api.com/en/API/Top250Movies/" + key.getKey());
    private final HttpClient client = HttpClient.newHttpClient();
    private final HttpRequest request = HttpRequest.newBuilder().uri(uriTop250Movies).build();

    private final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    private final String responseJson = response.body();

    public String getResponseJson() {
        return responseJson;
    }

    public URI getUriTop250Movies() {
        return uriTop250Movies;
    }
}
