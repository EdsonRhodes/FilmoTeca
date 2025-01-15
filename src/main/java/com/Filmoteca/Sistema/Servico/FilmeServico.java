package com.Filmoteca.Sistema.Servico;

import com.Filmoteca.Sistema.Modelo.filme;
import com.Filmoteca.Sistema.Repositorio.FilmeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeServico {

    @Autowired
    private FilmeRepositorio filmeRepositorio;

    public void salvarFilme(filme filme) {
        filmeRepositorio.save(filme);
        System.out.println("Filme cadastrado: " + filme);
    }
}
