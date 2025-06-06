package com.cecilialopez.swapidatafetcher.main;

import com.cecilialopez.swapidatafetcher.services.ConsultaPelicula;
import com.cecilialopez.swapidatafetcher.models.Pelicula;
import com.cecilialopez.swapidatafetcher.utils.GeneradorDeArchivo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el número de la película de Star Wars que quiere consultar: ");
        ConsultaPelicula consulta = new ConsultaPelicula();
        try {
            var numeroDePelicula = Integer.valueOf(scanner.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        } catch (NumberFormatException e) {
            System.out.println("Número no encontrado. " + e.getMessage());
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación.");
        }
    }
}
