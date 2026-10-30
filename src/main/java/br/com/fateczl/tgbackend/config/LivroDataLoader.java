package br.com.fateczl.tgbackend.config;

import br.com.fateczl.tgbackend.model.Vestibular;
import br.com.fateczl.tgbackend.repository.VestibularRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/** Popula as leituras obrigatórias (Fuvest e Unicamp 2027) na primeira execução. */
@Component
@RequiredArgsConstructor
public class LivroDataLoader implements CommandLineRunner {

    private final VestibularRepository vestibularRepository;

    @Override
    public void run(String... args) {
        if (vestibularRepository.count() > 0) return;

        Vestibular fuvest = new Vestibular("Fuvest", 2027);
        fuvest.addLivro("Opúsculo Humanitário", "Nísia Floresta");
        fuvest.addLivro("Nebulosas", "Narcisa Amália");
        fuvest.addLivro("Memórias de Martha", "Julia Lopes de Almeida");
        fuvest.addLivro("Caminho de Pedras", "Rachel de Queiroz");
        fuvest.addLivro("A Paixão Segundo G.H.", "Clarice Lispector");
        fuvest.addLivro("Geografia", "Sophia de Mello Breyner Andresen");
        fuvest.addLivro("Balada de Amor ao Vento", "Paulina Chiziane");
        fuvest.addLivro("Canção para Ninar Menino Grande", "Conceição Evaristo");
        fuvest.addLivro("A Visão das Plantas", "Djaimilia Pereira de Almeida");
        vestibularRepository.save(fuvest);

        Vestibular unicamp = new Vestibular("Unicamp", 2027);
        unicamp.addLivro("A vida não é útil", "Ailton Krenak");
        unicamp.addLivro("Prosas seguidas de Odes mínimas", "José Paulo Paes");
        unicamp.addLivro("Morangos mofados (contos escolhidos)", "Caio Fernando Abreu");
        unicamp.addLivro("Vida e morte de M. J. Gonzaga de Sá", "Lima Barreto");
        unicamp.addLivro("No seu pescoço", "Chimamanda Ngozi Adichie");
        unicamp.addLivro("Olhos d'água", "Conceição Evaristo");
        unicamp.addLivro("Memórias Póstumas de Brás Cubas", "Machado de Assis");
        unicamp.addLivro("Canções escolhidas", "Paulo César Pinheiro");
        unicamp.addLivro("Os funerais da Mamãe Grande", "Gabriel García Márquez");
        vestibularRepository.save(unicamp);
    }
}