package Ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecommerce.Entities.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    public File findByName(String filename);
}
