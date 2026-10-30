package br.com.fateczl.tgbackend.controller;

import br.com.fateczl.tgbackend.dto.QuestionarioRequest;
import br.com.fateczl.tgbackend.model.Feedback;
import br.com.fateczl.tgbackend.repository.RespostaQuestionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/questionario")
@RequiredArgsConstructor
public class QuestionarioController {

    private final RespostaQuestionarioRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void enviar(@RequestBody QuestionarioRequest r) {
        if (r.perfil() == null || r.jaFezTeste() == null
                || !nota(r.utilidade()) || !nota(r.interesse())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Preencha as perguntas obrigatórias");
        }

        Feedback resp = new Feedback();
        resp.setPerfil(r.perfil());
        resp.setJaFezTeste(r.jaFezTeste());
        resp.setUtilidade(r.utilidade());
        resp.setInteresse(r.interesse());
        resp.setRecursos(r.recursos() == null ? "" : String.join(", ", r.recursos()));
        resp.setVestibulares(r.vestibulares() == null ? "" : String.join(", ", r.vestibulares()));

        String s = r.sugestoes() == null ? "" : r.sugestoes().trim();
        resp.setSugestoes(s.length() > 2000 ? s.substring(0, 2000) : s);

        repository.save(resp);
    }

    // Para você ver as respostas coletadas: http://localhost:8080/api/questionario
    @GetMapping
    public List<Feedback> listar() {
        return repository.findAll();
    }

    private boolean nota(Integer n) {
        return n != null && n >= 1 && n <= 5;
    }
}
