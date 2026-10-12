package br.com.fateczl.tgbackend.dto;

import br.com.fateczl.tgbackend.model.Area;

public record ResultadoDTO(Long areaId, String nome, String descricao) {

    public ResultadoDTO(Area a) {
        this(a.getId(), a.getNome(), a.getDescricao());
    }
}