package br.com.fateczl.tgbackend.dto;

import java.util.List;

// Corpo do POST: { "alternativaIds": [1, 5, 9] }
public record RespostaRequest(List<Long> alternativaIds) {
}