package com.Filmoteca.Sistema.Servico;


import com.Filmoteca.Sistema.Modelo.Filme;
import com.Filmoteca.Sistema.Repositorio.FilmeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeServico {

    @Autowired
    private FilmeRepositorio filmeRepositorio;

    public void salvarFilme(Filme filme) {
        filmeRepositorio.save(filme);
    }
}

