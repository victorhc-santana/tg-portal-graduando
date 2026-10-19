package br.com.fateczl.tgbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Vestibular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer ano;

    @OneToMany(mappedBy = "vestibular", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("id")
    private List<LivroVestibular> livros = new ArrayList<>();

    public Vestibular(String nome, Integer ano) {
        this.nome = nome;
        this.ano = ano;
    }

    public void addLivro(String titulo, String autor) {
        livros.add(new LivroVestibular(titulo, autor, this));
    }
}
