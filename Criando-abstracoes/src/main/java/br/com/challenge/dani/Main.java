package br.com.challenge.dani;

import br.com.challenge.dani.ImDb.ImdbApiClient;
import br.com.challenge.dani.ImDb.ImdbMovieJsonParser;
import br.com.challenge.dani.Marvel.MarvelApiClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        //chamar API ImDb
        String responseJsonImDb = new ImdbApiClient().getJsonBody();

        //criando lista de filmes
        List<Content> moviesImDb = new ImdbMovieJsonParser(responseJsonImDb).getMovies();

        PrintWriter printWriter = new PrintWriter("imdb-index.html");
        HTMLGenerator htmlGenerator = new HTMLGenerator();
        htmlGenerator.createHtml(moviesImDb, printWriter);


        //chamar API Marvel
        String responseJsonMarvel = new MarvelApiClient().getJsonBody();
        System.out.println(responseJsonMarvel);
    }

}



