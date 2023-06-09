package org.java.fotoalbum.app;



import org.java.fotoalbum.pojo.Categoria;
import org.java.fotoalbum.pojo.Foto;
import org.java.fotoalbum.pojo.Messaggio;
import org.java.fotoalbum.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FotoalbumApplication implements CommandLineRunner {

    @Autowired
    private FotoService fotoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private MessaggioService messaggioService;

    public static void main(String[] args) {
        SpringApplication.run(FotoalbumApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Creazione di categorie
        Categoria c1 = new Categoria("Natura");
        Categoria c2 = new Categoria("Viaggi");
        Categoria c3 = new Categoria("Cibo");

        categoriaService.save(c1);
        categoriaService.save(c2);
        categoriaService.save(c3);

        // Creazione di foto
        Foto foto1 = new Foto("Tramonto", "Bellissimo tramonto sulla spiaggia", "https://example.com/foto/tramonto.jpg", true, c1);
        Foto foto2 = new Foto("Montagne", "Panorama mozzafiato sulle montagne", "https://example.com/foto/montagne.jpg", true, c2);
        Foto foto3 = new Foto("Pizza", "Deliziosa pizza margherita", "https://example.com/foto/pizza.jpg", true, c3);

       

        fotoService.save(foto1);
        fotoService.save(foto2);
        fotoService.save(foto3);

        // Creazione di messaggi
        Messaggio m1 = new Messaggio("email1@example.com", "Ciao, ho apprezzato le tue foto!");
        Messaggio m2 = new Messaggio("email2@example.com", "Complimenti per i tuoi viaggi, sembrano fantastici!");

        messaggioService.save(m1);
        messaggioService.save(m2);
    }
}
