/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author elbertnilton
 */
public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
