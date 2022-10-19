package br.com.challenge.dani;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        //chamar API
        String responseJson = new ImdbApiClient().getResponseJson();

        //criando conversor
        ImdbMovieJsonParser imdbMovieJsonParser = new ImdbMovieJsonParser(responseJson);

        //imdbMovieJsonParser JSON
        String[] arrayString = imdbMovieJsonParser.extractingArrayJson();

        //criando lista de filmes
        List<Movie> movies = new ArrayList<>();

        for (String string : arrayString) {
            movies.add(Movie.createNewMovie(string));
        }

        PrintWriter printWriter = new PrintWriter("index.html");
        HTMLGenerator htmlGenerator = new HTMLGenerator();

        htmlGenerator.createHtmnl(movies, printWriter, htmlGenerator);


    }

}



