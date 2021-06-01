package org.ht.com.pe.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ConvertUtil {

    public final static String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
    public final static String ZONE ="America/Lima";
    private final static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static <T> T fileToObject(String path, Class<T> objectResponse) throws IOException {

        return objectMapper.readValue(ConvertUtil.class.getClassLoader().getResourceAsStream(path), objectResponse);
    }

    public static String jsonToString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static <T> T stringToObject(String json, Class<T> objectResponse) throws JsonProcessingException {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.readValue(json, objectResponse);
    }


    public static <T> T decodeObjectTransport(String raw, Class<T> oTransport) throws JsonProcessingException {
        return objectMapper.readValue(raw, oTransport);
    }

    public static <T> T getEntityResult(MongoIterable<Document> jsonData, Class<T> expectedType) {
        return jsonData != null ? objectMapper.convertValue(jsonData.first(), expectedType) : null;
    }

    public static <T> List<T> iterableMongoDocument(MongoIterable<Document> jsonData, Class<T> expectedType) {
        List<T> listResult = new ArrayList<>();
        jsonData.map(json -> objectMapper.convertValue(json, expectedType)).into(listResult);
        return listResult;
    }

    @SuppressWarnings("unchecked")
    public static <T> Map<String, Object> objectToMap(final Object obj) {
        return obj != null ? objectMapper.convertValue(obj, Map.class) : null;
    }

    public static String generatedId() {
        return new ObjectId().toHexString();
    }

}