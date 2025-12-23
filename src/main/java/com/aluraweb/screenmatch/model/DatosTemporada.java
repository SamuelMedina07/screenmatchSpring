package com.aluraweb.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosTemporada(
        @JsonAlias("Season") Integer temporada,
        @JsonAlias("Episodes") List<DatosEpisodio> episodios
) {
    @Override
    public String toString() {
        return "\n Temporada: " + temporada +
                "\n Episodio: "+ episodios ;
    }
}
