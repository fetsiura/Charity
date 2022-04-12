package pl.charity.core.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImplement {

    private final CategoryRepository categoryRepository;

    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }
}
