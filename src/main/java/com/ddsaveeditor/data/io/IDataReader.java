package com.ddsaveeditor.data.io;

import java.util.Collection;
import java.util.Optional;

/**
 * Interface to read data from a data source
 */
public interface IDataReader {
    /**
     * Read and convert one item from a partition
     * It has no treatment if a partition has multiple items (so use {@link IDataReader#readList(String, Class) to get multiple})
     * @param partition the partition to be read
     * @param elementType the return type
     * @return One item from partition or null if not found
     * @param <T> any type to return from datasource
     * @throws DataReaderException Any exception when trying to get the data
     */
    <T> Optional<T> read(String partition, Class<T> elementType) throws DataReaderException;
    /**
     * Read and convert a list of items from a partition
     * @param partition the partition to be read
     * @param elementType the return type of the collection
     * @return A list with all items existing inside the partition
     * @param <T> any type to return from datasource
     * @throws DataReaderException Any exception when trying to get the data
     */
    <T> Collection<T> readList(String partition, Class<T> elementType) throws DataReaderException;
}
