package isi.articles.articlepublication.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
@Entity
public class Domaine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "domaine", cascade = CascadeType.ALL)
    private List<Article> articles;

    public Domaine() {}

    public Domaine(Long id, String nom, List<Article> articles) {
        this.id = id;
        this.nom = nom;
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
