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

    public DSONFileReader(PathProvider provider){
        this.provider = provider;
        this.gson = new GsonBuilder()
                .registerTypeAdapter(RosterData.class, new RosterDataTypeAdapter())
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Override
    public <T> T read(String file, Class<T> elementType) throws DataReaderException {
        try {
            Path fullPath = Paths.get(this.provider.getFullPath(file + ".json"));
            byte[] fileData = Files.readAllBytes(fullPath);
            DSONReader reader = new DSONReader(fileData, DSONReader.UnhashBehavior.POUNDUNHASH);
            String json = reader.getJSonString(0, false);
            return gson.fromJson(json, elementType);
        }catch (Exception e){
            throw new DataReaderException("Error during JSON processing: " + e.getMessage());
        }
    }

    @Override
    public <T> Collection<T> readList(String file, Class<T> elementType) throws DataReaderException {
        try {
            Path fullPath = Paths.get(this.provider.getFullPath(file + ".json"));
            byte[] fileData = Files.readAllBytes(fullPath);
            DSONReader reader = new DSONReader(fileData, DSONReader.UnhashBehavior.POUNDUNHASH);
            String json = reader.getJSonString(0, false);
            Type collectionType = TypeToken.getParameterized(Collection.class, elementType).getType();
            return gson.fromJson(json, collectionType);
        }catch (Exception e){
            throw new DataReaderException("Error during JSON processing: " + e.getMessage());
        }
    }
}
