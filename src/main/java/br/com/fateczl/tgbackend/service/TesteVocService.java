package br.com.fateczl.tgbackend.service;

import br.com.fateczl.tgbackend.model.Alternativa;
import br.com.fateczl.tgbackend.model.Area;
import br.com.fateczl.tgbackend.model.Pergunta;
import br.com.fateczl.tgbackend.repository.AlternativaRepository;
import br.com.fateczl.tgbackend.repository.PerguntaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TesteVocService {

    private final PerguntaRepository perguntaRepository;
    private final AlternativaRepository alternativaRepository;

    public List<Pergunta> listarPerguntas() {
        return perguntaRepository.findAll();
    }

    /** Recebe os ids das alternativas escolhidas e devolve a área com mais pontos. */
    public Optional<Area> calcularResultado(List<Long> alternativaIds) {
        Map<Area, Integer> pontos = new HashMap<>();

        for (Alternativa alt : alternativaRepository.findAllById(alternativaIds)) {
            pontos.merge(alt.getArea(), 1, Integer::sum);
        }

        return pontos.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}