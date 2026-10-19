package br.com.fateczl.tgbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class LivroVestibular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String titulo;

    private String autor;

    @ManyToOne
    @JoinColumn(name = "vestibular_id")
    private Vestibular vestibular;

    public LivroVestibular(String titulo, String autor, Vestibular vestibular) {
        this.titulo = titulo;
        this.autor = autor;
        this.vestibular = vestibular;
    }
}