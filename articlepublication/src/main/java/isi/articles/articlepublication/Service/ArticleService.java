package isi.articles.articlepublication.Service;

import isi.articles.articlepublication.Exception.ArticleNotFoundException;
import isi.articles.articlepublication.Exception.DomaineNotFoundException;
import isi.articles.articlepublication.Model.Article;
import isi.articles.articlepublication.Model.Domaine;
import isi.articles.articlepublication.Repository.ArticleRepo;
import isi.articles.articlepublication.Repository.DomaineRepo;

import java.util.List;

public class ArticleService {
    private final ArticleRepo articlerepo;
    private final DomaineRepo domainerepo;

    public ArticleService(ArticleRepo articlerepo, DomaineRepo domainerepo) {
        this.articlerepo = articlerepo;
        this.domainerepo = domainerepo;
    }

    public Article addArticle(Article article) {
        return articlerepo.save(article);
    }

    public List<Article> getAllArticles() {
        return articlerepo.findAll();
    }

    public Article getArticleById(Long id) {
        return articlerepo.findById(id).orElseThrow(() -> new ArticleNotFoundException("Aucun article trouvé!"));
    }

    public Article updateArticle(Article article) {
        return articlerepo.save(article);
    }

    public void deleteArticleById(Long id) {
        articlerepo.deleteById(id);
    }

    public List<Article> getArticlesByDomaine(Long domaineId) {
        Domaine domaine = domainerepo.findById(domaineId).orElseThrow(() -> new DomaineNotFoundException("Domaine n'existe pas!"));
        return articlerepo.findArticleByDomaineContaining(domaine.getId());
    }

    public List<Article> getArticlesByMotCle(String keyword) {
        List<Article> articles = articlerepo.findArticleByMotclesContaining(keyword);
        if (articles.isEmpty()) {
            throw new ArticleNotFoundException("Aucun article avec le mot-clé " + keyword + " n'a été trouvé!");
        }
        return articles;
    }

    public void affecterArticleDomaine(Long articleId, Long domaineId) {
        Article article = articlerepo.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException("Article n'existe pas: " + articleId));
        Domaine domaine = domainerepo.findById(domaineId)
                .orElseThrow(() -> new DomaineNotFoundException("Domaine n'existe pas: " + domaineId));
        article.setDomaine(domaine);
        articlerepo.save(article);
    }
}
