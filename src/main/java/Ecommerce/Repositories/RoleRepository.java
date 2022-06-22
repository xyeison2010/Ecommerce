package Ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Ecommerce.Entities.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByRole(String user);

}
