package org.java.fotoalbum.controller.api;

import org.java.fotoalbum.pojo.Foto;
import org.springframework.validation.BindingResult;

public class FotoalbumResponseDto {

	private Foto foto;
	private BindingResult bindingResult;
	
	public FotoalbumResponseDto(Foto foto) {
		setFoto(foto);
	}
	
	public FotoalbumResponseDto(BindingResult bindingResult) {
		setBindingResult(bindingResult);
	}
	
	public FotoalbumResponseDto(Foto foto, BindingResult bindingResult) {
		setFoto(foto);
		setBindingResult(bindingResult);
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

	public void setBindingResult(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}
}
