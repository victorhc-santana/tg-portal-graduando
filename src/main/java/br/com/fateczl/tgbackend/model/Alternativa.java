package br.com.fateczl.tgbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Alternativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta;

    // Área que recebe 1 ponto quando esta alternativa é escolhida
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    public Alternativa(String texto, Pergunta pergunta, Area area) {
        this.texto = texto;
        this.pergunta = pergunta;
        this.area = area;
    }
}

