package br.com.fateczl.tgbackend.dto;

import br.com.fateczl.tgbackend.model.LivroVestibular;

public record LivroDTO(Long id, String titulo, String autor) {

    public LivroDTO(LivroVestibular l) {
        this(l.getId(), l.getTitulo(), l.getAutor());
    }
}

