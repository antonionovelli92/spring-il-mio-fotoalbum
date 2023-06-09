package org.java.fotoalbum.repo;






import java.util.Optional;

import org.java.fotoalbum.pojo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	Optional<Categoria> findById(int id);
}