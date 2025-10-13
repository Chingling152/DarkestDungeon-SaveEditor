package com.ddsaveeditor.data.file.json;

import com.ddsaveeditor.data.file.PathProvider;
import com.ddsaveeditor.data.io.DataReaderException;
import com.ddsaveeditor.data.io.IDataReader;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Class to read data from a JSON file
 */
public class JSONFileReader implements IDataReader {
    private final Gson gson;
    private final PathProvider pathProvider;

    /**
     * Creates a reader for JSON files in a specific folder set by {@link JSONFileReader#pathProvider}
     * @param pathProvider the provider to get the folder
     */
    public JSONFileReader(PathProvider pathProvider){
        this.pathProvider = pathProvider;
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }
    /** {@inheritDoc} */
    public <T> T read(String file, Class<T> elementType) throws DataReaderException {
        try (FileReader reader = new FileReader(this.pathProvider.getFullPath(file + ".json"))) {
            return gson.fromJson(reader, elementType);
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            throw new DataReaderException("Error during JSON processing: " + e.getMessage());
        }
    }
    /** {@inheritDoc} */
    public <T> Collection<T> readList(String file, Class<T> elementType) throws DataReaderException {
        try (FileReader reader = new FileReader(this.pathProvider.getFullPath(file + ".json"))) {
            Type collectionType = TypeToken.getParameterized(Collection.class, elementType).getType();
            return gson.fromJson(reader, collectionType);
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            throw new DataReaderException("Error during JSON processing: " + e.getMessage());
        }
    }
}