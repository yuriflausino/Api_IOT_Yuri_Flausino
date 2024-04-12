package br.utfpr.edu.IOT_YURI_FLAUSINO.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.utfpr.edu.IOT_YURI_FLAUSINO.dto.PessoaDTO;
import br.utfpr.edu.IOT_YURI_FLAUSINO.exception.NotFoundException;
import br.utfpr.edu.IOT_YURI_FLAUSINO.model.Pessoa;
import br.utfpr.edu.IOT_YURI_FLAUSINO.repository.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoarepository;

    public Pessoa create(PessoaDTO dto) {
        var pessoa = new Pessoa();
        BeanUtils.copyProperties(dto, pessoa);

        return pessoarepository.save(pessoa);
    }

    public List<Pessoa> getall() {
        return pessoarepository.findAll();
    }

    public Optional<Pessoa> getById(long id) {
        return pessoarepository.findById(id);
    }

    public Pessoa update(long id, PessoaDTO dto) throws NotFoundException {
        var res = pessoarepository.findById(id);

        if (res.isEmpty()) {
            throw new NotFoundException("Pessoa" + id + "Nao existe");
        }
        var pessoa = res.get();
        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());

        return pessoarepository.save(pessoa);
    }

    public void delete(long id) throws NotFoundException {
        var res = pessoarepository.findById(id);

        if (res.isEmpty()) {
            throw new NotFoundException("Pessoa" + id + "Nao existe");
        }
        pessoarepository.delete(res.get());
    }

}
