package com.ddsaveeditor.data.file.json.util;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public final class JSONReaderUtil {
    private JSONReaderUtil() { }
    /**
     *
     * @param in
     * @param type
     * @return
     * @param <T> any valid number
     * @throws IOException
     */
    public static <T> T nextNumber(JsonReader in, Class<T> type) throws IOException{
        if(in.peek() != JsonToken.NUMBER)
            throw new IllegalArgumentException();

        if(type == int.class || type == Integer.class)
            return type.cast(in.nextInt());

        if (type == double.class || type == Double.class)
            return type.cast(in.nextDouble());

        if(type == long.class || type == Long.class)
            return type.cast(in.nextLong());

        throw new IllegalArgumentException();
    }
    /**
     *
     * @param in
     * @param type
     * @return
     * @param <T> any type
     * @throws IOException
     */
    public static <T> T nextGeneric(JsonReader in, Class<T> type) throws IOException {
        switch (in.peek()){
            case NUMBER:
                return nextNumber(in, type);
            case BOOLEAN:
                return type.cast(in.nextBoolean());
            case STRING:
                return type.cast(in.nextString());
            case NULL:
                return null;
            default:
                throw new IllegalArgumentException();
        }
    }
    /**
     *
     * @param in
     * @param type
     * @return
     * @param <T> any type
     * @throws IOException
     */
    public static <T> Collection<T> nextArray(JsonReader in, Class<T> type) throws IOException {
        ArrayList<T> result = new ArrayList<>();

        in.beginArray();
        while (in.peek() != JsonToken.END_ARRAY){
            result.add(nextGeneric(in, type));
        }
        in.endArray();

        return new ArrayList<>(result);
    }
}
