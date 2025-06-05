package com.cecilialopez.swapidatafetcher.main;

import com.cecilialopez.swapidatafetcher.services.ConsultaPelicula;
import com.cecilialopez.swapidatafetcher.models.Pelicula;

public class Main {
    public static void main(String[] args) {
        ConsultaPelicula consulta = new ConsultaPelicula();
        Pelicula pelicula = consulta.buscaPelicula(1);
        System.out.println(pelicula);
    }
}
