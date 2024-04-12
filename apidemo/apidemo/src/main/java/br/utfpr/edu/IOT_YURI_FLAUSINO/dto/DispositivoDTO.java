package br.utfpr.edu.IOT_YURI_FLAUSINO.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record DispositivoDTO(
        long idGateway,
        @NotBlank @Length(min = 2) String nome,
        @NotBlank @Length(min = 5) String descricao,
        String localizacao,
        String endereco) {

}
