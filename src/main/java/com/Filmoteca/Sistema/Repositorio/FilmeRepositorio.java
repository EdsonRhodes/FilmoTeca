package com.Filmoteca.Sistema.Repositorio;


import com.Filmoteca.Sistema.Modelo.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepositorio extends JpaRepository <Filme, Long> {

}
