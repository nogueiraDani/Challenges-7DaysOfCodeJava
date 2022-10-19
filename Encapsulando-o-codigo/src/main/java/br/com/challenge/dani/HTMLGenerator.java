package br.com.challenge.dani;

import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

    private String head = generateHead();

    private String divTemplate = generateDiv();

    private String closeBody = generateCloseBody();


    public String getHead() {
        return head;
    }

    public String getCloseBody() {
        return closeBody;
    }

    public String getDivTemplate() {
        return divTemplate;
    }

    public String generateHead() {
        return head = """
                <!DOCTYPE html>
                       <html lang="pt-br">
                         <head>
                           <title>Movie</title>
                           <!-- Required meta tags -->
                           <meta charset="utf-8" />
                           <meta
                             name="viewport"
                             content="width=device-width, initial-scale=1, shrink-to-fit=no"
                           />
                       
                           <!-- Bootstrap CSS v5.2.1 -->
                           <link
                             href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
                             rel="stylesheet"
                             integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
                             crossorigin="anonymous"
                           />
                         </head>
                         <body class="container">
                            <main class="row">
                """;
    }

    private String generateCloseBody() {
        return closeBody =
                """
                            </main>
                          </body>
                        """;
    }

    private String generateDiv() {
        return divTemplate =
                """
                     <div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
                         <h4 class=\"card-header\">%s</h4>
                         <div class=\"card-body\">
                             <img class=\"card-img\" src=\"%s\" alt=\"%s\">
                             <p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
                         </div>
                     </div> 
                """;
    }

    public void createHtmnl(List<Movie> movies, PrintWriter printWriter, HTMLGenerator htmlGenerator){

        printWriter.println(String.format(htmlGenerator.getHead()));
        for (Movie movie: movies) {
            printWriter.println(String.format(htmlGenerator.getDivTemplate(),
                    movies.get(movies.indexOf(movie)).getTitle(),
                    movies.get(movies.indexOf(movie)).getImage(),
                    movies.get(movies.indexOf(movie)).getTitle(),
                    movies.get(movies.indexOf(movie)).getImDbRating(),
                    movies.get(movies.indexOf(movie)).getYear()));
        }
        printWriter.println(String.format(htmlGenerator.getCloseBody()));
        printWriter.close();
    }
}
