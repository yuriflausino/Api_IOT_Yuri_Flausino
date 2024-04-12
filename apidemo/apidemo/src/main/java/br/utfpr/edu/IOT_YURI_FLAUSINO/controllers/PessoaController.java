package br.utfpr.edu.IOT_YURI_FLAUSINO.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.utfpr.edu.IOT_YURI_FLAUSINO.dto.PessoaDTO;
import br.utfpr.edu.IOT_YURI_FLAUSINO.exception.NotFoundException;
import br.utfpr.edu.IOT_YURI_FLAUSINO.model.Pessoa;
import br.utfpr.edu.IOT_YURI_FLAUSINO.services.PessoaService;

@RestController
@RequestMapping("/pessoa")

public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody PessoaDTO dto) {
        try {
            var res = pessoaService.create(dto);
            // Seta os status para 201 (created) e devovolve o objeto Pessoa em Json
            return ResponseEntity.status(HttpStatus.CREATED).body(res);

        } catch (Exception ex) {
            // Seta os status para 400 (bad request) e devolve a mensagem da excecao lancada

            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @GetMapping
    public List<Pessoa> getall() {
        return pessoaService.getall();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") long id) {
        var person = pessoaService.getById(id);

        return person.isPresent()
                ? ResponseEntity.ok().body(person.get())
                : ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id,
            @RequestBody PessoaDTO dto) {
        try {
            return ResponseEntity.ok().body(pessoaService.update(id, dto));
        } catch (NotFoundException ex) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long id) {
        try {
            pessoaService.delete(id);
            return ResponseEntity.ok().build();
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
