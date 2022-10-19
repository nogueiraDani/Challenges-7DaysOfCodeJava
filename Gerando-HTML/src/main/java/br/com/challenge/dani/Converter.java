package br.com.challenge.dani;

public class Converter {

    private String JsonInitial;
    private String[] arrayString;

    public Converter(String jsonInitial) {
        JsonInitial = jsonInitial;
    }

    // criando string só com o conteudo q estava entre [...]
    public String extractingJson() {
        return JsonInitial
                .replace("{\"items\":[", "")
                .replace("],\"errorMessage\":\"\"}", "");
    }

    // criando array com os filmes
    public String[] extractingArrayJson() {
        arrayString = extractingJson()
                .replace("},{", "}}-{{")
                .split("}-\\{");
        return arrayString;
    }

}





