package Ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecommerce.Entities.Rating;


@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
