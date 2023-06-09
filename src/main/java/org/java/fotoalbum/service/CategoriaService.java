package org.java.fotoalbum.service;



import org.java.fotoalbum.pojo.Categoria;
import org.java.fotoalbum.repo.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepo;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepo = categoriaRepository;
    }


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

    public List<Categoria> getCategorieByIds(List<Integer> categorieIds) {
        List<Categoria> categorie = new ArrayList<>();
        for (Integer id : categorieIds) {
            Optional<Categoria> categoriaOptional = categoriaRepo.findById(id);
            if (categoriaOptional.isPresent()) {
                categorie.add(categoriaOptional.get());
            }
        }
        return categorie;
    }

}