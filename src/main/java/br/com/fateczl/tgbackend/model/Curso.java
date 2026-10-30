package br.com.fateczl.tgbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 50)
    private String area; // Ex: Exatas, Biológicas, Humanas

    @Column(columnDefinition = "TEXT")
    private String descricao;
}
