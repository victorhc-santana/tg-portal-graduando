package br.com.fateczl.tgbackend.dto;

import br.com.fateczl.tgbackend.model.Vestibular;

import java.util.List;

public record VestibularDTO(Long id, String nome, Integer ano, List<LivroDTO> livros) {

    public VestibularDTO(Vestibular v) {
        this(v.getId(), v.getNome(), v.getAno(),
                v.getLivros().stream().map(LivroDTO::new).toList());
    }
}
