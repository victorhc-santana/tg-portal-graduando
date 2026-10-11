package br.com.fateczl.tgbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "livros_vestibular")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LivroVestibular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 100)
    private String autor;

    @Column(nullable = false, length = 50)
    private String vestibular; // Ex: FUVEST 2027, UNICAMP

    private Integer anoPublicacao;
}