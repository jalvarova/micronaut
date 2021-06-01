package org.app.walavo.util;

import org.app.walavo.model.Person;

public final class PersonUtil {

    public static Person updateEntity(Person entity, Person personFound) {
        personFound.setName(entity.getName());
        personFound.setLastName(entity.getLastName());
        personFound.setAge(entity.getAge());
        personFound.setTelephone(entity.getTelephone());
        personFound.setDocument(entity.getDocument());
        personFound.setEmail(entity.getEmail());
        personFound.setAddress(entity.getAddress());
        personFound.setBirthDate(entity.getBirthDate());
        personFound.setGender(entity.getGender());
        return personFound;
    }
}
