package com.Filmoteca.Sistema.Controle;

import com.Filmoteca.Sistema.Modelo.filme;
import com.Filmoteca.Sistema.Servico.FilmeServico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/filmes")
public class FilmeControle {

    private final FilmeServico filmeServico;

    // Construtor para injeção de dependência
    public FilmeControle(FilmeServico filmeServico) {
        this.filmeServico = filmeServico;
    }

    // Exibir o formulário para adicionar um novo filme
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("filme", new filme());
        return "filmes/salvar";  // Nome do arquivo HTML
    }

    // Método para salvar o filme
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute filme filme) {
        // Chamar o serviço para salvar o filme
        filmeServico.salvarFilme(filme);

        // Redirecionar para a página do formulário após salvar
        return "redirect:/filmes/novo";
    }
}