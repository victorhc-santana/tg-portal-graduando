package br.com.fateczl.tgbackend.dto;

import java.util.List;

public record QuestionarioRequest(
        String perfil,
        String jaFezTeste,
        Integer utilidade,
        Integer interesse,
        List<String> recursos,
        List<String> vestibulares,
        String sugestoes) {
}
