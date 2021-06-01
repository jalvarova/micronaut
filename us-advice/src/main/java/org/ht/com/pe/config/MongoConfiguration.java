package org.ht.com.pe.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import io.micronaut.context.annotation.Value;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.ParameterizedType;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
public abstract class MongoConfiguration<T> {

    private final static String FORMAT_CAMEL_CASE = String.format(
            "%s|%s|%s",
            "(?<=[A-Z])(?=[A-Z][a-z])",
            "(?<=[^A-Z])(?=[A-Z])",
            "(?<=[A-Za-z])(?=[^A-Za-z])");
    private final static String SPLIT_CAMEL_CASE = "-";

    @Value(value = "${mongodb.database}")
    private String database;

    @Inject
    public MongoClient mongoClient;


    @SuppressWarnings("unchecked")
    public MongoCollection<T> getInstance() {
        Class<T> persistentClass = ((Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);
        String simpleName = persistentClass.getSimpleName();
        String mongoEntity = splitCamelCase(simpleName);
        return mongoClient
                .getDatabase(database)
                .getCollection(mongoEntity, persistentClass);
    }

    static String splitCamelCase(String s) {
        return s.replaceAll(FORMAT_CAMEL_CASE, SPLIT_CAMEL_CASE).toLowerCase();
    }

    private static String reverseProperCase(String text) {
        String camelCase = Stream.of(text.split("[^a-zA-Z0-9]"))
                .map(v -> v.substring(0, 1).toUpperCase() + v.substring(1).toLowerCase())
                .collect(Collectors.joining());
        return camelCase.toLowerCase().substring(0, 1) + camelCase.substring(1);
    }
}
