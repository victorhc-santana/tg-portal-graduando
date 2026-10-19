package br.com.fateczl.tgbackend.controller;

import br.com.fateczl.tgbackend.dto.VestibularDTO;
import br.com.fateczl.tgbackend.service.VestibularService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VestibularLivroController {

    private final VestibularService vestibularService;

    // Cada vestibular já vem com a sua lista de obras obrigatórias
    @GetMapping("/vestibulares")
    public List<VestibularDTO> vestibulares() {
        return vestibularService.listar().stream()
                .map(VestibularDTO::new)
                .toList();
    }
}