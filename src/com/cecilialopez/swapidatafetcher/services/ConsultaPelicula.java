package com.cecilialopez.swapidatafetcher.services;

import com.cecilialopez.swapidatafetcher.models.Pelicula;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPelicula {

    public Pelicula buscaPelicula(int numeroDePelicula) {
        URI direccion = URI.create("https://swapi.py4e.com/api/films/" + numeroDePelicula + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Pelicula.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa película.");
        }
    }
}
