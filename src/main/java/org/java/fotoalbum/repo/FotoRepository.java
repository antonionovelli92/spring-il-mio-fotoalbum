package org.java.fotoalbum.repo;



import java.util.List;

//import java.util.List;


import org.java.fotoalbum.pojo.Foto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FotoRepository extends JpaRepository<Foto, Integer> {
	

	public List<Foto> findByTitoloContaining(String titolo);
}