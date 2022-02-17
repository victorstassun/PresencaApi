package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AlunoInputDTO {
    private long matricula;

    private String nome;

    private int cpf;
}