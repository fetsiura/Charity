package pl.charity.core.institution;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstitutionServiceImplement implements InstitutionService{
    
    private final InstitutionRepository institutionRepository;
    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public void add(Institution institution) {
        institutionRepository.save(institution);
        log.info("Institution by name {} added",institution.getName());
    }

    @Override
    public void delete(Long id) {

        institutionRepository.deleteById(id);
        log.info("Institution by id {} deleted",id);

    }
}
