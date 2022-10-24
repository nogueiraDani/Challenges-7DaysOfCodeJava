package br.com.challenge.dani.ImDb;

import br.com.challenge.dani.Content;
import br.com.challenge.dani.JsonParser;
import br.com.challenge.dani.Movie;

import java.util.ArrayList;
import java.util.List;

public class ImdbMovieJsonParser implements JsonParser {

    private String JsonInitial;
    //private String[] arrayString;
    private List<Content> movies = new ArrayList<>();

    public ImdbMovieJsonParser(String jsonInitial) {
        JsonInitial = jsonInitial;
    }

    // criando string só com o conteudo q estava entre [...]
    private String extractingJson() {
        return JsonInitial
                .replace("{\"items\":[", "")
                .replace("],\"errorMessage\":\"\"}", "");
    }

    // criando array com os filmes
    private String[] extractingArrayJson() {
        String[] arrayString = extractingJson()
                .replace("},{", "}}-{{")
                .split("}-\\{");
        return arrayString;
    }

    @Override
    public List<Content> parseToList() {
        List<Content> movies = new ArrayList<>();

            for (String string : extractingArrayJson()) {
                movies.add(Movie.createNewMovie(string));
        }
        return movies;
    }

    public List<Content> getMovies() {
        return parseToList();
    }
}





