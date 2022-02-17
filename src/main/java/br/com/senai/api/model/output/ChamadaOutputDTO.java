package br.com.senai.api.model.output;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ChamadaOutputDTO {
    private String nome;

    private boolean presenca;

    private LocalDateTime data_hora;
}