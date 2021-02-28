package org.app.walavo.mappers;

import io.reactivex.functions.Function;
import org.app.walavo.model.Person;

@FunctionalInterface
public interface PersonMappers {

    void hello();

    Function<Person, Person> updateEntity = (Person entity) -> {
        entity.setId(entity.getId());
        entity.setName(entity.getName());
        entity.setAge(entity.getAge());
        entity.setTelephone(entity.getTelephone());
        return entity;
    };
}
