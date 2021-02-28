package org.app.walavo.bussiness;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import org.app.walavo.model.Person;
import org.app.walavo.repository.PersonRepository;
import org.app.walavo.util.PersonUtil;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Objects;

@Slf4j
@Singleton
public class ProductService {

    @Inject
    private PersonRepository personRepository;

    public Single<Person> savePerson(Person person) throws Exception {
        validatePersonExists(person);
        return Single.just(personRepository.save(person))
                .onErrorReturnItem(Person.instance());
    }

    public Single<Person> updatePerson(Person person) throws Exception {
        validatePersonExists(person);
        return findByIdPersons(person.getId())
                .map(personFound -> PersonUtil.updateEntity(person, personFound))
                .map(personRepository::update)
                .onErrorReturnItem(Person.instance());
    }


    public Observable<Person> findAllPersons() {
        return Observable.fromIterable(personRepository.findAll())
                .subscribeOn(Schedulers.io());
    }

    public Single<Person> findByIdPersons(Long id) {
        return Single.just(personRepository.findById(id).orElse(Person.instance()));
    }

    private void validatePersonExists(Person person) throws Exception {
        if (Objects.isNull(person.getId())) {
            Person personFound = personRepository.findByName(person.getName()).orElse(null);
            if (Objects.nonNull(personFound))
                throw new Exception("Exists Person");
        } else {
            Person personFound = personRepository.findById(person.getId()).orElse(null);
            if (Objects.isNull(personFound))
                throw new Exception("Not Exists Person");
        }
    }
}
