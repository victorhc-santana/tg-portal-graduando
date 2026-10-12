package br.com.fateczl.tgbackend.controller;

import br.com.fateczl.tgbackend.dto.PerguntaDTO;
import br.com.fateczl.tgbackend.dto.RespostaRequest;
import br.com.fateczl.tgbackend.dto.ResultadoDTO;
import br.com.fateczl.tgbackend.service.TesteVocService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TesteVocController {

    private final TesteVocService testeService;

    @GetMapping("/perguntas")
    public List<PerguntaDTO> perguntas() {
        return testeService.listarPerguntas().stream()
                .map(PerguntaDTO::new)
                .toList();
    }

    @PostMapping("/resultado")
    public ResultadoDTO resultado(@RequestBody RespostaRequest request) {
        if (request.alternativaIds() == null || request.alternativaIds().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nenhuma resposta enviada");
        }

        return testeService.calcularResultado(request.alternativaIds())
                .map(ResultadoDTO::new)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Não foi possível calcular o resultado"));
    }
}

