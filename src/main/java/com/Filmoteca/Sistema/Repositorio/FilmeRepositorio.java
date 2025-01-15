package com.Filmoteca.Sistema.Repositorio;

import com.Filmoteca.Sistema.Modelo.filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepositorio extends JpaRepository<filme, Long> {
}