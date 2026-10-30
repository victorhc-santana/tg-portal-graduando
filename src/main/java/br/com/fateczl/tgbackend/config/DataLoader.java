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

        Area exatas = areaRepository.save(new Area("Tecnologia",
                "Você gosta de lógica, resolver problemas e criar soluções."));
        Area saude = areaRepository.save(new Area("Saúde",
                "Você se importa com o bem-estar e o cuidado com as pessoas."));
        Area humanas = areaRepository.save(new Area("Humanas",
                "Você gosta de comunicação, ensino e entender a sociedade."));

        Pergunta p1 = new Pergunta("O que você prefere fazer no tempo livre?");
        p1.addAlternativa("Montar ou programar algo", exatas);
        p1.addAlternativa("Ajudar alguém com um problema pessoal", saude);
        p1.addAlternativa("Ler, escrever ou debater ideias", humanas);
        perguntaRepository.save(p1);

        Pergunta p2 = new Pergunta("Qual desses desafios mais te atrai?");
        p2.addAlternativa("Descobrir por que um sistema não funciona", exatas);
        p2.addAlternativa("Cuidar de alguém que não está bem", saude);
        p2.addAlternativa("Explicar um assunto difícil para outras pessoas", humanas);
        perguntaRepository.save(p2);

        Pergunta p3 = new Pergunta("Em um trabalho em grupo, você costuma:");
        p3.addAlternativa("Organizar a parte técnica", exatas);
        p3.addAlternativa("Garantir que todos estejam bem e participando", saude);
        p3.addAlternativa("Apresentar e comunicar o resultado", humanas);
        perguntaRepository.save(p3);
        
        Pergunta p4 = new Pergunta("Qual ferramenta ou recurso você mais gosta de utilizar em seus estudos?");
        p4.addAlternativa("Softwares de programação, planilhas ou fórmulas matemáticas", exatas);
        p4.addAlternativa("Livros de história, artigos de opinião ou ferramentas de escrita", humanas);
        p4.addAlternativa("Microscópios, guias de campo ou relatórios de preservação", saude);
        perguntaRepository.save(p4);
        
        Pergunta p5 = new Pergunta("Se pudesse escolher um tema para uma palestra, qual seria?");
        p5.addAlternativa("Inovação tecnológica e desenvolvimento de software", exatas);
        p5.addAlternativa("Impacto social, psicologia comportamental ou educação", humanas);
        p5.addAlternativa("Promoção da saúde física e mental, medicina preventiva ou qualidade de vida", saude);
        perguntaRepository.save(p5);

        Pergunta p6 = new Pergunta("Qual tipo de problema você prefere resolver para exercitar o raciocínio?");
        p6.addAlternativa("Enigmas lógicos, cálculos complexos ou bugs de código", exatas);
        p6.addAlternativa("Dilemas éticos, interpretação de textos ou mediação de conflitos", humanas);
        p6.addAlternativa("Investigação sobre sintomas, diagnósticos ou reabilitação de pacientes", saude);
        perguntaRepository.save(p6);

        Pergunta p7 = new Pergunta("Ao planejar um projeto de longo prazo, qual sua maior preocupação?");
        p7.addAlternativa("A arquitetura técnica, escalabilidade e otimização dos recursos", exatas);
        p7.addAlternativa("O impacto na comunidade, engajamento e experiência das pessoas", humanas);
        p7.addAlternativa("O impacto na qualidade de vida, segurança e bem-estar do público", saude);
        perguntaRepository.save(p7);

        Pergunta p8 = new Pergunta("Qual tipo de leitura ou conteúdo você consome com mais frequência por curiosidade?");
        p8.addAlternativa("Artigos sobre novas tecnologias, inteligência artificial e engenharia", exatas);
        p8.addAlternativa("Livros de filosofia, sociologia, história ou psicologia", humanas);
        p8.addAlternativa("Reportagens sobre avanços na medicina, tratamentos e saúde integrativa", saude);
        perguntaRepository.save(p8);

        Pergunta p9 = new Pergunta("Como você prefere medir o sucesso de um projeto que realizou?");
        p9.addAlternativa("Pela eficiência do sistema construído e ausência de falhas técnicas", exatas);
        p9.addAlternativa("Pela transformação positiva gerada na vida das pessoas envolvidas", humanas);
        p9.addAlternativa("Pelo alívio do sofrimento ou melhora na saúde de quem foi auxiliado", saude);
        perguntaRepository.save(p9);

        Pergunta p10 = new Pergunta("Qual ambiente de trabalho profissional mais combina com seu estilo?");
        p10.addAlternativa("Uma empresa de tecnologia focada em inovação e desenvolvimento ágil", exatas);
        p10.addAlternativa("Uma instituição de ensino, ONG ou empresa com foco em cultura e pessoas", humanas);
        p10.addAlternativa("Um hospital, clínica, laboratório de exames ou centro de reabilitação", saude);
        perguntaRepository.save(p10);

        Pergunta p11 = new Pergunta("O que mais te atrai em uma nova descoberta científica ou tecnológica?");
        p11.addAlternativa("A capacidade de automatizar tarefas e criar soluções computacionais", exatas);
        p11.addAlternativa("Como ela muda a forma como a sociedade interage e se organiza", humanas);
        p11.addAlternativa("Como ela pode curar doenças, salvar vidas ou melhorar tratamentos médicos", saude);
        perguntaRepository.save(p11);

        Pergunta p12 = new Pergunta("Qual habilidade você considera mais gratificante desenvolver?");
        p12.addAlternativa("Aprender uma nova linguagem de programação ou ferramenta analítica", exatas);
        p12.addAlternativa("Aprimorar a escuta ativa, oratória ou escrita persuasiva", humanas);
        p12.addAlternativa("Compreender cuidados clínicos, anatomia humana ou técnicas de primeiros socorros", saude);
        perguntaRepository.save(p12);
    }
}

