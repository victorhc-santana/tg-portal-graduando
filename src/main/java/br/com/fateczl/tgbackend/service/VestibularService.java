package br.com.fateczl.tgbackend.service;

import br.com.fateczl.tgbackend.model.Vestibular;
import br.com.fateczl.tgbackend.repository.VestibularRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VestibularService {

    private final VestibularRepository vestibularRepository;

    public List<Vestibular> listar() {
        return vestibularRepository.findAll();
    }
}

