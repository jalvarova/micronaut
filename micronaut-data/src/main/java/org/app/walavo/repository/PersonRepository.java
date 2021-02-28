package org.app.walavo.repository;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.app.walavo.model.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "FROM Person p WHERE p.name = :name")
    Optional<Person> findByName(String name);
}
