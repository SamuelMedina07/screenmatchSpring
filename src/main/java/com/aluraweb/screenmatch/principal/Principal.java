package com.aluraweb.screenmatch.principal;

import com.aluraweb.screenmatch.model.DatosSerie;
import com.aluraweb.screenmatch.model.DatosTemporada;
import com.aluraweb.screenmatch.service.ConsumoAPI;
import com.aluraweb.screenmatch.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private String nombreSerie;
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=2b83c21c";
    private ConvierteDatos conversor = new ConvierteDatos();
    private Integer continuar;
    private Integer cantidadDeTemporadas;



    public void menu(){
        System.out.println("Por favor escriba el nombre de la serie que desea informacion:");
        nombreSerie = tratandoNombreSerie(teclado.nextLine());
        var json = consumoApi.obtenerDatos(URL_BASE+nombreSerie+API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        this.cantidadDeTemporadas = datos.totalDeTemporadas();
        
        System.out.println(datos);

        menuOpcionalInformacion();



    }

    public void menuOpcionalInformacion(){
        System.out.println("Desea ver la informacion de cada temporada?\n Si..:0 \n No..:1");
        continuar = teclado.nextInt();
        if (continuar == 0) {
            mostrarDatosTemporadaConEpisodios();
        } else {
            System.out.println("Saliendo del programa...");
            return;
        }

    }

    public void mostrarDatosTemporadaConEpisodios(){
        List<DatosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= cantidadDeTemporadas; i++) {
            var json3 = consumoApi.obtenerDatos(URL_BASE+nombreSerie+"&Season="+i+API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json3, DatosTemporada.class);
            temporadas.add(datosTemporadas);
        }
        temporadas.forEach(System.out::println);

    }
    public String tratandoNombreSerie(String nombre){
       return nombre.replace(" ","+");
    }

}
