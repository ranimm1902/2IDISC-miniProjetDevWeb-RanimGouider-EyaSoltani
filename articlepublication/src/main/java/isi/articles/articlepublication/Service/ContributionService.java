package isi.articles.articlepublication.Service;

import isi.articles.articlepublication.Exception.ContributionNotFoundException;
import isi.articles.articlepublication.Model.Contribution;
import isi.articles.articlepublication.Repository.ContributionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributionService {
    private final ContributionRepo contributionRepo;

    public ContributionService(ContributionRepo contributionRepo) {
        this.contributionRepo = contributionRepo;
    }

    public Contribution addContribution(Contribution contribution) {
        return contributionRepo.save(contribution);
    }

    public List<Contribution> findAllContributions() {
        return contributionRepo.findAll();
    }

    public Contribution findContributionById(Long id) {
        return contributionRepo.findById(id)
                .orElseThrow(() -> new ContributionNotFoundException("Contribution avec l'ID " + id + " n'existe pas!"));
    }

    public void deleteContribution(Long id) {
        contributionRepo.deleteById(id);
    }
}
