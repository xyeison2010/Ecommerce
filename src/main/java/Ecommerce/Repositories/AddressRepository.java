package Ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Ecommerce.Entities.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {

}
