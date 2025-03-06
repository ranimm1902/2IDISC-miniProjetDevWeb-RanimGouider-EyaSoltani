package isi.articles.articlepublication.Repository;

import isi.articles.articlepublication.Model.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepo extends JpaRepository<Contribution, Long> {
}
