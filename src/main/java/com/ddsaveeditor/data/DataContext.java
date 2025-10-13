package com.ddsaveeditor.data;

import com.ddsaveeditor.data.io.IDataReader;

/**
 * An abstract Context to retrieve data
 */
public abstract class DataContext {
    /**
     * Data reader used to retrieve to DataContext
     */
    protected final IDataReader reader;
    /**
     * Creates a DataContext
     * @param reader data reader used to retrieve to DataContext
     */
    public DataContext(IDataReader reader)
    {
        this.reader = reader;
    }
    /**
     * Loads all data
     */
    public abstract void load();
    /**
     * Commits all data
     */
    public abstract void commit();
}
