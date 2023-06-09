package org.java.fotoalbum.controller.api;

import org.java.fotoalbum.pojo.Foto;
import org.java.fotoalbum.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class FotoalbumApiController {
	
	@Autowired
	private FotoService fotoService;
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello(){
		return new ResponseEntity<>("Ciao", HttpStatus.OK);
	}
	
	@GetMapping("/foto")
	public ResponseEntity<List<Foto>> getAllFoto(){
		List<Foto> fotoList = fotoService.findAll();
		return new ResponseEntity<>(fotoList, HttpStatus.OK);
	}
	
	@GetMapping("/foto/{id}")
	public ResponseEntity<Foto> getFotoById(@PathVariable("id") int id){
		Optional<Foto> optFoto = fotoService.findById(id);
		
		if (optFoto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Foto foto = optFoto.get();
		return new ResponseEntity<>(foto, HttpStatus.OK);
	}
	
	@PostMapping("/foto")
	public ResponseEntity<Foto> createFoto(@RequestBody Foto foto){
		foto = fotoService.save(foto);
		return new ResponseEntity<>(foto, HttpStatus.CREATED);
	}
	
	@PutMapping("/foto/{id}")
	public ResponseEntity<Foto> updateFoto(@PathVariable("id") int id, @RequestBody Foto foto){
		Optional<Foto> optFoto = fotoService.findById(id);
		
		if (optFoto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Foto existingFoto = optFoto.get();
		existingFoto.setTitolo(foto.getTitolo());
		existingFoto.setDescrizione(foto.getDescrizione());
		existingFoto.setUrl(foto.getUrl());
		existingFoto.setVisibile(foto.isVisibile());
		existingFoto.setCategorie(foto.getCategorie());
		
		foto = fotoService.save(existingFoto);
		return new ResponseEntity<>(foto, HttpStatus.OK);
	}
	
	@DeleteMapping("/foto/{id}")
	public ResponseEntity<Void> deleteFoto(@PathVariable("id") int id){
		Optional<Foto> optFoto = fotoService.findById(id);
		
		if (optFoto.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Foto foto = optFoto.get();
		fotoService.delete(foto);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
