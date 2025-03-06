package isi.articles.articlepublication.Service;

import isi.articles.articlepublication.Exception.ArticleNotFoundException;
import isi.articles.articlepublication.Exception.UserNotFoundException;
import isi.articles.articlepublication.Model.Article;
import isi.articles.articlepublication.Model.Contribution;
import isi.articles.articlepublication.Model.Utilisateur;
import isi.articles.articlepublication.Repository.ArticleRepo;
import isi.articles.articlepublication.Repository.ContributionRepo;
import isi.articles.articlepublication.Repository.UtilisateurRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UtilisateurService {
    private final UtilisateurRepo utilisateurRepo;
    private final ArticleRepo articleRepo;
    private final ContributionRepo contributionRepo;

    public UtilisateurService(UtilisateurRepo utilisateurRepo, ArticleRepo articleRepo, ContributionRepo contributionRepo) {
        this.utilisateurRepo = utilisateurRepo;
        this.articleRepo = articleRepo;
        this.contributionRepo = contributionRepo;
    }

    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur);
    }

    public List<Utilisateur> findAllUtilisateurs() {
        return utilisateurRepo.findAll();
    }

    public Utilisateur findUtilisateurById(Long id) {
        return utilisateurRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur avec l'ID " + id + " n'existe pas!"));
    }

    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepo.save(utilisateur);
    }

    public void deleteUtilisateurById(Long id) {
        utilisateurRepo.deleteById(id);
    }

    @Transactional
    public void affecterArticleUtilisateur(Long articleId, Long utilisateurId, String type, Date date, String lieu) {
        Article article = articleRepo.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException("Article avec l'ID " + articleId + " n'existe pas!"));
        Utilisateur utilisateur = utilisateurRepo.findById(utilisateurId)
                .orElseThrow(() -> new UserNotFoundException("Utilisateur avec l'ID " + utilisateurId + " n'existe pas!"));

        Contribution contribution = new Contribution();
        contribution.setUtilisateur(utilisateur);
        contribution.setArticles(article);
        contribution.setType(type);
        contribution.setDate(date);
        contribution.setLieu(lieu);

        contributionRepo.save(contribution);
    }
}
