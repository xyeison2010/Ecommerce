package Ecommerce.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Ecommerce.Entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
