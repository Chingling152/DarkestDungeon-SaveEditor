package com.ddsaveeditor.game.data;

import com.ddsaveeditor.data.file.PathProvider;

import java.nio.file.Paths;

/**
 * Provider for paths for the game files
 */
public class GamePathProvider extends PathProvider {
    private final String basePath;
    public GamePathProvider(String basePath){
        this.basePath = basePath;
    }

    /** {@inheritDoc} */
    @Override
    public String getBasePath() {
        return this.basePath;
    }
    /** {@inheritDoc} */
    @Override
    public String getFullPath(String file) {
        if(!this.basePath.endsWith("\\")){
            return Paths.get(this.basePath + "\\" + file).toString();
        }
        return Paths.get(this.basePath + file).toString();
    }
}
