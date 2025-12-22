package com.ddsaveeditor.data.file;

/**
 * The provider to get a path
 */
public abstract class PathProvider {
    /**
     * @return the default base path
     */
    public abstract String getBasePath();
    /**
     * Gets the full path to get a file
     * @param file The file path
     * @return a string with the path of param file
     */
    public abstract String getFullPath(String file);
}
