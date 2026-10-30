package br.com.fateczl.tgbackend.dto;

import br.com.fateczl.tgbackend.model.Alternativa;

// Não expõe a área/pontuação da alternativa para o front
public record AlternativaDTO(Long id, String texto) {

    public AlternativaDTO(Alternativa a) {
        this(a.getId(), a.getTexto());
    }
}
