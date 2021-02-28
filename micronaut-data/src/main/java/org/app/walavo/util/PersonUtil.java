package org.app.walavo.util;

import org.app.walavo.model.Person;

public final class PersonUtil {

    public static Person updateEntity(Person entity, Person personFound) {
        personFound.setName(entity.getName());
        personFound.setAge(entity.getAge());
        personFound.setTelephone(entity.getTelephone());
        return personFound;
    }
}
