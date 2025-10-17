package com.ddsaveeditor.data;

import java.util.Collection;

public class DataCollection<T> extends ReadonlyDataCollection<T>{
    public DataCollection(Collection<T> collection){
        super(collection);
    }
}
