package br.com.challenge.dani;

import java.io.IOException;

public interface APIClient {

   String getJsonBody() throws IOException, InterruptedException;
}
