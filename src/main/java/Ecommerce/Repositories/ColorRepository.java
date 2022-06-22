package Ecommerce.Repositories;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import Ecommerce.Entities.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {

    public Color findByName(String name);

    public Page<List<Color>> findByNameContainingIgnoreCase(String name, Pageable page);

}
