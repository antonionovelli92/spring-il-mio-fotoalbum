package org.java.fotoalbum.service;


import org.java.fotoalbum.pojo.Messaggio;

import org.java.fotoalbum.repo.MessaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessaggioService {

    @Autowired
    private MessaggioRepository messaggioRepo;

    public List<Messaggio> findAll() {
        return messaggioRepo.findAll();
    }

    public Messaggio save(Messaggio messaggio) {
        return messaggioRepo.save(messaggio);
    }

    public Optional<Messaggio> findById(int id) {
        return messaggioRepo.findById(id);
    }

    public void delete(Messaggio messaggio) {
        messaggioRepo.delete(messaggio);
    }
}
