package com.ddsaveeditor.file;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

public class JSONFileReader {
    private final Gson gson;
    public JSONFileReader(){
        this.gson = new Gson();
    }

    public <T> T read(String filePath, Class<T> elementType) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, elementType);
        } catch (JsonIOException | JsonSyntaxException e) {
            throw new IOException("Error during JSON processing: " + e.getMessage(), e);
        }
    }

    public <T> Collection<T> readList(String filePath, Class<T> elementType) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            Type collectionType = TypeToken.getParameterized(Collection.class, elementType).getType();
            return gson.fromJson(reader, collectionType);
        } catch (JsonIOException | JsonSyntaxException e) {
            throw new IOException("Error during JSON processing: " + e.getMessage(), e);
        }
    }

    public Map<String, Object> readAsMap(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            Type type = new TypeToken<Map<String, Object>>(){}.getType();
            return gson.fromJson(reader, type);
        } catch (JsonIOException | JsonSyntaxException e) {
            throw new IOException("Error during JSON processing: " + e.getMessage(), e);
        }
    }
}