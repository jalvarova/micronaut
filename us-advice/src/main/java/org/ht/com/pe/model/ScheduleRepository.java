package org.ht.com.pe.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.bson.conversions.Bson;
import org.ht.com.pe.config.MongoClientRepository;
import reactor.core.publisher.Mono;

import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static org.ht.com.pe.beans.SchedulerMapper.scheduleBuild;

@Singleton
public class ScheduleRepository extends MongoClientRepository<Schedule, String> {


    @Override
    public Single<Schedule> save(Schedule schedule) {
        MongoCollection<Schedule> mongoCollection = getInstance();
        mongoCollection.insertOne(scheduleBuild());
        Bson filter = and(eq("scheduleName", "atten-error-disk"));
        return Single.just(
                Objects.requireNonNull(
                        mongoCollection
                                .find(filter)
                                .first()
                ));
    }

    @Override
    public Mono<Schedule> delete(String t) {
        return null;
    }

    @Override
    public Single<Schedule> update(String id,Schedule schedule) {
        MongoCollection<Schedule> mongoCollection = getInstance();
        Bson filter = eq("scheduleOrder", id);
        List<Bson> oObjectToUpdates = new ArrayList<>();
        oObjectToUpdates.add(Updates.set("scheduleDate", LocalDateTime.now()));
        mongoCollection.updateOne(filter, oObjectToUpdates);
        Schedule scheduleFound = mongoCollection.find(filter).first();
        return Single.just(Objects.requireNonNull(scheduleFound));
    }

    @Override
    public Single<Schedule> findById(String id) {
        MongoCollection<Schedule> mongoCollection = getInstance();
        Bson filter = eq("scheduleOrder", id);
        return Single.just(Objects.requireNonNull(mongoCollection.find(filter).projection(Projections.excludeId()).first()));
    }

    @Override
    public Observable<Schedule> findByAll() {
        MongoCollection<Schedule> mongoCollection = getInstance();
        //Bson filter = eq("scheduleOrder", id);
        FindIterable<Schedule> findIterable = mongoCollection.find().projection(Projections.excludeId());
        return Observable
                .just(findIterable)
                .flatMap(Observable::fromIterable);
    }

}
