package org.java.fotoalbum.service;



import org.java.fotoalbum.pojo.Categoria;
import org.java.fotoalbum.repo.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepo;

    public List<Categoria> findAll() {
        return categoriaRepo.findAll();
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepo.save(categoria);
    }

    public Optional<Categoria> findById(int id) {
        return categoriaRepo.findById(id);
    }

    public void delete(Categoria categoria) {
        categoriaRepo.delete(categoria);
    }
}