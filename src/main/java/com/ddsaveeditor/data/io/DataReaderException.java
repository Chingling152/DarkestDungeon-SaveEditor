package com.ddsaveeditor.data.io;

/**
 * A generic exception to data reading
 * It might become abstract
 */
public class DataReaderException extends RuntimeException {
    public DataReaderException(String message) {
        super(message);
    }
}
