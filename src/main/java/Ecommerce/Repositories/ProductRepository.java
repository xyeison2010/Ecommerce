package Ecommerce.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecommerce.Entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Page<Product> findByNameOrCodeContainingIgnoreCase(String param, String param0, Pageable pageable);

}
