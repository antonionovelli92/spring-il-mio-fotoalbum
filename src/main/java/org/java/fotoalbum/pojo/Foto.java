package org.java.fotoalbum.pojo;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Foto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Please, insert a title.")
    private String titolo;

    @NotBlank(message = "Please, insert a description.")
    private String descrizione;

    @NotBlank(message = "Please, insert a url.")
    private String url;

    private boolean visibile;

    @ManyToMany
    @JsonIgnore
    private List<Categoria> categorie;

    
    public Foto() {}
    public Foto(String titolo, String descrizione, String url, boolean visibile) {
        setTitolo(titolo);
        setDescrizione(descrizione);
        setUrl(url);
        setVisibile(visibile);
        
    }
    public Foto(String titolo, String descrizione, String url, boolean visibile, Categoria... categorie) {
		this(titolo, descrizione, url, visibile);
		setCategorie(categorie);
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isVisibile() {
		return visibile;
	}

	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}

	public List<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}
	public void setCategorie(Categoria[] categorie) {
		setCategorie(Arrays.asList(categorie));
	}
	public void removeCategorie(Categoria categoria) {
		getCategorie().remove(categoria);	
		categoria.getFotos().remove(this);
	}

    public void addCategoria(Categoria categoria) {
        categorie.add(categoria);
        categoria.getFotos().add(this);
    }

}