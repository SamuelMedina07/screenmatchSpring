package com.aluraweb.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//ponemos esta linea para ignorar campos del json que no queremos ejemplo Year
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(

        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalDeTemporadas,
        @JsonAlias("imdbRating") String evaluacion

) {
    @Override
    public String toString() {
        return "\n Serie: " + titulo +
                "\n Total de Temporadas: "+ totalDeTemporadas+
                "\n Evaluacion: " + evaluacion;
    }
}
