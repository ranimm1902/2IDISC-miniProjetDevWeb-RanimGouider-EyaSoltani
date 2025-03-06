package isi.articles.articlepublication.Model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Date;

@Entity
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String pwd;
    private String dateEmbauche;
    private String etablissementOrigine;
    private String dernierDiplome;
    private String grade;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String imageUrl;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Contribution> contributions;

    public enum Role {ADMIN, MOD, USER}

    public Utilisateur() {}

    public Utilisateur(Long id, String nom, String prenom, String email, String pwd, String dateEmbauche, String etablissementOrigine, String dernierDiplome, String grade, Role role, String imageUrl, List<Contribution> contributions) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pwd = pwd;
        this.dateEmbauche = dateEmbauche;
        this.etablissementOrigine = etablissementOrigine;
        this.dernierDiplome = dernierDiplome;
        this.grade = grade;
        this.role = role;
        this.imageUrl = imageUrl;
        this.contributions = contributions;
    }


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public String getPrenom() {return prenom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPwd() {return pwd;}
    public void setPwd(String pwd) {this.pwd = pwd;}
    public String getDateEmbauche() {return dateEmbauche;}
    public void setDateEmbauche(String dateEmbauche) {this.dateEmbauche = dateEmbauche;}
    public String getEtablissementOrigine() {return etablissementOrigine;}
    public void setEtablissementOrigine(String etablissementOrigine) {this.etablissementOrigine = etablissementOrigine;}
    public String getDernierDiplome() {return dernierDiplome;}
    public void setDernierDiplome(String dernierDiplome) {this.dernierDiplome = dernierDiplome;}
    public String getGrade() {return grade;}
    public void setGrade(String grade) {this.grade = grade;}
    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}
    public String getImageUrl() {return imageUrl;}
    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}
    public List<Contribution> getContributions() {return contributions;}
    public void setContributions(List<Contribution> contributions) {this.contributions = contributions;}


}
