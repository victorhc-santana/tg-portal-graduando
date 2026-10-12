package br.com.fateczl.tgbackend.config;

import br.com.fateczl.tgbackend.model.Area;
import br.com.fateczl.tgbackend.model.Pergunta;
import br.com.fateczl.tgbackend.repository.AreaRepository;
import br.com.fateczl.tgbackend.repository.PerguntaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** Popula o banco com perguntas de exemplo na primeira execução. */
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final PerguntaRepository perguntaRepository;

    @Override
    public void run(String... args) {
        if (areaRepository.count() > 0) return;

        Area tec = areaRepository.save(new Area("Tecnologia",
                "Você gosta de lógica, resolver problemas e criar soluções."));
        Area saude = areaRepository.save(new Area("Saúde",
                "Você se importa com o bem-estar e o cuidado com as pessoas."));
        Area humanas = areaRepository.save(new Area("Humanas",
                "Você gosta de comunicação, ensino e entender a sociedade."));

        Pergunta p1 = new Pergunta("O que você prefere fazer no tempo livre?");
        p1.addAlternativa("Montar ou programar algo", tec);
        p1.addAlternativa("Ajudar alguém com um problema pessoal", saude);
        p1.addAlternativa("Ler, escrever ou debater ideias", humanas);
        perguntaRepository.save(p1);

        Pergunta p2 = new Pergunta("Qual desses desafios mais te atrai?");
        p2.addAlternativa("Descobrir por que um sistema não funciona", tec);
        p2.addAlternativa("Cuidar de alguém que não está bem", saude);
        p2.addAlternativa("Explicar um assunto difícil para outras pessoas", humanas);
        perguntaRepository.save(p2);

        Pergunta p3 = new Pergunta("Em um trabalho em grupo, você costuma:");
        p3.addAlternativa("Organizar a parte técnica", tec);
        p3.addAlternativa("Garantir que todos estejam bem e participando", saude);
        p3.addAlternativa("Apresentar e comunicar o resultado", humanas);
        perguntaRepository.save(p3);
    }
}

