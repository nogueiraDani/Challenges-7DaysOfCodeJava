package br.com.challenge.dani;

import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {

    public String getHead() {
        return generateHead();
    }

    public String getCloseBody() {
        return generateCloseBody();
    }

    public String getDivTemplate() {
        return generateDiv();
    }

    public String generateHead() {
        return """
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
                         <body class="container bg-secondary bg-gradient">
                            <main class="row">
                """;
    }

    private String generateCloseBody() {
        return """
                            </main>
                          </body>
                        """;
    }

    private String generateDiv() {
        return  """
                     <div class=\"card text-white bg-dark bg-gradient mb-3\" style=\"max-width: 18rem;\">
                         <h4 class=\"card-header\">%s</h4>
                         <div class=\"card-body\">
                             <img class=\"card-img\" src=\"%s\" alt=\"%s\">
                             <p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
                         </div>
                     </div> 
                """;
    }

    public void createHtml(List<Content> movies, PrintWriter printWriter){

        printWriter.println(String.format(getHead()));
        for (Content movie: movies) {
            printWriter.println(String.format(getDivTemplate(),
                    movies.get(movies.indexOf(movie)).title(),
                    movies.get(movies.indexOf(movie)).urlImage(),
                    movies.get(movies.indexOf(movie)).title(),
                    movies.get(movies.indexOf(movie)).rating(),
                    movies.get(movies.indexOf(movie)).year()));
        }
        printWriter.println(String.format(getCloseBody()));
        printWriter.close();
    }
}
