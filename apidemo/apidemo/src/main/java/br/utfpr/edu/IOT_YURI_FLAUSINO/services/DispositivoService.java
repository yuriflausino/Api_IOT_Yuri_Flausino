// package br.utfpr.edu.IOT_YURI_FLAUSINO.services;

// import org.springframework.beans.BeanUtils;
// import org.springframework.beans.factory.annotation.Autowired;

// import br.utfpr.edu.IOT_YURI_FLAUSINO.dto.DispositivoDTO;
// import br.utfpr.edu.IOT_YURI_FLAUSINO.dto.PessoaDTO;
// import br.utfpr.edu.IOT_YURI_FLAUSINO.model.Dispositivo;
// import br.utfpr.edu.IOT_YURI_FLAUSINO.model.Pessoa;

// public class DispositivoService {
// @Autowired
// private DispositivoRepository dispositivorepository;

// public Dispositivo create(DispositivoDTO dto) {
// var dispositivo = new Dispositivo();
// BeanUtils.copyProperties(dto, dispositivo);

// return dispositivorepository.save(dispositivo);
// }

// }
