package br.com.fateczl.tgbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String texto;

    @OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Alternativa> alternativas = new ArrayList<>();

    public Pergunta(String texto) {
        this.texto = texto;
    }

    public void addAlternativa(String texto, Area area) {
        Alternativa a = new Alternativa(texto, this, area);
        alternativas.add(a);
    }
}

