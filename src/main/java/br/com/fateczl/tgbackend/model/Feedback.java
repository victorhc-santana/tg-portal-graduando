package br.com.fateczl.tgbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String perfil;
    private String jaFezTeste;
    private Integer utilidade;   // 1 a 5
    private Integer interesse;   // 1 a 5

    @Column(length = 500)
    private String recursos;

    @Column(length = 200)
    private String vestibulares;

    @Column(length = 2000)
    private String sugestoes;

    private LocalDateTime criadoEm = LocalDateTime.now();
}
