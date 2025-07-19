package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DatiRepository extends JpaRepository<Dati, Integer>
{
    @Override
    default List<Dati> findAllById(Iterable<Integer> integers) {
        return List.of();
    }
    List<Dati> findAllByNomeContainingIgnoreCase(String nome);

    List<Dati> findAllByCognomeContainingIgnoreCase(String cognome);
}
