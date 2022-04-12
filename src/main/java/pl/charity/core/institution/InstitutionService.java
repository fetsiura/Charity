package pl.charity.core.institution;

import java.util.List;

public interface InstitutionService {

    List<Institution> findAll();
    void add(Institution institution);
    void delete(Long id);

}
