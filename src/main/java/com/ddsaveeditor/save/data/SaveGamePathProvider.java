package com.ddsaveeditor.save.data;

import com.ddsaveeditor.data.file.PathProvider;

import java.nio.file.Paths;

/**
 *
 */
public class SaveGamePathProvider extends PathProvider {
    private final String basePath;
    /**
     *
     * @param basePath
     */
    public SaveGamePathProvider(String basePath){
        this.basePath = basePath;
    }
    /**
     *
     * @return
     */
    public SaveGamePathProvider useDefault(){
        return new SaveGamePathProvider("");
    }
    /** {@inheritDoc} **/
    public String getBasePath() {
        return this.basePath;
    }
    /** {@inheritDoc} **/
    public String getFullPath(String file) {
        if(!this.basePath.endsWith("\\")){
            return Paths.get(this.basePath + "\\" + file).toString();
        }
        return Paths.get(this.basePath + file).toString();
    }
}
