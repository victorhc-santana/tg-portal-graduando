package br.com.fateczl.tgbackend.repository;

import br.com.fateczl.tgbackend.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
}
