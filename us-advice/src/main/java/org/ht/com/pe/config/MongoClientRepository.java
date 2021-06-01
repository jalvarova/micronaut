package org.ht.com.pe.config;

import io.reactivex.Observable;
import io.reactivex.Single;
import reactor.core.publisher.Mono;

import javax.inject.Singleton;

@Singleton
public abstract class MongoClientRepository<T, O> extends MongoConfiguration<T> {

    public abstract Single<T> save(T t);

    public abstract Mono<T> delete(O o);

    public abstract Single<T> update(O o, T t);

    public abstract Observable<T> findByAll();

    public abstract Single<T> findById(O o);


}
