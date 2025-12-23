package com.aluraweb.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio(
        @JsonAlias("Title") String titulo,
       @JsonAlias("Episode") Integer numeroEpisodio,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Released") String fechaDeLanzamiento
) {
    @Override
    public String toString() {
        return "\n Titulo: " + titulo+
                "\n Numero Episodio: " + numeroEpisodio+
                "\n Evaluacion: " + evaluacion +
                "\n Fecha de Lanzamiento: " + fechaDeLanzamiento;
    }
}
