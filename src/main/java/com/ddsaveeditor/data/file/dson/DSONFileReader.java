package com.ddsaveeditor.data.file.dson;

import com.ddsaveeditor.data.file.PathProvider;
import com.ddsaveeditor.data.io.DataReaderException;
import com.ddsaveeditor.data.io.IDataReader;
import com.ddsaveeditor.save.roster.data.RosterData;
import com.ddsaveeditor.save.roster.data.RosterDataTypeAdapter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * File reader for Darkest Dungeon's JSON file
 */
public class DSONFileReader implements IDataReader {
    private final Gson gson;
    private final PathProvider provider;

    /**
     * Creates a reader for JSON files in a specific folder set by provider
     * @param provider the provider to get the base folder of the DSON files
     */
    public DSONFileReader(PathProvider provider){
        this.provider = provider;
        this.gson = new GsonBuilder()//TODO: inject this (Maybe create a contract for it)
                .registerTypeAdapter(RosterData.class, new RosterDataTypeAdapter())
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    /**
     * Gets one item from a DSON(.json) file
     * @param file the .json file to be read (no need to use .json)
     * @param elementType the return type
     * @return One item from the DSON file or null if not found
     * @param <T> any type to return from the DSON file
     * @throws DataReaderException Any exception during DSON processing
     */
    public <T> T read(String file, Class<T> elementType) throws DataReaderException {
        try {
            if(!file.endsWith(".json")){
                file+=".json";
            }
            Path fullPath = Paths.get(this.provider.getFullPath(file));
            byte[] fileData = Files.readAllBytes(fullPath);
            DSONReader reader = new DSONReader(fileData, DSONReader.UnhashBehavior.POUNDUNHASH);
            String json = reader.getJSonString(0, false);
            return gson.fromJson(json, elementType);
        }catch (Exception e){
            throw new DataReaderException("Error during DSON processing: " + e.getMessage());
        }
    }

    /**
     * Gets all items from a DSON(.json) file
     * @param file the .json file to be read (no need to use .json)
     * @param elementType the return type of the collection
     * @return A collection with all items from the DSON file
     * @param <T> any type to return from the DSON file
     * @throws DataReaderException Any exception during DSON processing
     */
    public <T> Collection<T> readList(String file, Class<T> elementType) throws DataReaderException {
        try {
            Path fullPath = Paths.get(this.provider.getFullPath(file + ".json"));
            byte[] fileData = Files.readAllBytes(fullPath);
            DSONReader reader = new DSONReader(fileData, DSONReader.UnhashBehavior.POUNDUNHASH);
            String json = reader.getJSonString(0, false);
            Type collectionType = TypeToken.getParameterized(Collection.class, elementType).getType();
            return gson.fromJson(json, collectionType);
        }catch (Exception e){
            throw new DataReaderException("Error during DSON processing: " + e.getMessage());
        }
    }
}
