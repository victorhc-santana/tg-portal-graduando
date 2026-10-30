package br.com.fateczl.tgbackend.repository;

import br.com.fateczl.tgbackend.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaQuestionarioRepository extends JpaRepository<Feedback, Long> {
}
