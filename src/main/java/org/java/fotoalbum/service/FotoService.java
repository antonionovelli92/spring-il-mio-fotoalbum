package org.java.fotoalbum.service;



import org.java.fotoalbum.pojo.Foto;
import org.java.fotoalbum.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FotoService {
    private final FotoRepository fotoRepo;
    
    @Autowired
    public FotoService(FotoRepository fotoRepo) {
        this.fotoRepo = fotoRepo;
    }

    public List<Foto> findAll() {
        return fotoRepo.findAll();
    }

    public Foto save(Foto foto) {
        return fotoRepo.save(foto);
    }

    public Optional<Foto> findById(int id) {
        return fotoRepo.findById(id);
    }

//    public List<Foto> findByCategoria(String categoria) {
//        return fotoRepo.findByCategoriaNome(categoria);
//    }

    public void delete(Foto foto) {
        fotoRepo.delete(foto);
    }
}
