package Ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecommerce.Entities.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {

}
