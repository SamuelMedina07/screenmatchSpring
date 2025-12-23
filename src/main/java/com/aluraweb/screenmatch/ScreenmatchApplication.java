package com.aluraweb.screenmatch;

import com.aluraweb.screenmatch.model.DatosEpisodio;
import com.aluraweb.screenmatch.model.DatosSerie;
import com.aluraweb.screenmatch.model.DatosTemporada;
import com.aluraweb.screenmatch.service.ConsumoAPI;
import com.aluraweb.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
       // System.out.println("Hola Mundo desde Spring");
        var consumoAPi = new ConsumoAPI();
        var json = consumoAPi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=2b83c21c");
        System.out.println(json);
        ConvierteDatos conversor = new ConvierteDatos();
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        var json2 = consumoAPi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=2b83c21c");
        var datos2 = conversor.obtenerDatos(json2, DatosEpisodio.class);
        System.out.println(datos2);

        List<DatosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i < datos.totalDeTemporadas(); i++) {
            var json3 = consumoAPi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season="+i+"&apikey=2b83c21c");
            var datosTemporadas = conversor.obtenerDatos(json3, DatosTemporada.class);
            temporadas.add(datosTemporadas);
        }
        temporadas.forEach(System.out::println);
    }
}
