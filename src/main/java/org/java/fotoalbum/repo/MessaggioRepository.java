package org.java.fotoalbum.repo;


import org.java.fotoalbum.pojo.Messaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessaggioRepository extends JpaRepository<Messaggio, Integer> {


	
	
}