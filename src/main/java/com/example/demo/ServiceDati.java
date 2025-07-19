package com.example.demo;

import kotlin.jvm.internal.SerializedIr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDati
{
    public static DatiRepository datiRepository;



    @Autowired
    public ServiceDati(DatiRepository datiRepository) {
        this.datiRepository = datiRepository;
    }

    public void deleteById(Integer id) {
        datiRepository.deleteById(id);
    }
    public Iterable<Dati> findAll() {
        return datiRepository.findAll();
    }
    public Iterable<Dati> findAllByNomeContainingIgnoreCase(String nome) {
        return datiRepository.findAllByNomeContainingIgnoreCase(nome);
    }
    public Dati findById(Integer id) {
        return datiRepository.findById(id).orElse(null);
    }
    public Dati save(Dati dati) {
        return datiRepository.save(dati);
    }
    public void delete(Dati dati) {
        datiRepository.delete(dati);
    }
}
