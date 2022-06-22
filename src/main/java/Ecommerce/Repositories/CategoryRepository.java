package Ecommerce.Repositories;

import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import Ecommerce.Entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Cacheable(value = "colors")
    @Override
    public List<Category> findAll();

}
