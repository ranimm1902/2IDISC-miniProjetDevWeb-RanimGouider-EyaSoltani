package isi.articles.articlepublication.Service;

import isi.articles.articlepublication.Model.Domaine;
import isi.articles.articlepublication.Repository.DomaineRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomaineService {
    private final DomaineRepo domaineRepo;

    public DomaineService(DomaineRepo domaineRepo) {
        this.domaineRepo = domaineRepo;
    }

    public Domaine addDomaine(Domaine domaine) {
        return domaineRepo.save(domaine);
    }

    public Domaine updateDomaine(Domaine domaine) {
        return domaineRepo.save(domaine);
    }

    public void deleteDomaine(Long id) {
        domaineRepo.deleteById(id);
    }

    public List<Domaine> findAllDomaines() {
        return domaineRepo.findAll();
    }
}