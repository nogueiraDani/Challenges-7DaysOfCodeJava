package br.com.challenge.dani;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {

    private String id;
    private String rank;
    private String title;
    private String fullTitle;
    private String year;
    private String image;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;

    //constructor

    public Movie(String id, String rank, String title, String fullTitle, String year, String image, String crew,
                 String imDbRating, String imDbRatingCount) {
        this.id = id;
        this.rank = rank;
        this.title = title;
        this.fullTitle = fullTitle;
        this.year = year;
        this.image = image;
        this.crew = crew;
        this.imDbRating = imDbRating;
        this.imDbRatingCount = imDbRatingCount;
    }

    // método para completar a lista de acordo com as categorias
    public static Movie createNewMovie(String string) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

            Movie movie = gson.fromJson(string, Movie.class);

            final String idResult = movie.getId();
            final String rankResult = movie.getRank();
            final String titleResult = movie.getTitle();
            final String fullTitleResult = movie.getFullTitle();
            final String yearResult = movie.getYear();
            final String imageResult = movie.getImage();
            final String crewResult = movie.getCrew();
            final String imDbRatingResult = movie.getImDbRating();
            final String imDbRatingCountResult = movie.getImDbRatingCount();


        return new Movie(idResult, rankResult, titleResult, fullTitleResult, yearResult, imageResult
                , crewResult, imDbRatingResult, imDbRatingCountResult);
    }

    //getters
    public String getId() {
        return id;
    }

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public String getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public String getCrew() {
        return crew;
    }

    public String getImDbRating() {
        return imDbRating;
    }

    public String getImDbRatingCount() {
        return imDbRatingCount;
    }


}

