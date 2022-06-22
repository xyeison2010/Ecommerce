package Ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecommerce.Entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
