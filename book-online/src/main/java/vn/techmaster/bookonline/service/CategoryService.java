package vn.techmaster.bookonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.techmaster.bookonline.entity.Category;
import vn.techmaster.bookonline.exception.NotFoundException;
import vn.techmaster.bookonline.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    // Find by id
    public Category findById(String id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("No category with id = " + id));
    }

    // Find all
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    // Add entity
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    // Add entity by request

    // Update entity by request

    // Delete by id
    public void deleteById(String id) {
        categoryRepository.deleteById(id);
    }

    // Find all, pageable order by name
    public Page<Category> findByOrderByNameAsc(Pageable pageable) {
        return categoryRepository.findByOrderByNameAsc(pageable);
    }
}
