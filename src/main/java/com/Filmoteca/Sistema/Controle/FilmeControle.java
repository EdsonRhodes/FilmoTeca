package com.Filmoteca.Sistema.Controle;

import com.Filmoteca.Sistema.Modelo.Filme;
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

    // Exibe o formulário para cadastrar um novo filme
    @GetMapping("/novo")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("filme", new Filme()); // Adiciona um objeto Filme vazio ao modelo
        return "filmes/novo"; // Retorna o nome do template
    }

    // Processa o formulário e salva o filme no banco de dados
    @PostMapping("/salvar")
    public String salvarFilme(@ModelAttribute Filme filme) {
        filmeServico.salvarFilme(filme);  // Chama o serviço para salvar o filme
        return "redirect:/filmes/novo";   // Redireciona de volta para o formulário para cadastrar outro filme
    }
}
