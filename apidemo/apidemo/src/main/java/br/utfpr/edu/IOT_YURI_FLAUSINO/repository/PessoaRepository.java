package br.utfpr.edu.IOT_YURI_FLAUSINO.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.utfpr.edu.IOT_YURI_FLAUSINO.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
