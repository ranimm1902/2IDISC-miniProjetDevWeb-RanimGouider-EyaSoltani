package isi.articles.articlepublication.Model;

import jakarta.persistence.*;
import java.util.Date;
@Entity
public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    private Long id;
    private String type;
    private Date date;
    private String lieu;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;

    public Contribution() {}

    public Contribution(Long id, String type, Date date, String lieu, Utilisateur utilisateur, Article article) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.lieu = lieu;
        this.utilisateur = utilisateur;
        this.article = article;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Article getArticles() {
        return article;
    }

    public void setArticles(Article article) {
        this.article = article;
    }
}

