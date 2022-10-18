package br.com.challenge.dani;

import br.com.challenge.dani.components.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        //criando conexcao
        Connection connection = new Connection();

        String responseJson = connection.getResponseJson();

        // criando string só com o conteudo q estava entre [...]
        String newResponse = responseJson
                .replace("{\"items\":[", "")
                .replace("],\"errorMessage\":\"\"}", "");

        // criando array com os filmes
        String[] arrayString = newResponse
                .replace("},{", "}}-{{")
                .split("}-\\{");

        // criando listas com as descrições dos filmes
        List<String> ListId = createList(arrayString, "id");
        System.out.println(ListId);

        List<String> ListRank = createList(arrayString, "rank");
        System.out.println(ListRank);

        List<String> ListTitle = createList(arrayString, "title");
        System.out.println(ListTitle);

        List<String> ListFullTitle = createList(arrayString, "fullTitle");
        System.out.println(ListFullTitle);

        List<String> ListYear = createList(arrayString, "year");
        System.out.println(ListYear);

        List<String> ListImage = createList(arrayString, "image");
        System.out.println(ListImage);

        List<String> ListCrew = createList(arrayString, "crew");
        System.out.println(ListCrew);

        List<String> ListImDbRating = createList(arrayString, "imDbRating");
        System.out.println(ListImDbRating);

        List<String> ListImDbRatingCount = createList(arrayString, "imDbRatingCount");
        System.out.println(ListImDbRatingCount);


    }

    // método para completar a lista de acordo com as categorias
    public static List<String> createList(String[] strings, String category) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        List<String> result = new ArrayList<String>();

        for (String s : strings) {
            Movie movie = gson.fromJson(s, Movie.class);
            if (category.equals("id")) result.add(movie.getId());
            if (category.equals("rank")) result.add(movie.getRank());
            if (category.equals("title")) result.add(movie.getTitle());
            if (category.equals("fullTitle")) result.add(movie.getFullTitle());
            if (category.equals("year")) result.add(movie.getYear());
            if (category.equals("image")) result.add(movie.getImage());
            if (category.equals("crew")) result.add(movie.getCrew());
            if (category.equals("imDbRating")) result.add(movie.getImDbRating());
            if (category.equals("imDbRatingCount")) result.add(movie.getImDbRating());
        }
        return result;
    }
}



