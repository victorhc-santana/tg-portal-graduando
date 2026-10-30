package br.com.fateczl.tgbackend.dto;

import br.com.fateczl.tgbackend.model.Pergunta;

import java.util.List;

public record PerguntaDTO(Long id, String texto, List<AlternativaDTO> alternativas) {

    public PerguntaDTO(Pergunta p) {
        this(p.getId(), p.getTexto(),
                p.getAlternativas().stream().map(AlternativaDTO::new).toList());
    }
}
