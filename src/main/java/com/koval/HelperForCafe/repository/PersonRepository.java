package com.koval.HelperForCafe.repository;


import com.koval.HelperForCafe.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByLoginAndPassword(String login, String password);
    Optional<Person> findByLogin(String login);
}
