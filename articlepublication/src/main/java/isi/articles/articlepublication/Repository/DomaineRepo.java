package isi.articles.articlepublication.Repository;

import isi.articles.articlepublication.Model.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineRepo extends JpaRepository<Domaine, Long> {
}
